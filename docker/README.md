# Docker Setup

```
sudo nano /etc/hosts
```

paste below
 
  

cd docker

wget https://raw.githubusercontent.com/nodesense/kafka/main/docker/.env

wget https://raw.githubusercontent.com/nodesense/kafka/main/docker/common.yml


wget https://raw.githubusercontent.com/nodesense/kafka/main/docker/postgres.yml
```

```
docker compose  -f common.yml -f postgres.yml up
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
