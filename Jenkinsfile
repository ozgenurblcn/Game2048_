pipeline {
    agent any
    environment { 
        PATH = "C:\\Program Files\\apache-maven-3.9.8\\bin;$PATH" 
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ozgenur19/Game2048.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    bat 'docker build -t java_app .'
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    bat 'docker rm -f java_app_container || true'
                    bat 'docker run -d --name java_app_container -p 8081:8080 java_app'
                }
            }
        }
           stage('Test') {
            steps {
                bat 'echo "Running tests..."'
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker_token', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        bat 'docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%'
                        bat 'docker tag java_app ozgenur19/java_app:latest'
                        bat 'docker push ozgenur19/java_app:latest'
                        bat 'docker logout'
                    }
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


