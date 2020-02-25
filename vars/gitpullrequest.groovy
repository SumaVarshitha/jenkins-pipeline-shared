def call()
{
sh """
curl -X GET \
  https://api.github.com/repos/SumaVarshitha/game/pulls \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpzdW1hc3VqaTI2OA==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: edb6f426-ffc4-9070-37fe-2b82bacf0131'
  """
  }
