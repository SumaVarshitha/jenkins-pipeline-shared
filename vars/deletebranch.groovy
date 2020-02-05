/*def call()
{
sh '''
curl -X DELETE \
  https://api.github.com/repos/SumaVarshitha/newtask/git/refs/heads/dev \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: c37c3e32-c8fc-3ee9-0a79-ab9a8f9f3904'
  '''
  }*/

def call(jsondata){
 def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm.repositories.repository[1].name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.scm.repositories.repository[1].branches.branch[0].name1
String branchName=b.replaceAll("\\[", "").replaceAll("\\]","")



//sh "rm -rf Text.xml"
 println(a)
 println(repoName)
   println(branchName)
sh """
curl -X DELETE \
  https://api.github.com/repos/SumaVarshitha/${repoName}/git/refs/heads/${branchName} \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: c37c3e32-c8fc-3ee9-0a79-ab9a8f9f3904'
  """
 
}
