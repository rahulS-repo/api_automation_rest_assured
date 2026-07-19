pipeline {
    agent any
    tools {
        jdk 'JDK-21'                     // Must match Global Tool Config name
        maven 'Apache Maven 3.9.16'      // Must match Global Tool Config name
    }
    environment {
        ENV = 'qa'                       // Default environment
        BROWSER = 'chrome'               // Default browser
        GROUP = 'regression'             // Default test group
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/rahulS-repo/api_automation_rest_assured.git'
                script {
                    currentBuild.displayName = "#${env.BUILD_NUMBER} - users-api - ${env.BRANCH_NAME}"
                }
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat "mvn test -Denv=${env.ENV} -Dbrowser=${env.BROWSER} -Dgroup=${env.GROUP}"
            }
        }
    }
    post {
        always {
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports',       // Folder containing report
                reportFiles: 'report.html', // Report file name
                reportName: 'Extent Report',
                reportTitles: ''
            ])
        }
    }
}
