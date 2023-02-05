drop table if exists address cascade;
create table address (address_id bigint not null primary key, city varchar(255) null, state varchar(255) null);