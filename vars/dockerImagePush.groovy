def call(String ImageName, String ImageTag, String dockerhubUser){
    withCredentials([usernamePassword(
            credentialsId: "docker-cred",
            usernameVariable: "USER",  //bind credentials to variables
            passwordVariable: "PASS"   //bind credentials to variables
    )]) {
        sh "docker login -u '$USER' -p '$PASS'"
    }
    sh "docker image push ${dockerhubUser}/${ImageName}:${ImageTag}"
    sh "docker image push ${dockerhubUser}/${ImageName}:latest"   
}


// def call(String aws_account_id, String region, String ecr_repoName){
    
//     sh """
//      aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
//      docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//     """
// }
