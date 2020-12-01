def build_app(){
  sh 'docker-compose up -d'
}

def e2e_test(){
  echo 'release-specific testing here'
}
def user_acceptance(){
  input "proceed with deployment to live?"
}

def test_app(){
  e2e_test()
  user_acceptance()
}

def down_app(){
  sh 'docker-compose down'
}

def release_app(){
  echp 'deploy for staging environment'
}

def accept_app(){
  input 'processed with live deployment'
}

def merge_app(){
  echo 'Merging to master'
}

def stop_app(){
  sh 'docker-compose down'
}

def live_app(){
  echo 'merge with main'
}

return this
