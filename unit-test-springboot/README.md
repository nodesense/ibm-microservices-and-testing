Download the zip file

Extract the zip file using File Manager


Open Terminal , set Java JDK Path as we use Java 8 for Kafka

install openjdk 17 

```
sudo apt install openjdk-17-jdk

```

```

export JAVA_HOME=/usr/lib/jvm/java-1.17.0-openjdk-amd64
```

```
mvn clean

mvn clean install

mvn test -Dtest=TutorialControllerTests
```

