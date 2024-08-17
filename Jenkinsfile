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
                bat 'echo "Running build..."'
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'echo "Running tests..."'
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    bat 'echo "Building Docker image..."'
                    bat 'docker build -t java_app .'
                }
            }
        }
                stage('Clean Up') {
    steps {
        script {
            bat 'docker rm -f java_app_container || true'  // Mevcut container'ı sil
        }
    }
}
           stage('Run Docker Container') {
            steps {
                script {
                    bat 'echo "Running Docker container..."'
                    bat 'docker run -d --name java_app_container -p 8081:8080 java_app'
                }
            }
           }


        stage('Deploy') {
            steps {
                script {
                    bat 'echo "Running deployment..."'
                    withCredentials([usernamePassword(credentialsId: 'docker_token', passwordVariable: 'Ozgenur.0519', usernameVariable: 'ozgenur19')]) {
                        bat 'docker login -u ozgenur19 -p Ozgenur.0519'
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



/*pipeline {
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
                bat 'echo "Running build..."'
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                script {
                    bat 'echo "Running deployment..."'
                     withCredentials([usernamePassword(credentialsId: 'docker_token', passwordVariable: 'Ozgenur.0519', usernameVariable: 'ozgenur19')]) {
                    bat 'docker login -u ozgenur19 -p Ozgenur.0519'
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
*/
