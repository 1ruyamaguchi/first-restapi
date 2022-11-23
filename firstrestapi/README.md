# First REST API
REST APIのサンプルプロジェクトです。

## サンプルリクエスト

```
curl -X POST -H "Content-Type:application/json" -d "{\"userName\": \"post\", \"age\": 90, \"remarks\": \"test of post\"}" http://localhost:8080/sample/post

curl -X GET http://localhost:8080/sample/get?userName=test

curl -X PUT -H "Content-Type:application/json" -d "{\"userId\": 1, \"inputDto\": {\"userName\": \"post_update\", \"age\": 90, \"description\": \"test of post\"}}" http://localhost:8080/sample/put

curl -X DELETE http://localhost:8080/sample/delete?userId=1
```