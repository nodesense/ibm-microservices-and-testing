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


# add mod test 

```
{{base_url}}/api/test/mod
```

on header, 

```
Authorization: Bearer {{auth_token}} 
```

on test 

```test

pm.test ("should public allowed access content ", function() {
    pm.expect(pm.response.text()).to.include("Moderator Board.")
})

```


## Refresh token and update access and refresh again

POST 

```
{{base_url}}/api/auth/refreshtoken
```

Request body

```json
{
    "refreshToken": "{{refresh_token}}"
}
```

Test script

```javascript
// to store the refresh and access into collection variable to use in next request
// schema testing - contract testing done using pact

const payload = pm.response.json()

pm.test("should validate statuscode and content type, response time", function() {
    pm.response.to.have.status(200)
   // now fetch data from response and store to collection variable
    pm.collectionVariables.set("auth_token", payload.accessToken)
    pm.collectionVariables.set("refresh_token", payload.refreshToken)
})
 
```

## Use new access token to verify all working
GET

```
{{base_url}}/api/test/user
```

HEADER

```
Authorization: Bearer {{auth_token}} 
```

Test

```
pm.test ("should public allowed access content ", function() {
    pm.expect(pm.response.text()).to.include("User Content.")
})
```

## Data Driven

0. Create user admin, with admin,mod,user access
1. Clone the RoleTest
2. Create a csv file in Ubuntu Desktop called users.csv
3. Paste below content

```csv
username,password,email
example1,password,example1@example.com
admin,admin1234,admin@example.com
```
