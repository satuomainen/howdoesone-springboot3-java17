FROM liquibase/liquibase:4.19

RUN lpm add postgresql --global

# Create directory for the seed data
RUN mkdir -p /liquibase/seed

# Configuration file
COPY ./migrations/liquibase.properties liquibase.properties

# Copy seed files into the container
COPY ./dbseed/* /liquibase/seed/

CMD ["liquibase", \
    "--searchPath=seed", \
    "--changeLogFile=dbseed.xml", \
    "update" \
]
