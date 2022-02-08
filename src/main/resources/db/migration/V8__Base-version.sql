create table job_title
(
    id            bigint      not null primary key,
    name          varchar(30) not null,
    department_id bigint      not null
);
alter sequence job_title_id_seq owned by job_title.id;
