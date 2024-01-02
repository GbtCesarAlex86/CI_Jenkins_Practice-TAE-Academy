pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'javac Main.java'
            }
        }
        stage('Run') {
            steps {
                echo 'Running...'
                bat 'java Main'
            }
        }
    }
}