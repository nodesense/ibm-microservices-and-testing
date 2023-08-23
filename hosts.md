# Patch host file for local development with Kafka containers as host name

Docker containers are running inside a docker network, the containers are not accssible by hostname by default from host machine.
We add below settings only on dev machine to make the containers related to kafka are accessible on host machine.

Open Terminal
```
sudo gedit /etc/hosts
```

paste below content at end of the file

```
127.0.0.1 zookeeper
127.0.0.1 broker
127.0.0.1 schema-registry
```

Save the file using Gedit Save button..

Close the Gedit

