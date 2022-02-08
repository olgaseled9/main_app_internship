insert into employee (employee_id, first_name, last_name, department_id, job_title, gender_id, date_of_birth)
values (nextval('employee_id_seq'), 'Ivan', 'Ivanov', 1, 'project manager',1,'1991-11-27'),
       (nextval('employee_id_seq'), 'Victoria', 'Ivanova', 2, 'senior developer',2,'1992-12-01'),
       (nextval('employee_id_seq'), 'Petr', 'Pertov', 3, 'QA',1,'1995-04-07'),
       (nextval('employee_id_seq'), 'Anna', 'Petrova', 4, 'recruiter',2,'1998-09-14'),
       (nextval('employee_id_seq'), 'Alina', 'Sidorova', 2, 'junior developer',2,'1994-08-08'),
       (nextval('employee_id_seq'), 'Andrey', 'Sidorov', 3, 'QA',1,'1991-11-27'),
       (nextval('employee_id_seq'), 'Inna', 'Drozd', 2, 'middle developer',2,'1992-01-25');

