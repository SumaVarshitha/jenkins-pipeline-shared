/*def call()
{
sh '''
curl -X DELETE \
  https://api.github.com/repos/SumaVarshitha/null-null \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: e781bd59-2423-a465-49f1-c20cba8434a5'
  '''
  }
*/
def call(jsondata){
 def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm.repositories.repository.repo_name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");

env.name = repoName


//sh "rm -rf Text.xml"
 println(a)
 println(repoName)
sh """
curl -X DELETE \
  https://api.github.com/repos/SumaVarshitha/${repoName} \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: e781bd59-2423-a465-49f1-c20cba8434a5'
  """
 
}
