def call()
{
//Creating Project in Sonar
sh 'curl -u admin:admin -X POST "http://ec2-3-16-33-107.us-east-2.compute.amazonaws.com:9000/api/projects/create?key=newKey&name=EDN250"'
//Quality Gate
sh 'curl -u admin:admin -X POST "http://3.16.33.107:9000/api/qualitygates/create?name=EDN250"'
sh 'curl -X GET http://3.16.33.107:9000/api/qualitygates/list'
sh 'curl -u admin:admin -X POST "http://3.16.33.107:9000/api/qualitygates/create_condition?gateId=11&metric=blocker_violations&op=GT&warning=5&error=10"'
sh 'curl -u admin:admin -X POST "http://3.16.33.107:9000/api/qualitygates/create_condition?gateId=11&metric=critical_violations&op=GT&warning=5&error=10"'
sh 'curl -u admin:admin -X POST "http://3.16.33.107:9000/api/qualitygates/select?gateId=11&projectId=1"'
//sh 'curl -u admin:admin -X POST "http://3.16.33.107:9000/api/qualitygates/select_as_default?id=11"'
}
