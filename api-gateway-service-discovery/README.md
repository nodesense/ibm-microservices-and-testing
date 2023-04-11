# API GATEWAY and SERVICE DISCOVERY 



```
discoveryserver
spring-gateway
microserviceone
microservicetwo
microservicethree
```

download and extract the zip file

open terminal

```
cd ~

cd Downloads 

cd api-gateway-discovery


export JAVA_HOME=/usr/lib/jvm/java-1.17.0-openjdk-amd64


mvn clean install -f ./discoveryserver/pom.xml  -DskipTests
mvn clean install -f ./spring-gateway/pom.xml  -DskipTests
mvn clean install -f ./microserviceone/pom.xml -DskipTests
mvn clean install -f ./microservicetwo/pom.xml -DskipTests
mvn clean install -f ./microservicethree/pom.xml -DskipTests
```

new terminal 

```
export JAVA_HOME=/usr/lib/jvm/java-1.17.0-openjdk-amd64
 
java -jar ./discoveryserver/target/discoveryserver-0.0.1-SNAPSHOT.jar
```

new terminal 
```
export JAVA_HOME=/usr/lib/jvm/java-1.17.0-openjdk-amd64

 

java -jar ./microserviceone/target/microserviceone-0.0.1-SNAPSHOT.jar
```


new terminal 
```
export JAVA_HOME=/usr/lib/jvm/java-1.17.0-openjdk-amd64

 

java -jar ./microservicetwo/target/microservicetwo-0.0.1-SNAPSHOT.jar
```


new terminal 
```
export JAVA_HOME=/usr/lib/jvm/java-1.17.0-openjdk-amd64

 

java -jar ./microservicethree/target/microservicethree-0.0.1-SNAPSHOT.jar
```

new terminal 

```
export JAVA_HOME=/usr/lib/jvm/java-1.17.0-openjdk-amd64

 

java -jar ./spring-gateway/target/gateway-0.0.1-SNAPSHOT.jar
```

--


PORTS

```

Run discovery server. (PORT - 8761)

Run all three microservices. (PORT - 8661,8662,8663)

Run gateway Service. (PORT - 8080)
```

Validation 


Go to Discovery Service: http://localhost:8761


Go To Url: http://localhost:8661/service-one/get


Go To Url: http://localhost:8662/service-two/get


Go To Url: http://localhost:8663/service-three/get


Go To Url for gateway routing for all three services:

http://localhost:8080/service-one/get


http://localhost:8080/service-two/get


http://localhost:8080/service-three/get


The source code reference: https://github.com/sun-rishi/Spring-Boot-Eureka-Discovery-Server-Spring-Boot-Gateway-Microservices
