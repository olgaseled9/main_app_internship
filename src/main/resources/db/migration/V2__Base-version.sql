create table gender
(
    id   bigint      not null primary key,
    name varchar not null
);
alter sequence gender_id_seq owned by gender.id;
