def call(){
def name = System.console().readLine() 'What is your name? '
println "Your name is " + name
sh 'curl -v --user SumaVarshitha:sumasuji268 -H "ContentType: application/json; charset=UTF-8"  https://api.github.com/users/SumaVarshitha/repos'

}
