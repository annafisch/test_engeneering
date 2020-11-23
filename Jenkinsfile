pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Building Docker Images'
        sh 'docker build -t myflaskapp .'
      }
    }

    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            echo 'Starting docker services'
          }
        }

        stage('Run Docker Image') {
          steps {
            echo 'Running Flask app'
            sh 'docker run -p 5000:5000 -d --name  myflaskapp  myflaskapp'
          }
        }

        stage('Run Redis') {
          steps {
            echo 'Running redis'
            sh '#docker run -p 6379:6379 -d --name redis redis:alpine'
          }
        }

      }
    }

    stage('Testing') {
      steps {
        echo 'Deploying Now'
        sh 'python test_app.py'
      }
    }

    stage('Stop Containers') {
      parallel {
        stage('Stop Containers') {
          steps {
            sh 'docker rm -f myflaskapp'
            sh 'docker rmi myflaskapp'
          }
        }

        stage('error') {
          steps {
            sh '#docker stop redis'
            sh '#docker rm redis'
          }
        }

      }
    }

  }
}
