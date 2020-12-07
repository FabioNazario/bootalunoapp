pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Buid') {
            steps {
                git 'https://github.com/FabioNazario/alunoapp.git'
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            
            post{
                success{
                    archiveArtifacts 'target/*.war'
                }
            }
        }
        stage('Quality Analyses') {
            steps {
                sh 'mvn sonar:sonar'
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
