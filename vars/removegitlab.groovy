def call()
{
sh '''
curl -X DELETE \
  'https://gitlab.com/api/v4/projects/16691253?%0Aprivate_token=VkjgB4Jdbaswh7FNXeC-' \
  -H 'accept: application/json' \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpWa2pnQjRKZGJhc3doN0ZOWGVDLQ==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 75bf7f0c-b238-8ced-9af4-9ec6cc4eb8aa'
  '''
  }
