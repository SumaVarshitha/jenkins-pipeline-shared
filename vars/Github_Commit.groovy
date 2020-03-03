import groovy.json.*
import groovy.json.JsonSlurper 
//int ids1;

def call(jsondata){
      def jsonString = jsondata
      def jsonObj = readJSON text: jsonString
      int ecount = jsonObj.config.emails.email.size()
         println("No of users "+ ecount)
      String a=jsonObj.scm.repositories.repository.repo_name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");

 println(repoName)
     withCredentials([usernamePassword(credentialsId: 'github', passwordVariable: 'password', usernameVariable:'username')]) {
      sh "curl -X GET    -u $username:$password https://api.github.com/repos/SumaVarshitha/${repoName}/commits -o commits.json"
     }
   def jsonSlurper = new JsonSlurper()
 def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/commits.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def totalcommits = resultJson.size()
      println(totalcommits)
	println(ecount)
      println(JsonOutput.toJson(resultJson))
      List<String> JSON = new ArrayList<String>();
   	 List<String> LIST = new ArrayList<String>();
	 List<String> LIST1 = new ArrayList<String>();

	 def jsonBuilder = new groovy.json.JsonBuilder()
for(i=0;i<ecount;i++)
 {
	def email=jsonObj.config.emails.email[i] 
  for(j=0;j<total;j++)
  {
	 // println(jsonObj.config.emails.email[i])
	 // println(resultJson[j].commit.author.email)
   if(email==resultJson[j].commit.author.email)
   {
	   JSON.add(resultJson[j])
	 // JSON.add(resultJson[j])
     }
     }
	// println(jsonObj.config.emails.email[i])
	 cnt=JSON.size()
	 LIST1[i]=JSON.clone()
	 LIST.add(["email":email,"Commit": LIST1[i],"Commit_cnt":cnt])
	//LIST.add(["email":email,"Commit":JSON,"Commit_cnt":cnt])
	 //JCOPY[i]=(JsonOutput.toJson(JSON))
	// println(JCOPY[i])
	 JSON.clear()
	 
	   
     }
 /* for(i=0;i<JCOPY.size();i++)
	{
		println(JCOPY[i])
	}
    */
 jsonBuilder.gitlab(
  "total_commit" : resultJson,
  "commit_cnt" : resultJson.size(),
	 "individual_commit_Details":LIST
  
  )
File file = new File("/var/lib/jenkins/workspace/${JOB_NAME}/output1.json")
	file.write(jsonBuilder.toPrettyString())
}
