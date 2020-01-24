def call(){
sh '''
-X POST /user/repos HTTP/1.1
Host: api.github.com
Authorization: Basic U3VtYVZhcnNoaXRoYTpzdW1hc3VqaTI2OA==
Accept: application/json
Cache-Control: no-cache
Postman-Token: 8d7f2da6-f7d5-d428-8069-e7e1c146a15a

 {
                "name": "sum",
                  "description": "This is your first repository",
                  "homepage": "https://github.com",
                  "private": false,
                  "has_issues": true,
                  "has_projects": true,
                  "has_wiki": true
                }
                '''
}
