def call()
{
sh '''
curl -X DELETE \
  'https://gitlab.com/api/v4/projects/15483041/repository/branches/ff?private_token=VkjgB4Jdbaswh7FNXeC-' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 726a2af4-45de-ec74-946d-9990588db56c'
  '''
  }
