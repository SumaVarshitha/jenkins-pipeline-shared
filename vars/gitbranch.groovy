/*def call()
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
   "ref": "refs/heads/release",
   
  "sha": "8233111fce0f7fabab8753406eaf72d61b15a7ae"

   
 }'
 '''
}*/

def call(jsondata){
 def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm.repositories.repository.repo_name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");
    
String b=jsonObj.scm.repositories.repository.branches.branch.name
String branchName=b.replaceAll("\\[", "").replaceAll("\\]","");



//sh "rm -rf Text.xml"
 println(a)
 println(repoName)
println(branchName)
httpRequest authentication: 'github', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
"ref": "refs/heads/branchName",
   
  "sha": "8233111fce0f7fabab8753406eaf72d61b15a7ae"
    
   
}""", responseHandle: 'NONE', url: "https://api.github.com/repos/SumaVarshitha/repoName/git/refs"
}
 
