# MySQL , JDBC Source and Sink : Event Sourcing

# MYSQL Table/Database Setup


### Workaround for mysql connection from intelliJ

replace in properties file in jwt project

```
spring.datasource.url= jdbc:mysql://localhost:3306/ecommerce?allowPublicKeyRetrieval=true&useSSL=false
```

## Setup the database 

Now use Portainer console to get into mysql bash..

mysql username: root

mysql password: root


```
mysql -u root -proot
```


```
SELECT User,Host FROM mysql.user;

CREATE USER 'team'@'localhost' IDENTIFIED BY 'team1234';
CREATE USER 'team'@'%' IDENTIFIED BY 'team1234';

CREATE DATABASE ecommerce; 
GRANT ALL ON *.* TO 'team'@'localhost';
GRANT ALL ON *.* TO 'team'@'%';
FLUSH PRIVILEGES;

exit;
```

Exit from the shell

Login as team user with password

```
mysql -uteam -pteam1234
```

```
USE ecommerce;

SHOW TABLES;

```
