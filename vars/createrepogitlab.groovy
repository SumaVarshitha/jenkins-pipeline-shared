import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def repoName = resultJson.glname

//def projUrl = resultJson.url
httpRequest authentication: 'git', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
    "name": "${repoName}",
    "scmId": "git",
    "forkable": true
}""", responseHandle: 'NONE', url: "https://gitlab.com/api/v4/projects?private_token=VkjgB4Jdbaswh7FNXeC-"
}
def call(){
def request = libraryResource 'data.json'
createRepo(request)
}
