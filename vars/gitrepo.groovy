import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def repoName = resultJson.name
//def projUrl = resultJson.url
//def projUrl = resultJson.url
 sh '''
curl -X POST \
  https://api.github.com/user/repos \
  -H 'accept: application/json' \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 5d076930-9214-41a9-3383-0f081485a47a' \
  -d ' {
                "name": "${repoName}",
                  "description": "This is your first repository",
                  "homepage": "https://github.com",
                  "private": false,
                  "has_issues": true,
                  "has_projects": true,
                  "has_wiki": true
                }'
                '''
}
def call(){
def request = libraryResource 'data.json'
createRepo(request)
}

