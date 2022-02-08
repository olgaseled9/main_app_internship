create table department
(
    id   bigint      not null primary key,
    name varchar not null
);
alter sequence department_id_seq owned by department.id;
