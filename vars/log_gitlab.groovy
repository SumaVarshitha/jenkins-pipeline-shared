import groovy.json.JsonSlurper 
@NonCPS

def call(message)
{
 println(message)
 def request = libraryResource 'data.json'
 def jsonSlurper = new JsonSlurper() 
 def resultJson = jsonSlurper.parseText(request)
 def projectName = resultJson.glname
  Date date = new Date() 
  sh " echo '${date}' gitlabproject with the projectname '${projectName}' ${message} >>log.txt"
}
