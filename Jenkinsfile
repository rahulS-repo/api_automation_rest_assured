pipeline{
    agent any
    tools{
        jdk 'JDK-21'
        maven 'Apache Maven 3.9.16'
    }
    stages{
        stage('checkout'){
            steps{
                git branch: 'main', url: 'https://github.com/rahulS-repo/api_automation_rest_assured.git'
            }
        }
        stage('Build'){
            steps{
                sh 'mvn clean install'
                }
        }
        stage('Test'){
            steps{
                sh 'mvn test'
            }
        }
    }
}