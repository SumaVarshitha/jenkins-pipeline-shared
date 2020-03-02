import groovy.json.*
	def Container()
	{
		string ContainerId { get; set; }
		string ContainerName { get; set; }
	}

def Dispatch()
	{
		Dispatch()
		{
			Container = new List<Container>();
		}
		List<Container> Container { get; set; }
	}
     
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
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/game/commits.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
   int result=resultJson.commit.size()
	//data["commits"].append({'total number of commits' = 'result'})
print "total no.of commits:" +result
   int ecount = jsonObj.config.emails.email.size()
println("No of users "+ ecount)
  
def count = new String[100]
	 List<String> JSON = new ArrayList<String>();
	var Dispatch = new Dispatch();


   var propertyDispatch = new Container();
for(i=0;i<ecount;i++)
 {
	 count[i]=0
	 
  for(j=0;j<result;j++)
  {
	 
   if(jsonObj.config.emails.email[i]==resultJson[j].commit.author.email)
   {
	    count[i]++
		    
   propertyDispatch.Name = resultJson[j].commit.author.name.ToString();
   propertyDispatch.Email = resultJson[j].commit.author.email.Container.ToString()

   Dispatch.Container.Add(propertyDispatch);
//.... Your other code



	  JSON.add(JsonOutput.toJson(resultJson[j]))
   }
  }
	 print jsonObj.config.emails.email[i] +" = "+count[i]
	
 }
	println(Dispatch)
	println(JSON)
  }
