import groovy.json.*

@NonCPS
commitgit(){

def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/game/commits.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
print "total no.of commits:" +resultJson.commit.size()
   
def readera = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/game/collab.json"),"UTF-8"))
def resultJson1 = jsonSlurper.parse(readera)
print "total no.of collaborators:" +resultJson1.login.size()
    	
 
    	
 

 
    	
 

    
    
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
sh """
curl -X GET \
  https://api.github.com/repos/SumaVarshitha/game/collaborators \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' -o collab.json
  """
 commitgit()
  }
