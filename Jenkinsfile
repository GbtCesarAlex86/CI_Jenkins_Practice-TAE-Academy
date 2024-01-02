pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                dir('src') {
                    bat 'javac com/globant/Main.java'
                }
            }
        }
        stage('Run') {
            steps {
                echo 'Running...'
                dir('src') {
                    bat 'java com.globant.Main'
                }
            }
        }
    }
}