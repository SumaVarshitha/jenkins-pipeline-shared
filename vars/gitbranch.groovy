def call()
{
    sh '''
    curl -X POST \
  https://api.github.com/repos/SumaVarshitha/newtask/git/refs \
  -H 'accept: application/json' \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 8aee7eca-0e7f-361c-6be6-9f3bfbd1f0df' \
  -d '{
   "ref": "refs/heads/dev",
   
  "sha": "8233111fce0f7fabab8753406eaf72d61b15a7ae"

   
 }'
 '''
}
