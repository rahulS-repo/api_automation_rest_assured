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
                bat 'mvn clean install'
                }
        }
        stage('Test'){
            steps{
                bat 'mvn test'
            }
        }
    }
    post {
            always {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'reports', // Path to the folder containing the report
                    reportFiles: 'report.html',       // Name of your Extent HTML file
                    reportName: 'Extent Report',      // Name shown in the Jenkins sidebar
                    reportTitles: ''
                ])
            }
        }
}