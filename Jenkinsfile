pipeline { 
agent any 
    stages { 
        
        stage ('Build') { 
            steps{
                echo("Building")
                }
            }
            
            stage ('Deploy DEV') { 
            steps{
                echo("Dev deployment")
                }
            }
            
            stage ('Deploy QA') { 
            steps{
                echo("QA deployment")
                }
            }
            
            stage ('Sanity Test') { 
            steps{
                echo("sanity test on stage")
                }
            }
            
            stage ('Deploy Prod') { 
            steps{
                echo("Prod deployment")
                }
            }
            
        }
}         