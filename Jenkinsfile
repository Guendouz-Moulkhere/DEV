pipeline {
    agent any
    environment {
    
        MAVEN_HOME = 'C:\\dev\\apache-maven-3.9.6'
        
        PATH = "$MAVEN_HOME\\bin:$PATH"
    }
    stages {
        stage('Build') {
            steps {
                
                sh 'mvn clean install'
            }
        }
    }
}
