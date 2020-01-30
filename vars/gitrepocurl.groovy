def call()
{
sh '''
curl -X POST \
  https://api.github.com/user/repos \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: d991f864-a849-b87c-17af-117347a26556' \
  -d '{
  "name": "Hello-World",
  "description": "This is your first repository",
  "homepage": "https://developer.github.com/v3",
  "private": false,
  "has_issues": true,
  "has_projects": true,
  "has_wiki": true
}'
'''
}
