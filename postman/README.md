## Postman Hello World Scripting

POST

```
http://localhost:8080/api/auth/signup
```

payload 

```
{
    "username": "example1",
    "email": "example1@example.com",
    "password": "password",
    "role": ["mod", "user"]
}
```

## Sign in

POST , body type should be raw, content type should be json 

```
http://localhost:8080/api/auth/signin
```

```json

{
    "username": "example1",
    "password": "password"
}
```
