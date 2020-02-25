import groovy.json.*

@NonCPS
commitgit(){

def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/game/commits.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
   int result=resultJson.commit.size()
print "total no.of commits:" +result
   
def readera = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/game/collab.json"),"UTF-8"))
def resultJson1 = jsonSlurper.parse(readera)
   int result1=resultJson1.login.size()
print "total no.of collaborators:" +result1
   
    	def collab = new String[100]
   for(int i=0;i<=result1;i++)
   {
   
  
      collab[i]=resultJson1[i].login
      println(collab[i])
      
       sh """
curl -X GET \
  'https://api.github.com/repos/SumaVarshitha/game/commits?author=${collab[i]}' \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: e89ade00-222a-ac9c-d259-7262600e2883' 
  
  
     """
   }
  
    def count = new String[100]
   for(int j=0;j<result1;j++)
   
   {
      
     
      count[j]=0
   for(int i=0;i<result;i++){
      if((resultJson.commit.author.name[i]).equals( collab[j] ))
         count[j]++
         }
         }
 
         for(int i=0;i<result1;i++){
            println collab[i] +" = "+count[i]
         }
 
    	
 

    
    
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
  https://api.github.com/repos/SumaVarshitha/game/commits \
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
