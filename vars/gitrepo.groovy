def call(){
sh 'curl -u SumaVarshitha https://api.github.com/users/repos -d '{"name": "reponame"}'
}
