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

use this for test now

```
// to store the refresh and access into collection variable to use in next request
// schema testing - contract testing done using pact

const payload = pm.response.json()

pm.test("validate statuscode and content type, response time", function() {
    pm.response.to.have.header("Content-Type")
    pm.expect(pm.response.headers.get("Content-Type")).to.eql("application/json")
    pm.expect(pm.response.responseTime).to.be.below(1000)
    pm.expect(payload.email).to.eql("example1@example.com")

// now fetch data from response and store to collection variable
    pm.collectionVariables.set("auth_token", payload.accessToken)
    pm.collectionVariables.set("refresh_token", payload.refreshToken)
})


```

# Schema Validation use below website to generate schema for json

https://www.liquid-technologies.com/online-json-to-schema-converter
