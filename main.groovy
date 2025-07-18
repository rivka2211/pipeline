pipeline{
       agent { label 'verisoft-2' }
        options {
            skipStagesAfterUnstable()
            // disableConcurrentBuild()
        }
        environment {
            PROJECT_NAME = 'pipeline-R-E'
        }
        parameters {
            choice(choices: ["cake", "bread", "milk"], name: "Food")
            string(defaultValue:"Rivki",name:"firstName",description:"my first name")
            string(defaultValue: "Elfenbein", name: "lastName", description: "my last name")
        }
    stages {
        stage("print parameters"){
            steps{
                echo "parameters ${params.Food}"
                echo "parameters ${params}"
                echo "environment variable ${env.PROJECT_NAME}"
                echo "${env.BUILD_NAME}"
            }
        }
    }  

}