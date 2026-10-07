def call(String Project, String ImageTag){
  echo "Building the code"
  sh "whoami"
  sh "docker build -t ${Project}:${ImageTag} ."
}
