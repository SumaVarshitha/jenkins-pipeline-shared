def call()
{
sh 'curl -X GET \
  https://gitlab.com/api/v4/projects/16500283/repository/branches \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 1278cddd-133d-4a82-5588-c065664a4ad7''
}
