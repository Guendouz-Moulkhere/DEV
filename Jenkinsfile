pipeline {
    agent any
    environment {
        MAVEN_HOME = 'C:\\dev\\apache-maven-3.9.6'
        PATH = "$MAVEN_HOME\\bin;$PATH" // Utilisez ';' comme séparateur sur Windows
    }
    stages {
        stage('Build') {
            steps {
                // Utilisez le chemin complet vers Maven pour éviter les erreurs de résolution du chemin
                script {
                    def mvnHome = tool name: 'Maven', type: 'maven'
                    // Ajoutez un 'bat' avant la commande pour exécuter la commande sur Windows
                    bat "${mvnHome}/bin/mvn clean install"
                }
            }
        }
        stage('Test') {
            steps {
                // Utilisation de la commande 'mvn test' pour exécuter les tests Maven
                bat "${MAVEN_HOME}/bin/mvn test"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                // Ajoutez ici les commandes pour déployer votre application
            }
        }
    }
}
