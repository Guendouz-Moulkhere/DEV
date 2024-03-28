pipeline {
    agent any
    
    environment {
        // Spécifiez le chemin d'installation de Maven
        MVN_HOME = tool name: 'Maven', type: 'maven'
    }
    
    stages {
        stage('Build') {
            steps {
                // Exécute la commande Maven pour nettoyer et construire le projet
                sh "${MVN_HOME}/bin/mvn clean package"
            }
        }
        stage('Test') {
            steps {
                // Exécute la commande Maven pour exécuter les tests
                sh "${MVN_HOME}/bin/mvn test"
            }
        }
        stage('Deploy') {
            steps {
                // Exécute la commande Maven pour déployer l'application (à adapter selon les besoins)
                sh "${MVN_HOME}/bin/mvn deploy"
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
