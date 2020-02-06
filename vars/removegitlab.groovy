/*def call()
{
sh '''
curl -X DELETE \
  'https://gitlab.com/api/v4/projects/16691253?private_token=VkjgB4Jdbaswh7FNXeC-' \
  -H 'accept: application/json' \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpWa2pnQjRKZGJhc3doN0ZOWGVDLQ==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 75bf7f0c-b238-8ced-9af4-9ec6cc4eb8aa'
  '''
  }
*/
def call(jsondata){
 def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm2)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm2.projects.project[1].proj_id
String projectId=a.replaceAll("\\[", "").replaceAll("\\]","");




//sh "rm -rf Text.xml"
 println(a)
println(projectId)
sh """
curl -X DELETE \
  'https://gitlab.com/api/v4/projects/${projectId}?private_token=VkjgB4Jdbaswh7FNXeC-' \
  -H 'accept: application/json' \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpWa2pnQjRKZGJhc3doN0ZOWGVDLQ==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 75bf7f0c-b238-8ced-9af4-9ec6cc4eb8aa'
  """
 
}
