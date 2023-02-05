create schema if not exists carddb;
use carddb;
drop table if exists card cascade;
create table  if not exists card (card_id bigint not null primary key, card_number bigint null, card_type varchar(255) null);