drop table if exists person cascade;
create table person (person_id bigint not null primary key, name varchar(255) null, mobile_number bigint null, email_id varchar(255) null);