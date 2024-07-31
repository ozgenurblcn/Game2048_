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
                bat 'echo "Building the project..."'
                bat 'gradlew build'
            }
        }

        stage('Test') {
            steps {
                bat 'echo "Running tests..."'
                bat 'gradlew test'
            }
        }

        stage('Deploy') {
            steps {
                bat 'echo "Deploying application..."'
                bat 'deploy.bat'
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
