import groovy.json.*

@NonCPS
importRepo()
{

def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/gitcheckout/repo.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def repoId = resultJson.id
 sh """
curl -X POST \
  'https://gitlab.com/api/v4/import/github?private_token=VkjgB4Jdbaswh7FNXeC-' \
  -H 'accept: application/json' \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpWa2pnQjRKZGJhc3doN0ZOWGVDLQ==' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: b9d72abc-7904-2681-a8ab-39581681eba0' \
  -d '{
"personal_access_token":"29ed4512c07d685ad8af8d80aba9d57b49d81759",
"repo_id":${repoId},

"target_namespace":"SumaVarshitha"

}'
"""
}

def call()
{
importRepo()
}
