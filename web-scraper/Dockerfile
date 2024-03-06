# Use an official Python runtime as a parent image
FROM python:3.9-slim

# Set the working directory in the container
WORKDIR /usr/app/

# Install mysql-connector-python and cron
RUN pip install mysql-connector-python && apt-get update && apt-get -y install cron
RUN pip install -r requirements.txt

# Copy the Python script and the cron job file into the container
COPY indeed-scrape.py .
COPY todo-cron .


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
