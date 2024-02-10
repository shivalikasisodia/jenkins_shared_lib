def call(String ImageName, String ImageTag, String dockerhubUser){
    
    sh """
     docker rmi ${dockerhubUser}/${ImageName}:${ImageTag}
     docker rmi ${dockerhubUser}/${ImageName}:latest
    """
}


// def call(String aws_account_id, String region, String ecr_repoName){
    
//     sh """
//      docker rmi ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//     """
// }