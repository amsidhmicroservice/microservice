drop table if exists location cascade;
create table location (location_id bigint not null primary key, longitude double precision null, latitude double precision null);