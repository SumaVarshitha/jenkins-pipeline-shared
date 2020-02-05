def call()
{
sh '''
curl -X DELETE \
  https://api.github.com/repos/SumaVarshitha/null-null \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: e781bd59-2423-a465-49f1-c20cba8434a5'
  '''
  }
