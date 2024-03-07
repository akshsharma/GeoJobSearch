# Use the mariadb image
FROM mariadb

RUN apt-get update && apt-get install -y mysql-client && mariadb-install-db

# Copy all the files in the docker-entrypoint-initdb.d inside the container 
# which will run automatically when the sql server will start
COPY ./scripts/setup.sql /docker-entrypoint-initdb.d/
COPY ./scripts/dumme_data.sql /docker-entrypoint-initdb.d/

