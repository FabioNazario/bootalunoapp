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
       
        stage('Integration Test') {
            steps {
                sh 'mvn verify'
            }
        }
        
        stage("Docker Build/Push") {
	    steps {
	        sh 'docker build -t fabionazario/bootalunoapp:firsttry . '
		sh 'docker push fabionazario/bootalunoapp:firsttry'
	    }
	}  

        stage('Deploy Kubernets') {
            steps {
                echo 'Não consegui fazer'
            }
        }
    }
}  
