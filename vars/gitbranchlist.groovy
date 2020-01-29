def call(){
sh 'curl -v --user SumaVarshitha:sumasuji268 -H "ContentType: application/json; charset=UTF-8"  https://api.github.com/repos/user/jenkins-pipeline-shared/git/refs/heads'
}
