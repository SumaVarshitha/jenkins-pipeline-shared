def call()
{
sh '''
curl -X DELETE \
  https://api.github.com/repos/SumaVarshitha/newtask/git/refs/heads/dev \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: c37c3e32-c8fc-3ee9-0a79-ab9a8f9f3904'
  '''
  }
