def call()
{
sh '''
curl -X GET \
  https://api.github.com/repos/SumaVarshitha/Ansible \
  -H 'cache-control: no-cache' -o repo.json
  '''
  }
