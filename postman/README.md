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

```javascript
// to store the refresh and access into collection variable to use in next request
// schema testing - contract testing done using pact

const payload = pm.response.json()
// remove $schema entry in copied content
const schema = {
  "type": "object",
  "properties": {
    "refreshToken": {
      "type": "string"
    },
    "id": {
      "type": "integer"
    },
    "username": {
      "type": "string"
    },
    "email": {
      "type": "string"
    },
    "roles": {
      "type": "array",
      "items": [
        {
          "type": "string"
        },
        {
          "type": "string"
        }
      ]
    },
    "accessToken": {
      "type": "string"
    },
    "tokenType": {
      "type": "string"
    }
  },
  "required": [
    "refreshToken",
    "id",
    "username",
    "email",
    "roles",
    "accessToken",
    "tokenType"
  ]
}



pm.test("should validate statuscode and content type, response time", function() {
    pm.response.to.have.header("Content-Type")
    pm.expect(pm.response.headers.get("Content-Type")).to.eql("application/json")
    pm.expect(pm.response.responseTime).to.be.below(1000)
    pm.expect(payload.email).to.eql("example1@example.com")

// now fetch data from response and store to collection variable
    pm.collectionVariables.set("auth_token", payload.accessToken)
    pm.collectionVariables.set("refresh_token", payload.refreshToken)
})

pm.test("should be valid schema", function () {
    // contract testing, not testing the values
    pm.response.to.have.jsonSchema(schema)
})

```

# Schema Validation use below website to generate schema for json

https://www.liquid-technologies.com/online-json-to-schema-converter

# Public content test

```
{{base_url}}/api/test/all
```

test script 

```javascript

pm.test ("should public allowed access content ", function() {
    pm.expect(pm.response.text()).to.include("Public Content.")
})
```
