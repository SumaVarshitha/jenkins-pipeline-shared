/*def call(){
sh '''
curl -X GET \
  https://api.github.com/repos/SumaVarshitha/jenkins-pipeline-shared/branches \
  -H 'cache-control: no-cache' \
  '''
}
httpRequest authentication: 'github', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
    "name": "${repoName}",
    "scmId": "git",
    "forkable": true
}""", responseHandle: 'NONE', url: "https://api.github.com/user/repos"
*/
def call(jsondata){
 def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm.repositories.repository.name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");

env.name = repoName


//sh "rm -rf Text.xml"
 println(a)
 println(repoName)
sh """
curl -X GET \
  https://api.github.com/repos/SumaVarshitha/${repoName}/branches \
  -H 'cache-control: no-cache'  -o BranchSha.json
  """
 
}
