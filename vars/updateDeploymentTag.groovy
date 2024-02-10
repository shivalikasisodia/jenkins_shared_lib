def call(String APP_NAME, String IMAGE_TAG)
{
    sh """
       cat deployment.yaml
       sed -i 's/${APP_NAME}.*/${APP_NAME}:${IMAGE_TAG}/g' deployment.yaml
       cat deployment.yaml
        """
}