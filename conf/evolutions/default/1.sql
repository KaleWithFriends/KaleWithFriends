# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ingredient (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_ingredient primary key (id))
;

create table kale_user (
  id                        bigint not null,
  user_type_id              bigint,
  name                      varchar(255),
  location                  varchar(255),
  picture_location          varchar(255),
  phone                     varchar(255),
  constraint pk_kale_user primary key (id))
;

create table market (
  id                        bigint not null,
  market_name               varchar(255),
  location                  varchar(255),
  constraint pk_market primary key (id))
;

create table recipe (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  image_path                varchar(255),
  constraint pk_recipe primary key (id))
;

create table timed_ingredient (
  id                        bigint not null,
  ingredient_id             bigint,
  kale_user_id              bigint,
  recipe_id                 bigint,
  start_date                timestamp,
  end_date                  timestamp,
  price                     varchar(255),
  quantity                  integer,
  constraint pk_timed_ingredient primary key (id))
;

create table user_type (
  id                        bigint not null,
  user_type                 varchar(255),
  constraint pk_user_type primary key (id))
;


create table kale_user_market (
  kale_user_id                   bigint not null,
  market_id                      bigint not null,
  constraint pk_kale_user_market primary key (kale_user_id, market_id))
;
create sequence ingredient_seq;

create sequence kale_user_seq;

create sequence market_seq;

create sequence recipe_seq;

create sequence timed_ingredient_seq;

create sequence user_type_seq;

alter table kale_user add constraint fk_kale_user_userType_1 foreign key (user_type_id) references user_type (id);
create index ix_kale_user_userType_1 on kale_user (user_type_id);
alter table timed_ingredient add constraint fk_timed_ingredient_ingredient_2 foreign key (ingredient_id) references ingredient (id);
create index ix_timed_ingredient_ingredient_2 on timed_ingredient (ingredient_id);
alter table timed_ingredient add constraint fk_timed_ingredient_kaleUser_3 foreign key (kale_user_id) references kale_user (id);
create index ix_timed_ingredient_kaleUser_3 on timed_ingredient (kale_user_id);
alter table timed_ingredient add constraint fk_timed_ingredient_recipe_4 foreign key (recipe_id) references recipe (id);
create index ix_timed_ingredient_recipe_4 on timed_ingredient (recipe_id);



alter table kale_user_market add constraint fk_kale_user_market_kale_user_01 foreign key (kale_user_id) references kale_user (id);

alter table kale_user_market add constraint fk_kale_user_market_market_02 foreign key (market_id) references market (id);

# --- !Downs

drop table if exists ingredient cascade;

drop table if exists kale_user cascade;

drop table if exists kale_user_market cascade;

drop table if exists market cascade;

drop table if exists recipe cascade;

drop table if exists timed_ingredient cascade;

drop table if exists user_type cascade;

drop sequence if exists ingredient_seq;

drop sequence if exists kale_user_seq;

drop sequence if exists market_seq;

drop sequence if exists recipe_seq;

drop sequence if exists timed_ingredient_seq;

drop sequence if exists user_type_seq;

