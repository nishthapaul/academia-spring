CREATE DATABASE academia;

USE academia;

CREATE TABLE IF NOT EXISTS departments (
    department_id int AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    capacity int NOT NULL,
    PRIMARY KEY (department_id)
);

CREATE TABLE IF NOT EXISTS employees (
    employee_id int AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name varchar(255),
    email varchar(255) NOT NULL UNIQUE,
    title varchar(255),
    photograph_path varchar(255),
    department int,
    password varchar(255) not null,
    PRIMARY KEY (employee_id)
);

CREATE TABLE IF NOT EXISTS organisations (
    organisation_id int AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    address varchar(255),
    PRIMARY KEY (organisation_id)
);

CREATE TABLE IF NOT EXISTS organisation_hr (
    organisation_hr_id int AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name varchar(255),
    email varchar(255) NOT NULL UNIQUE,
    contact_number varchar(255),
    organisation_id int,
    PRIMARY KEY (organisation_hr_id)
);