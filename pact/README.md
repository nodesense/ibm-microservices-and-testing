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

open new terminal

```
./gradlew provider:bootRun
```

open new terminal to test provider 

```
./gradlew provider:test --tests *Pact*Test
```
