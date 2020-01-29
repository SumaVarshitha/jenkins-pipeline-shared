def call(){
sh '''
curl -X GET \
  https://api.github.com/repos/SumaVarshitha/jenkins-pipeline-shared/branches \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 2e6c08e1-f5db-81c6-6c41-9cdee376cea4'
  '''
}
