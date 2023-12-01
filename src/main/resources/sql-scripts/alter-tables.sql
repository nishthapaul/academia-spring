ALTER TABLE employees
ADD FOREIGN KEY (department) REFERENCES departments(department_id);

ALTER TABLE organisation_hr
ADD FOREIGN KEY (organisation_id) REFERENCES organisations(organisation_id);