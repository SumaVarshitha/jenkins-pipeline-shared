import groovy.json.*

def call(jasondata,github,pullreq){
 // print github
// def k=1
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
int ecount = jsonObj.config.emails.email.size()
 def team=jsonObj.riglet_info.name
List<String> jsonString1= new ArrayList<String>();
  jsonString1.add(github)
 // print jsonString1
  List<String> JSON = new ArrayList<String>();
  for(i=0;i<jsonString1.size();i++)
  { 
    int score=0
    String name="  "
if(jsonString1[i].contains("GITHUB"))
{
name="GITHUB"
 def metric="commits"
 def metric1="pull requests"
        def jsonObj1= readJSON text: jsonString1[i]
  //println(jsonObj)
  def cnt =jsonObj1.GITHUB.commits_count
   // println(cnt)
   /*if(cnt>5)
  {
    score=score+10
  }*/
      
      JSON.add(["Tool":name,"Metric_name":metric,"Value":cnt])  
  JSON.add(["Tool":name,"Metric_name":metric1,"Value":pullreq])
   /*if(k==1){
 def num=jsonObj1.GITHUB.individual_commit_Details.size();
 for(i=0;i<num;i++){
  int scorei=0
  def cnt1=jsonObj1.GITHUB.individual_commit_Details[i].User_Commits_count
  if(cnt1>2)
  {
    scorei=scorei+10
  }
  def email=jsonObj1.GITHUB.individual_commit_Details[i].User_email
  JSON.add(["User_Email":email,"Tool":name,"Score":scorei])
  k=0
            }
            }*/
}
  }
 
def jsonBuilder = new groovy.json.JsonBuilder()
jsonBuilder(
 "Team_Name":team,
  "Metrics" : JSON
  
) 
  
  File file = new File("/var/lib/jenkins/workspace/${JOB_NAME}/Teamscore.json")
file.write(jsonBuilder.toPrettyString())
}
