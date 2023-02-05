drop table if exists account cascade;
create table account (account_id bigint not null primary key, account_number bigint null, account_type varchar(255) null);