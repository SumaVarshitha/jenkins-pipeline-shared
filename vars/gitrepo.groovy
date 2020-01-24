def call(){
sh 'curl -H  "Authorization: token 626cc053030fb8ccac268f6541c258ee5752e9ed" --data {"name":"suma"} https://api.github.com/user/repos'
}
