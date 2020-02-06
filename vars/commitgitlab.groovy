import groovy.json.*

@NonCPS
commitproj()
{

def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/gitcheckout/projectid.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def projId = resultJson.id
 
sh """
curl -X GET \
  'https://gitlab.com/api/v4/projects/${projId}/repository/commits?private_token=VkjgB4Jdbaswh7FNXeC-' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 2291b4d3-10a3-0e34-20f4-b0e0ccf3b998'
  """

}

def call()
{
commitproj()
}
