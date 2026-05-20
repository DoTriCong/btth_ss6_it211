CREATE DATABASE ss06_db;

USE ss06_db;

CREATE TABLE students (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          full_name VARCHAR(255),
                          email VARCHAR(255),
                          gpa DOUBLE
);

INSERT INTO students(full_name, email, gpa)
VALUES
    ('Nguyen Van A', 'a@gmail.com', 3.2),
    ('Tran Thi B', 'b@gmail.com', 3.8),
    ('Le Van C', 'c@gmail.com', 2.9);