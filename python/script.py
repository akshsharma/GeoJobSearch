import os
import mysql.connector
from mysql.connector import Error

def parse_todo_line(line):
    """Parse a line from the text file into  task."""
    task = line.strip()
    return  task

def insert_todo_into_db(cursor, task):
    """Insert a todo note into the database."""
    query = "INSERT INTO note ( text) VALUES ( %s)"
    cursor.execute(query, (task,))

def process_text_files(directory, connection):
    """Process each text file in the specified directory and delete the file after processing."""
    for filename in os.listdir(directory):
        if filename.endswith(".txt"):
            filepath = os.path.join(directory, filename)
            try:
                with open(filepath, 'r') as file:
                    for line in file:
                        task = parse_todo_line(line)
                        insert_todo_into_db(cursor,  task)
                # Commit the transactions to ensure all data is saved
                connection.commit()
                # Delete the file after processing
                os.remove(filepath)
                print(f"Processed and deleted {filepath}")
            except Error as e:
                print(f"Error processing {filepath}: {e}")
                # Rollback in case of error
                connection.rollback()

# Environment variables for MySQL database connection details
db_host = os.getenv('DB_HOST', 'localhost')
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
    print(f"Hello from python script")
    # Connect to the database
    # connection = mysql.connector.connect(**db_config)
    # cursor = connection.cursor()
    
    # Specify the directory where the text files are located
    # directory = "import"
    
    # Process the text files and delete them after processing
    # process_text_files(directory, connection)
    
except Error as e:
    print(f"Error: {e}")
finally:
    if 'connection' in locals() or 'connection' in globals():
        if connection.is_connected():
            cursor.close()
            connection.close()
            print("MySQL connection is closed")
