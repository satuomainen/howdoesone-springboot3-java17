# Meterpost development database structure

Liquibase is used to manage database structure changes and the initial data
used for development and test purposes.

## Starting the development database

To start the development database, run

```bash
docker-compose up -d
```

## Stopping the development database

To stop the development database and saving the current data stored there, run

```bash
docker-compose stop
```

## Deleting development database

To stop the development database and delete all data in there, run

```bash
docker-compose down -v
```

This will stop the database and delete the volume where the data was kept.

## Database migrations

Please see the [migrating instructions](./migrations/README.md).

## Seeding the development database with initial data

Please see the [dbseed instructions](./dbseed/README.md).

## Integration test database

The integration database image is used by TestContainers to provide a live
database with the same content as the development database.

Please see the [integration database image instructions](./integration-test/README.md).
