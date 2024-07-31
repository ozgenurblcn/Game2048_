pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/ozgenur19/Game2048.git'
            }
        }

        stage('Build') {
            steps {
                sh 'echo "Building the project..."'
               
                sh 'mvn clean install' 
                
                
            }
        }

        stage('Test') {
            steps {
                sh 'echo "Running tests..."'
                sh 'mvn test' 
            
            }
        }

        stage('Deploy') {
            steps {
                sh 'echo "Deploying application..."'
                
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
