SELECT 'Starting setup.sql script execution at ' AS message, NOW() AS timestamp;

CREATE DATABASE IF NOT EXISTS template_db;
use template_db;

CREATE TABLE IF NOT EXISTS employers
(
    employer_id INT AUTO_INCREMENT PRIMARY KEY,
    employer_name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS jobs
(
    job_id INT AUTO_INCREMENT PRIMARY KEY,
    job_title TEXT NOT NULL,
    job_description TEXT NOT NULL,
    job_location TEXT NOT NULL,
    job_salaray_min DECIMAL(10, 2) NOT NULL,
    job_salaray_max DECIMAL(10, 2) NOT NULL,
    employer_id INT NOT NULL, 
    FOREIGN KEY (employer_id) REFERENCES employers(employer_id)
);

CREATE TABLE IF NOT EXISTS test
(
    test_id INT AUTO_INCREMENT PRIMARY KEY
);
