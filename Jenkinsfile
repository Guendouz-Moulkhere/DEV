pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package' // Commande pour construire le projet avec Maven
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test' // Commande pour exécuter les tests unitaires
            }
        }
        stage('Deploy') {
            steps {
                bat 'mvn deploy' // Commande pour déployer l'application
            }
        }
    }
    
    post {
        always {
            // Étapes à exécuter toujours à la fin du pipeline
            echo 'Pipeline terminé'
        }
        success {
            // Étapes à exécuter en cas de succès du pipeline
            echo 'Le pipeline s\'est terminé avec succès'
        }
        failure {
            // Étapes à exécuter en cas d'échec du pipeline
            echo 'Le pipeline a échoué'
        }
    }
}
