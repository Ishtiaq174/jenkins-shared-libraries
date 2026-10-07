def call(String project, String ImageTag){
  withCredentials([usernamePassword(
                    credentialsId:"DockerHubCred",
                    usernameVariable:"dockerHubUser", 
                    passwordVariable:"dockerHubPass")]){
                        echo "This is pushing image to docker hub"
                        
                        sh "docker login -u $dockerHubUser -p $dockerHubPass"
                        sh "docker image tag ${project}:${ImageTag} $dockerHubUser/${project}:${ImageTag}"
                        sh "docker push $dockerHubUser/${project}:${ImageTag}"
                    }
}
