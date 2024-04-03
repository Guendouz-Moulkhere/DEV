pipeline {
    agent any
    environment {
        MAVEN_HOME = 'C:\\dev\\apache-maven-3.9.6'
        PATH = "$MAVEN_HOME\\bin;$PATH" 
    }
    stages {
        stage('Build') {
            steps {
                script {
                    def mvnHome = tool name: 'Maven', type: 'maven'
                    bat "${mvnHome}/bin/mvn clean install"
                }
            }
        }
        stage('Test') {
            steps {
                bat "${MAVEN_HOME}/bin/mvn test"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
