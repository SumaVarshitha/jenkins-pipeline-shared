def call(ProjectKey,ProjectName,QualityGateName,GateId,ProjectId)
{
  echo "$ProjectName"
  //int x=Integer.parseInt("GateId");
   echo "$GateId"
  //int y=Integer.parseInt("ProjectId");
//Creating Project in Sonar
  sh "curl -u admin:admin -X POST http://ec2-3-16-33-107.us-east-2.compute.amazonaws.com:9000/api/projects/create?key=${ProjectKey}&name=${ProjectName}"
  echo "$ProjectName"
 
  //Quality Gate
  sh "curl -u admin:admin -X POST http://3.16.33.107:9000/api/qualitygates/create?name=${QualityGateName}"
  sh "curl -X GET http://3.16.33.107:9000/api/qualitygates/list"
  sh "curl -u admin:admin -X POST "http://3.16.33.107:9000/api/qualitygates/create_condition?gateId=14&metric=blocker_violations&op=GT&warning=5&error=10""
  sh "curl -u admin:admin -X POST http://3.16.33.107:9000/api/qualitygates/create_condition?gateId=$GateId&metric=critical_violations&op=GT&warning=5&error=10"
  sh "curl -u admin:admin -X POST http://3.16.33.107:9000/api/qualitygates/select?gateId=$GateId&projectId=$ProjectId"
//sh 'curl -u admin:admin -X POST "http://3.16.33.107:9000/api/qualitygates/select_as_default?id=1"'
}
