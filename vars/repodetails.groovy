def call(jsondata)
{
  def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm.repositories.repository[2].name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");
  println(a)
  println(repoName)
sh """
curl -X GET \
  https://api.github.com/repos/SumaVarshitha/${repoName} \
  -H 'cache-control: no-cache' -o repo.json
  """
  }
