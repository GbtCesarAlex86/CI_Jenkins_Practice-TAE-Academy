pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'javac Main.java'
            }
        }
        stage('Run') {
            steps {
                echo 'Running...'
                sh 'java Main'
            }
        }
    }
}