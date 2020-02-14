import groovy.json.*

@NonCPS
createBranch(String repoName,String branchName){

def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/gitcheckout/BranchSha.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def branchSha = resultJson[0].commit.sha
    	
 
curl_setopt($chSt, CURLOPT_FAILONERROR, true);
    sh """
    curl -X POST \
  https://api.github.com/repos/SumaVarshitha/${repoName}/git/refs \
  -H 'accept: application/json' \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 8aee7eca-0e7f-361c-6be6-9f3bfbd1f0df' \
  -d '{
   "ref": "refs/heads/${branchName}",
   
  "sha": "${branchSha}"


 }'
 """
    	
 
$httpstatus = curl_getinfo($chSt, CURLINFO_HTTP_CODE);
    if(httpstatus== "200"){
        echo "success"}
    else
        echo "fail"
    
}

def call(jsondata){
 def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

//String a=jsonObj.alm.projects.project.project_name
String a=jsonObj.scm.repositories.repository[2].name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");
    
   for(int i = 0;i<3;i++) {
         
      
String b=jsonObj.scm.repositories.repository[2].branches.branch[i].name
String branchName=b.replaceAll("\\[", "").replaceAll("\\]","");

//sh "rm -rf Text.xml"
 println(a)
 println(repoName)
println(branchName)
   
/*httpRequest authentication: 'github', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
  
    "ref": "refs/heads/branchName",
   
  "sha": "d2160fec95d3968d0b13ee669b0dbec1837579b1"
   
}""", responseHandle: 'NONE', url: "https://api.github.com/repos/SumaVarshitha/${repoName}/git/refs"*/
    createBranch(repoName,branchName)
   }
}
 
