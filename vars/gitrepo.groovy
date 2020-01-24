def call(){
sh '
sh 'curl -X POST -v --user SumaVarshitha:sumasuji268 -H "ContentType: application/json; charset=UTF-8" "https://api.github.com/user/repos" -d {"name":"repo6"}'
}
