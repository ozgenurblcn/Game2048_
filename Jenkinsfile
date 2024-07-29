pipeline {
    agent any

    stages {
        stage('Klonlama') {
            steps {
                git 'https://github.com/ozgenur19/Game2048.git'
            }
        }
        
        stage('Derleme') {
            steps {
                // JavaFX projesini derlemek için gerekli komutlar
                sh 'javac -d out src/*.java'
            }
        }
        
        stage('Test') {
            steps {
                // Test aşaması
                sh 'java -cp out Game2048'
            }
        }
    }
}
