
pipeline {
    agent any

    parameters {
        choice(
            name: 'SUITE',
            choices: ['testng-dev.xml', 'testng-qa.xml', 'testng-staging.xml'],
            description: 'Choose which TestNG suite to run'
        )
    }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Kimvtq/selenium-java-project.git'
            }
        }

        stage('Build') {
            when {
                allOf {
                    expression { env.CHANGE_ID == null } // Only normal branch build (not PR)
                    branch 'main' // Only on main branch
                }
            }
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            when {
                allOf {
                    expression { env.CHANGE_ID == null } // Only normal branch build (not PR)
                    branch 'main' // Only on main branch
                }
            }
            steps {
                sh "mvn clean test -DsuiteXmlFile=${params.SUITE}"
            }
        }

        stage('Archive Test Reports') {
            when {
                allOf {
                    expression { env.CHANGE_ID == null } // Only normal branch build (not PR)
                    branch 'main' // Only on main branch
                }
            }
            steps {
                junit '**/target/surefire-reports/*.xml'
                publishHTML(target: [
                    reportName : 'HTML Report',
                    reportDir  : 'target/surefire-reports',
                    reportFiles: 'emailable-report.html',
                    keepAll    : true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            cleanWs()
        }
    }
}
