# Managing database structure

Liquibase is used to manage database structure changes and the initial data
used for development and test purposes.

## To run the latest migrations

In the `database` directory, the development database should be started like
this:

```bash
docker-compose up -d
```

If the database has not been created with the migrations yet, the migrations
should be run like this:

```bash
docker-compose up --build --scale migrate-database=1 migrate-database
```

## To add a new migration

1. Add the change as an XML file into the changelog/changesets directory
2. Include the new change set in the `dbchangelog.xml` file
