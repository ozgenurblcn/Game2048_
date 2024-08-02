pipeline {
    agent any
    environment {         PATH = "C:\\Program Files\\Jenkins\\gradle-8.9\\bin;$PATH" 
                }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ozgenur19/Game2048.git'
            }
        }

        stage('Build') {
            steps {
               bat 'echo "Running build..."'

               
            }
        }

        stage('Test') {
            steps {
               bat 'gradle -v'
                
                
               
            }
        }

        stage('Deploy') {
            steps {
          script {
                bat 'echo "Running deployed..."'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
