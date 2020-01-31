/*import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def projUrl = resultJson.gcurl
//def projUrl = resultJson.url
httpRequest authentication: 'github', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'GET', requestBody: """
{
}""", responseHandle: 'NONE', url: "${projUrl}"
}
def call(){
def request = libraryResource 'data.json'
createRepo(request)
}*/
def call(){
  
sh 'curl -v --user SumaVarshitha:sumasuji268 -H "ContentType: application/json; charset=UTF-8"  https://api.github.com/users/SumaVarshitha/repos'

}
