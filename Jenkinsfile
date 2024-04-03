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
    }
}
