# Database seed data

The content in this directory is used to create initial database content for
development and testing use.

## Warnings

For "production" use, passwords need to be secret. Never use passwords you see
in some random GitHub repository.

## Usage

### To seed the development database

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

After that, the development database is up and running and contains the latest
structure. Now the initial data can be planted there

```bash
docker-compose up --build --scale seed-database=1 seed-database
```
