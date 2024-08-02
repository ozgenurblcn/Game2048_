pipeline {
    agent any
    environment {         PATH = "C:\Program Files\Jenkins\gradle-8.9\bin;$PATH" 
                }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ozgenur19/Game2048.git'
            }
        }

        stage('Build') {
            steps {
               bat 'docker build -t myjenkins-blueocean:2.452.3-1'

               
            }
        }

        stage('Test') {
            steps {
               bat 'gradle build.'
                
                
               
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
