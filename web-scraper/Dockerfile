# Use an official Python runtime as a parent image
FROM python:3.9-slim

# Set the working directory in the container
WORKDIR /usr/app/

# Copy in requirements.txt
COPY requirements.txt .

# Install mysql-connector-python and cron
COPY requirements.txt .
RUN pip install mysql-connector-python && apt-get update && apt-get -y install cron
RUN pip install -r requirements.txt 

# Copy the Python script and the cron job file into the container
# Also copy the test files and the web scraper output
# We have to copy in the test files manually for now... I'd like to change that
COPY indeed-scrape.py .
COPY todo-cron .
COPY test_indeed.py .
COPY simple_test.py .
COPY indeed_job_listings.json .

COPY db_write_script.py . 
# This script will write to the MariaDB
RUN python db_write_script.py


# These next lines set up a cron job to
# run the script every 24 hours.
# not necessary for testing but useful
# for deployment.

COPY todo-cron /etc/cron.d/todo-cron

# Give execution rights on the cron job
RUN chmod 0644 /etc/cron.d/todo-cron

# Apply cron job
RUN crontab /etc/cron.d/todo-cron

# Create the `import` directory where the text files will be placed
RUN mkdir /usr/app/import

# Create a log file to store the output from the cron job
RUN touch /var/log/cron.log

# Run the command on container startup
CMD cron && tail -f /var/log/cron.log
