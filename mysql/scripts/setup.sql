SELECT 'Starting setup.sql script execution at ' AS message, NOW() AS timestamp;

CREATE DATABASE IF NOT EXISTS template_db;
use template_db;

CREATE TABLE IF NOT EXISTS employer
(
    employer_id INT AUTO_INCREMENT PRIMARY KEY,
    employer_name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS job
(
    job_id INT AUTO_INCREMENT PRIMARY KEY,
    job_title TEXT NOT NULL,
    job_description TEXT NOT NULL,
    job_location TEXT NOT NULL,
    job_salary_min DECIMAL(10, 2) NOT NULL,
    job_salary_max DECIMAL(10, 2) NOT NULL,
    employer_id INT NOT NULL, 
    FOREIGN KEY (employer_id) REFERENCES employer(employer_id)
);

CREATE TABLE IF NOT EXISTS test
(
    test_id INT AUTO_INCREMENT PRIMARY KEY
);

-- some small test data so we have something to work with

INSERT INTO employer (employer_name) VALUES
('ABC Company'),
('XYZ Corporation'),
('123 Enterprises');

INSERT INTO job (job_title, job_description, job_location, job_salary_min, job_salary_max, employer_id) VALUES
('Software Engineer', 'Develop and maintain software applications', 'New York', 60000.00, 80000.00, 1),
('Marketing Manager', 'Plan and execute marketing campaigns', 'Los Angeles', 50000.00, 70000.00, 1),
('Financial Analyst', 'Analyze financial data and prepare reports', 'Chicago', 55000.00, 75000.00, 1),
('Data Analyst', 'Collect and analyze data to inform business decisions', 'San Francisco', 55000.00, 75000.00, 1),
('Sales Representative', 'Sell company products and services to potential customers', 'Houston', 45000.00, 65000.00, 1);
