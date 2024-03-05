# Use an official Python runtime as the base image
FROM python:3.9

# Set the working directory in the container
WORKDIR /app

# Install the required packages using pip
RUN python3 -m pip install beautifulsoup4
RUN python3 -m pip install selenium
RUN python3 -m pip install webdriver-manager
RUN python3 -m pip install pytest

# Copy the rest of the application code to the working directory
COPY . .

# Specify the command to run when the container starts
CMD [ "python3", "indeed-scrape.py" ]
