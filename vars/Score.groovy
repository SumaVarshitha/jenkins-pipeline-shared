import groovy.json.*

def call(jasondata,github){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
int ecount = jsonObj.config.emails.email.size()
List<String> jsonString= new ArrayList<String>();
  jsonString.add(github)
  List<String> JSON = new ArrayList<String>();
  for(i=0;i<jsonString.size();i++)
  { 
    int score=0
    String name="  "
if(jsonString[i].contains("GITHUB"))
{
name="GITHUB"
        def jsonObj= readJSON text: jsonString[i]
  //println(jsonObj)
  def cnt =jsonObj.GITHUB.commit_count
   // println(cnt)
   if(cnt>5)
  {
    score=score+10
  }
      }
      JSON.add(["TeamName":"digital_rig","Tool":name,"Score":score])  
  }
def jsonBuilder = new groovy.json.JsonBuilder()
jsonBuilder(
  "Scores" : JSON
  
) 
  
  File file = new File("/var/lib/jenkins/workspace/${JOB_NAME}/Teamscore.json")
file.write(jsonBuilder.toPrettyString())
}
