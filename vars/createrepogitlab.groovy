/*import groovy.json.JsonSlurper 

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
}*/
def call(jsondata){
 def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm.projects.project[0].proj_name
String projName=a.replaceAll("\\[", "").replaceAll("\\]","");




//sh "rm -rf Text.xml"
 println(a)
 println(projName)

 httpRequest authentication: 'git', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
    "name": "${projName}",
    "scmId": "git",
    "forkable": true
}""", responseHandle: 'NONE', url: "https://gitlab.com/api/v4/projects?private_token=VkjgB4Jdbaswh7FNXeC-"
}
 
