import os
import mysql.connector
from mysql.connector import Error
import time

def create_employers_table_database(cursor):
    """Insert a todo note into the database."""
    query = """CREATE TABLE IF NOT EXISTS employers
                (
                    employer_id INT AUTO_INCREMENT PRIMARY KEY,
                    employer_name TEXT NOT NULL
                );"""
    cursor.execute(query)

# Environment variables for MySQL database connection details
db_host = os.getenv('DB_ADDRESS', 'localhost')
db_database = os.getenv('DB_DATABASE', 'your_default_db_name')
db_user = os.getenv('DB_USER', 'root')
db_password = os.getenv('DB_PASSWORD', 'default_password')


db_config = {
    'host': db_host,
    'user': db_user,
    'password': db_password,
    'database': db_database
}

try:
    # Connect to the database
    connection = mysql.connector.connect(**db_config)
    cursor = connection.cursor()
    create_employers_table_database(cursor)
except Error as e:
    print(f"Error: {e}")
finally:
    if 'connection' in locals() or 'connection' in globals():
        if connection.is_connected():
            cursor.close()
            connection.close()
            print("MySQL connection is closed")

# this is my failed attempt at trying to setup the database to communicate with the webscrapper 

# max_retries = 5
# retry_wait = 5  # seconds to wait between retries
# connection = None  # Define connection outside the try block


# for attempt in range(max_retries):
#     try:
#         connection = mysql.connector.connect(host='mysql', database='template_db', user='root', password='pwd')
#         print("Connected to the database")
#         cursor = connection.cursor()

#         # Load and iterate through the JSON data
#         with open('path_to_your_json_file.json', 'r') as file:
#             jobs = json.load(file)
#             for job in jobs:
#                 job_title = job['job_title']
#                 job_description = job['job_description']
#                 job_location = job['job_location']
#                 salary_min, salary_max = parse_salary(job['job_salary'])
                
#                 # Assume employer_id 1 for simplicity; you might need to insert or find the actual employer_id
#                 employer_id = 1

#                 insert_query = """INSERT INTO job (job_title, job_description, job_location, job_salary_min, job_salary_max, employer_id) 
#                                 VALUES (%s, %s, %s, %s, %s, %s)"""
#                 cursor.execute(insert_query, (job_title, job_description, job_location, salary_min, salary_max, employer_id))
            
#             connection.commit()

#     except Error as e:
#         print(f"Connection attempt {attempt+1} of {max_retries} failed: {e}")
#         time.sleep(retry_wait)  # Wait before retrying
# else:
#     print("Could not connect to the database after several attempts")
#     # Handle the failure to connect after all retries here

# # Make sure to close the connection if it's open
# if 'connection' in locals() and connection.is_connected():
#     connection.close()
#     print("MySQL connection is closed")
