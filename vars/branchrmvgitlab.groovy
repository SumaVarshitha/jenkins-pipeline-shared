import groovy.json.*

@NonCPS
createBranch(String branchName){

def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/gitcheckout/projectid.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def projectId = resultJson.id
 sh """
curl -X DELETE \
  'https://gitlab.com/api/v4/projects/${projectId}/repository/branches/${branchName}?private_token=VkjgB4Jdbaswh7FNXeC-' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 726a2af4-45de-ec74-946d-9990588db56c'
  """
}
 
 
def call(jsondata){
 def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm2)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm2.projects.project[1].branches.branch[0].name1
String branchName=a.replaceAll("\\[", "").replaceAll("\\]","");



//sh "rm -rf Text.xml"
 println(a)
 println(branchName)

  createBranch(branchName)
}



/*def call()
{
  def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm2)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm2.projects.project[0].proj_name
String projName=a.replaceAll("\\[", "").replaceAll("\\]","");
sh '''
curl -X DELETE \
  'https://gitlab.com/api/v4/projects/15483041/repository/branches/ff?private_token=VkjgB4Jdbaswh7FNXeC-' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 726a2af4-45de-ec74-946d-9990588db56c'
  '''
  }*/
