#!/usr/bin/env ash
# Helper script to run the migrations with Liquibase while building the
# integration test database image

# Capture username and password from the command line
export POSTGRES_USER=$1
export POSTGRES_PASSWORD=$2
export LB_ROOT=$3

# Start the server, save the process id
/usr/local/bin/docker-entrypoint.sh postgres &
echo $! > /postgres.pid

# Wait for server to come up
for COUNTER in {1..30}
do
  sleep 1
  /usr/local/bin/pg_isready
  if [ $? -eq 0 ]
  then
    break
  fi
done

# Run the migrations
cd ${LB_ROOT}
./liquibase \
    --log-level=warn \
    --classpath=./postgresql-42.5.3.jar \
    --url=jdbc:postgresql://localhost:5432/meterpost \
    --username=${POSTGRES_USER} \
    --password=${POSTGRES_PASSWORD} \
    --changeLogFile=dbchangelog.xml \
    --searchPath="./changelog,./changelog/changesets" \
    update

echo "Dumping the database structure"
pg_dump \
  -h localhost \
  -U ${POSTGRES_USER} \
  -f /000_initial_database.sql \
  meterpost

# Stop the server and wait for it to die
kill $(cat /postgres.pid)
echo "Waiting for the postgres server to shut down"
for COUNTER in {1..30}
do
  sleep 1
  /usr/local/bin/pg_isready
  if [ $? -lt 0 ]
  then
    break
  fi
done
