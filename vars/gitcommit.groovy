import groovy.json.*

/*@NonCPS
commitgit(){

def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/game/commits.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
   int result=resultJson.commit.size()
print "total no.of commits:" +result
   println resultJson
   
def readera = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/game/collab.json"),"UTF-8"))
def resultJson1 = jsonSlurper.parse(readera)
   int result1=resultJson1.login.size()
print "total no.of collaborators:" +result1
   
    	def collab = new String[100]
   for(int i=0;i<result1;i++)
   {
   
  
      collab[i]=resultJson1[i].login
      println(collab[i])
      
      
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
 
    	
 

    
    
}*/
def call(jsondata){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
  
String a=jsonObj.scm.repositories.repository.repo_name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");

 println(repoName)


sh """
curl -X GET \
  https://api.github.com/repos/SumaVarshitha/${repoName}/commits \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: f302bff6-fe11-93d8-d78d-e756d4a8c5b3' -o commits.json
  """ 

 //commitgit()
  }
