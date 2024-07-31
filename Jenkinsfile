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
                sh 'echo "Building the project..."'
                // Build komutlarını ekleyin
            }
        }

        stage('Test') {
            steps {
                sh 'echo "Running tests..."'
                // Test komutlarını ekleyin
            }
        }

        stage('Deploy') {
            steps {
                sh 'echo "Deploying application..."'
                // Deploy komutlarını ekleyin
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
