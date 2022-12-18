# Meterpost

Here I learn about Spring Boot 3.0 along with some docker-compose, Liquibase
and TestContainers.

## Development dependencies

* Java 17 SDK
* Docker and docker-compose

## Build and run

Before running the app, start the development database:
```bash
cd database
docker-compose up -d
```

When the database has started, build and start the app:

```bash
./gradlew build
./gradlew bootRun
```

## Run tests

```bash
./gradlew test
```

## Stopping the development database

To stop the development database:
```bash
cd database
docker-compose stop
```

