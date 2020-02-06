def call()
{
sh """
curl -X GET \
  'https://gitlab.com/api/v4/projects/15483041/repository/commits?private_token=VkjgB4Jdbaswh7FNXeC-' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 2291b4d3-10a3-0e34-20f4-b0e0ccf3b998'
  """
  }
