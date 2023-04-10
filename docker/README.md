# Docker Setup
 
 # Start Portainer for Docker UI
 
 After running commands, open , add security exception in browser..
 
 https://localhost:9443/
 
 Open terminal, run the command in any directory
 
 ```
  docker volume create portainer_data2x
 ```
 
 ```


docker run -d -p 8000:8000 -p 9443:9443 --name portainer2x \
    --restart=always \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v portainer_data2x:/data \
    portainer/portainer-ce:2.9.3

 ```
 
 
 ```

cd docker

wget https://raw.githubusercontent.com/nodesense/kafka/main/docker/.env

wget https://raw.githubusercontent.com/nodesense/kafka/main/docker/common.yml


wget https://raw.githubusercontent.com/nodesense/kafka/main/docker/postgres.yml

wget https://raw.githubusercontent.com/nodesense/kafka/main/docker/mysql.yml

wget https://raw.githubusercontent.com/nodesense/ibm-microservices-and-testing/main/docker/ms.yml
wget https://raw.githubusercontent.com/nodesense/ibm-microservices-and-testing/main/docker/jaeger.yml
wget https://raw.githubusercontent.com/nodesense/ibm-microservices-and-testing/main/docker/kafka.yml

```

now run docker containres in detached mode,(they run in background) but for the Micro Services, run in terminal mode

```
docker compose  -f common.yml -f postgres.yml up -d
docker compose  -f common.yml -f mysql.yml up -d

docker compose  -f common.yml -f jaeger.yml up -d

docker compose  -f common.yml -f kafka.yml up -d

docker compose  -f common.yml -f ms.yml up
```



You need 4 different terminal to run as they start docker container, runs on terminal, when we press Ctrl C, containers are stopped
```
docker compose  -f common.yml -f postgres.yml up
docker compose  -f common.yml -f mysql.yml up

docker compose  -f common.yml -f jaeger.yml up
docker compose  -f common.yml -f ms.yml up
```


## Docker  UI 

Open in browser

https://localhost:9443/#!/auth

username: admin

password: admin@123

## PG Admin


http://localhost:5050

username: admin@example.com
password: admin

===========
