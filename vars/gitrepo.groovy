def call(){
sh 'curl -X POST -v --user SumaVarshitha:sumasuji268 -H "ContentType: application/json; charset=UTF-8" requestBody: 'body''{
                "name": "varshi",
                  "description": "This is your first repository",
                  "homepage": "https://github.com",
                  "private": false,
                  "has_issues": true,
                  "has_projects": true,
                  "has_wiki": true
                }'''


 "https://api.github.com/user/repos" -d {"name":"varshi"}'}
}
