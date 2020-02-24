import groovy.json.*

@NonCPS
commit(String repoName,String branchName){

def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/game/commits.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def commitscount= _.size(commits.json);
    	
 
echo "commitscount"
 
    	
 

    
    
}
def call()
{
/*def call(jsondata){
 def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm.repositories.repository[2].name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");




//sh "rm -rf Text.xml"
 println(a)
 println(repoName)*/


sh """
curl -X GET \
  https://api.github.com/repos/SumaVarshitha/newtask/commits \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: f302bff6-fe11-93d8-d78d-e756d4a8c5b3' -o commits.json
  """ 
 commit()
  }
