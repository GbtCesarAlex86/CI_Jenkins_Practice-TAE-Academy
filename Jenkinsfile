pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                dir('com/globant') {
                    bat 'javac Main.java'
                }
            }
        }
        stage('Run') {
            steps {
                echo 'Running...'
                dir('com/globant') {
                    bat 'java Main'
                }
            }
        }
    }
}