def call(jsondata)
{
  def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm2)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm2.projects.project[0].proj_id
String projId=a.replaceAll("\\[", "").replaceAll("\\]","");
sh """
  curl -X GET \
  https://gitlab.com/api/v4/projects/${projId}/repository/branches \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 1278cddd-133d-4a82-5588-c065664a4ad7'
  """
}
