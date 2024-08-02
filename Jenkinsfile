pipeline {
    agent any

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
                bat 'echo "Running testing..."'
                
                
               
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
