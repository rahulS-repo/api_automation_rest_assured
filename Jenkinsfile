pipeline {
    agent any
    tools {
        jdk 'JDK-21'                     // Must match Global Tool Config name
        maven 'Apache Maven 3.9.16'      // Must match Global Tool Config name
    }
    environment {
        ENV = "${params.ENV ?: 'qa'}"                   // Jenkins parameter or default
        BROWSER = "${params.BROWSER ?: 'chrome'}"       // Jenkins parameter or default
        GROUP = "${params.GROUP ?: 'regression'}"       // Jenkins parameter or default
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/rahulS-repo/api_automation_rest_assured.git'
                script {
                    currentBuild.displayName = "#${env.BUILD_NUMBER} - users-api - -Dgroup=${GROUP}"
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
                bat 'mvn test -Denv=%ENV% -Dbrowser=%BROWSER% -Dgroup=%GROUP%'
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
