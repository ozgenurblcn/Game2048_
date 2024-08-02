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
               bat 'echo "Running build..."'
               
            }
        }

        stage('Test') {
            steps {
                bat 'echo "Running testing..."'
                
                
               
            }
        }

        stage('Deploy') {
            steps {
             
            echo 'Building Docker image...'
                    docker.build('my-app-image')
                
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
