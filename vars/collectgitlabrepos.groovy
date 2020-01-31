import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def projUrl = resultJson.glcurl
//def projUrl = resultJson.url
httpRequest authentication: 'git', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'GET', requestBody: """
{
}""", responseHandle: 'NONE', url: "${projUrl}"
}
def call(){
def request = libraryResource 'data.json'
createRepo(request)
}
