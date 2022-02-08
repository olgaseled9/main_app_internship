create table employee
(
    employee_id         bigint      not null primary key,
    first_name varchar(25) not null,
    last_name  varchar(30) not null,
    department_id bigint not null,
    job_title  varchar(30) not null,
    gender_id    bigint      not null,
    date_of_birth  date         not null
);
alter sequence employee_id_seq owned by employee.employee_id;