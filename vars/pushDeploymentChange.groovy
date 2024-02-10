def call(String GithubUser){
    sh """
      git config --global user.name "${GithubUser}"
      git config --global user.email "shivalikasisodia13@gmail.com"
      git add deployment.yaml
      git commit -m "Updated Deployment Manifest"
       """
      withCredentials([gitUsernamePassword(credentialsId: 'github', gitToolName: 'Default')]) {
      sh "git push https://github.com/shivalikasisodia/gitops-DevSecOps-project.git main"
      }

}