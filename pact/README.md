# PACT 

official code repo https://github.com/pact-foundation/pact-workshop-jvm-spring

Open Terminal in intellij or linux 

Run the broker

```
docker compose up
```

open new terminal 

```

./gradlew consumer:test --tests *PactTest

./gradlew consumer:copyPacts
```

files shall be copied   
Copy the updated contract located in `consumer/build/pacts/FrontendApplication-ProductService.json` to `provider/src/test/resources/pacts/FrontendApplication-Productservice.json` by running the command:



Changer provider test to refer local folder, instead of broker
```

@PactFolder("pacts")
//@PactBroker(
//        host = "localhost",
//        port = "9292",
//        authentication = @PactBrokerAuth(username = "pact_workshop", password = "pact_workshop")
//)

```

open new terminal

```
./gradlew provider:bootRun
```

open new terminal to test provider 

```
./gradlew provider:test --tests *Pact*Test
```
