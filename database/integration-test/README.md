# Integration test database image

The integration database image is used by TestContainers to provide a live
database with the same content as the development database.

## Building

To build the integration test database, run the gradle task `buildIntegrationDb`:

`./gradlew buildIntegrationDb`

That will create a Docker image that the integration tests can use:

```
docker image ls
REPOSITORY            TAG          IMAGE ID       CREATED             SIZE
meterpostitdb         latest       fabe7af7326c   48 minutes ago      243MB
```

## Use in tests

The image can be used in tests by TestContainers. 

More about that in a future episode.

## Basic operation

The Gradle plugin `com.bmuschko.docker-remote-api` is used to build the
container image. The plugin takes the given Dockerfile and just builds
it just as docker would.

The Dockerfile has two parts:
* build, and 
* main.

The **build** part spins up a database and uses *Liquibase* to run the
migrations so that the database structure will be the same as the development
database. Then the database is dumped with pg_dump into an SQL file that is
available in the build image.

The **main** part takes the database structure dump from the build image and
places it into the special directory where PostgreSQL will magically run it
when the database server spins up. Along with the structure dump a *seed file*
is placed into the same magical directory. When the image is ready, it contains
the database with the correct structure and some test data that can be used in
tests by for example TestContainers.
