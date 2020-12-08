pipeline { 
    agent any
 
    tools {
        // Install the Maven version configured as "M3" and add it to the path. 
        maven "M3"
    } 

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/FabioNazario/bootalunoapp.git'
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            
            post{
                success{
                    archiveArtifacts 'target/*.war'
                }
            }
        }
        
        stage("Deploy Docker") {
		steps {
		       /*script {
			 	try {
			      		sh 'docker stop bootalunoapp && docker rm bootalunoapp'                            
			  	} catch (Exception e) {
			      		sh 'Nao foi possivel remover" '
			  	}
		       	}*/

		       	sh 'docker build -t fabionazario/bootalunoapp:firsttry . '
			sh 'docker push fabionazario/bootalunoapp:firsttry'
		}
	}  

        stage('Quality Analyses') {
            steps {
                echo 'Sonar'
                //sh 'mvn sonar:sonar'
            }
        }
        stage('Repository') {
            steps {
                echo 'Repository'
            }
        }
        stage('Deploy Tomcat') {
            steps {
                echo 'Deploy Tomcat'
            }
        }
    }
}  
