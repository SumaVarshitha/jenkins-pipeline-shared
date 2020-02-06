def call(){
sh "curl --request POST --header "PRIVATE-TOKEN: 9koXpg98eAheJpvBs5tK" --data "personal_access_token=abc123&repo_id=12345&target_namespace=root" https://gitlab.example.com/api/v4/import/github"
}
