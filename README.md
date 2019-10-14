# What you'll build
- Set up an API-only application that would return the closest carparks to a user with the parking lot availability

# What you'll need
For building and running the application you need:

- [Docker](https://docs.docker.com/docker-for-mac/install)

# Stack
- [Docker](https://docs.docker.com/docker-for-mac/install)
- [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [MySQL](https://www.mysql.com/downloads/)
- [Gradle](https://gradle.org/install/)

## Installation

Use [docker-compose](https://docs.docker.com/compose/) to setup.

```bash
git clone https://github.com/vtnhanhcmus/carpark.git
cd carpark
cd deployment
docker-compose build
docker-compose up
Access to http://localhost/
```

So if you wanna build new file jar at this time, you need to install gradle in your pc</b>
Because I have some problem with config gradle wrapper. </b>
If we config gradle wrapper success, we don't need to install gradle in your pc.
And run command below

```bash
git clone https://github.com/vtnhanhcmus/carpark.git
cd carpark
cd deployment
sh setup.sh
docker-compose build
docker-compose up
Access to http://localhost/
```

## Overview project
![structure](images/structure.png)

## Database 
![structure](images/database.png)

## How to use 
* [api documents](carpark-api/APIDOCUMENT.md)