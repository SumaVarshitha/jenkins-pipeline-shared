def call()
{
curl -X "POST" "http://gitlab.example.com/api/v4/projects" \
     -H "PRIVATE-TOKEN: ravzJJcJ6ih-yrpchiLs" \
     -H "Content-Type: application/json; charset=utf-8" \
     -d "{\"name\":\"foo-${RANDOM}\",\"issues_enabled\":\"true\",\"merge_requests_enabled\":\"true\",\"builds_enabled\":\"true\",\"wiki_enabled\":\"true\",\"snippets_enabled\":\"true\",\"shared_runners_enabled\":\"true\",\"public\":\"true\",\"visibility_level\":0,\"public_builds\":\"true\",\"only_allow_merge_if_build_succeeds\":\"true\",\"lfs_enabled\":\"true\",\"request_access_enabled\":\"true\"}" \
| jq . | grep enabled
}
