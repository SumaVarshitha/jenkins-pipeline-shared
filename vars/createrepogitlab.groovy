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
println(jsonObj.scm2)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm2.projects.project[1].proj_name
String projName=a.replaceAll("\\[", "").replaceAll("\\]","");




//sh "rm -rf Text.xml"
 println(a)
 println(projName)

 /*httpRequest authentication: 'git', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
    "name": "${projName}",
    "scmId": "git",
    "forkable": true
}""", responseHandle: 'NONE', url: "https://gitlab.com/api/v4/projects?private_token=VkjgB4Jdbaswh7FNXeC-"
}*/
 sh  """ curl -X POST \
  'https://gitlab.com/api/v4/projects?private_token=VkjgB4Jdbaswh7FNXeC-' \
  -H 'accept: application/json' \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpyYXZ6SkpjSjZpaC15cnBjaGlMcw==' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: a923a67e-9e1d-b260-e5ee-b0d55ac40009' \
  -d ' {
                "name": "${projName}",
                  "description": "This is your first project",
                  "homepage": "https://gitlab.com",
                  "private": false,
                  "has_issues": true,
                  "has_projects": true,
                  "has_wiki": true
                }' -o projectid.json
                """

}
 
