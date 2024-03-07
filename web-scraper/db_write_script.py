import os
import mysql.connector
from mysql.connector import Error

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

