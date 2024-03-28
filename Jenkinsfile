pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                // Exécuter votre application Java sans utiliser nohup
                bat 'start java -jar ApiApplication.jar'
            }
        }
    }
}
