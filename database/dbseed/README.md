# Database seed data

Files in this directory matching `*.sql`, `*.sql.gz`, or `*.sh` are run when
the DB container starts for the first time. Such files can be used to create
the initial database content.

## Warnings

For "production" use, passwords need to be secret. Never use passwords you see
in some random GitHub repository.

## Usage

### To start the database

```bash
docker-compose up -d
```

### To stop the database

This will only stop the DB and the next time it starts the data will be the
same as before.

```bash
docker-compose stop
```

### To delete the old DB and contents

This will stop the database and delete the volume where the files containing
the database content are stored.

```bash
docker-compose down -v
```
