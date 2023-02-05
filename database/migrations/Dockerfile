FROM liquibase/liquibase:4.19

RUN lpm add postgresql --global

# Create directories for the migration configurations
RUN mkdir -p /liquibase/changelog/changesets

# Configuration file
COPY ./migrations/liquibase.properties liquibase.properties

# Copy all migrations into the container
COPY ./migrations/changelog/* /liquibase/changelog/
COPY ./migrations/changelog/changesets/* /liquibase/changelog/changesets/

CMD ["liquibase", \
    "--searchPath=changelog", \
    "--changeLogFile=dbchangelog.xml", \
    "update" \
]
