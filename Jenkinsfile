pipeline {
  agent any
  stages {
    stage('Building') {
      steps {
        echo 'In building stage'
        sh 'docker build -t myflaskapp .'
      }
    }

    stage('Run Containers') {
      parallel {
        stage('Run Containers') {
          steps {
            echo 'In run container stage'
            sh 'docker run -d -p 6379:6379 --name myredis redis:alpine'
          }
        }

        stage('Running flask') {
          steps {
            sh 'docker run -d -p 5000:5000 --name myflaskapp_c myflaskapp'
          }
        }

      }
    }

    stage('Testing') {
      steps {
        echo 'In testingstage'
        sh 'python test_app.py'
      }
    }

    stage('Final') {
      steps {
        echo 'In final stage'
        sh 'docker container rm -f $(docker container ls -qa)'
      }
    }

  }
}