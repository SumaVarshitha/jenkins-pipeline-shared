def call(){
sh 'curl -H  "Authorization:token <ea519893046425a0f31cf5254f6b1017159fc9e8>" "ContentType: application/json;  --data {"name":"repo6"} charset=UTF-8" https://api.github.com/user/repos'
}
