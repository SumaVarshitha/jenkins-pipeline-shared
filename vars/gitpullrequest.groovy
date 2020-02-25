import groovy.json.*

@NonCPS
pullme(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/game/pull.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
   int result=resultJson.number.size()
print "total no.of pull requests:" +result

}
def call()
{
sh """
curl -X GET \
  https://api.github.com/repos/SumaVarshitha/game/pulls \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: edb6f426-ffc4-9070-37fe-2b82bacf0131' -o pull.json
  """
  pullme()
  }
