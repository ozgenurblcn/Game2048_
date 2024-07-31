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
                bat 'gradlew.bat build' // gradlew yerine gradlew.bat kullanın
            }
        }

        stage('Test') {
            steps {
                bat 'echo "Running tests..."'
                bat 'gradlew.bat test' // gradlew yerine gradlew.bat kullanın
            }
        }

        stage('Deploy') {
            steps {
                bat 'echo "Deploying application..."'
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
