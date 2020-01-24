def call()
{
sh '''
  curl -X POST \
 'https://gitlab.com/api/v4/projects?private_token=ravzJJcJ6ih-yrpchiLs' \
  -H 'accept: application/json' \
  -H 'authorization: Basic c3VtYXZhcnNoaXRoYS5rYW1hdGFtOTk3QGdtYWlsLmNvbTpyYXZ6SkpjSjZpaC15cnBjaGlMcw==' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 284851de-59b0-f9e2-af1f-823acf4a7be8' \
  -d ' {
                "name": "bunny",
                  "description": "This is your first project",
                  "homepage": "https://gitlab.com",
                  "private": false,
                  "has_issues": true,
                  "has_projects": true,
                  "has_wiki": true
                }'
                '''
 
}
