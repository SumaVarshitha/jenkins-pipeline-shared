def call(){
sh '''
curl -X GET \
  https://api.github.com/repos/SumaVarshitha/jenkins-pipeline-shared/branches \
  -H 'cache-control: no-cache' \
  '''
}
