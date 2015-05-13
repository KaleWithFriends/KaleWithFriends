# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table farmer (
  id                        bigint not null,
  location                  varchar(255),
  picture_location          varchar(255),
  phone                     varchar(255),
  password                  varchar(255),
  name                      varchar(255),
  constraint pk_farmer primary key (id))
;

create table feed (
  id                        bigint not null,
  time                      timestamp,
  entry                     varchar(255),
  farmer_id                 bigint,
  constraint pk_feed primary key (id))
;

create table market (
  id                        bigint not null,
  market_name               varchar(255),
  location                  varchar(255),
  constraint pk_market primary key (id))
;

create table procedure (
  id                        bigint not null,
  recipe_id                 bigint,
  procedure                 varchar(255),
  constraint pk_procedure primary key (id))
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
  start_date                timestamp,
  end_date                  timestamp,
  price                     varchar(255),
  image                     varchar(255),
  name                      varchar(255),
  quantity                  integer,
  farmer_id                 bigint,
  recipe_id                 bigint,
  constraint pk_timed_ingredient primary key (id))
;


create table farmer_market (
  farmer_id                      bigint not null,
  market_id                      bigint not null,
  constraint pk_farmer_market primary key (farmer_id, market_id))
;
create sequence farmer_seq;

create sequence feed_seq;

create sequence market_seq;

create sequence procedure_seq;

create sequence recipe_seq;

create sequence timed_ingredient_seq;

alter table feed add constraint fk_feed_farmer_1 foreign key (farmer_id) references farmer (id) on delete restrict on update restrict;
create index ix_feed_farmer_1 on feed (farmer_id);
alter table procedure add constraint fk_procedure_recipe_2 foreign key (recipe_id) references recipe (id) on delete restrict on update restrict;
create index ix_procedure_recipe_2 on procedure (recipe_id);
alter table timed_ingredient add constraint fk_timed_ingredient_farmer_3 foreign key (farmer_id) references farmer (id) on delete restrict on update restrict;
create index ix_timed_ingredient_farmer_3 on timed_ingredient (farmer_id);
alter table timed_ingredient add constraint fk_timed_ingredient_recipe_4 foreign key (recipe_id) references recipe (id) on delete restrict on update restrict;
create index ix_timed_ingredient_recipe_4 on timed_ingredient (recipe_id);



alter table farmer_market add constraint fk_farmer_market_farmer_01 foreign key (farmer_id) references farmer (id) on delete restrict on update restrict;

alter table farmer_market add constraint fk_farmer_market_market_02 foreign key (market_id) references market (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists farmer;

drop table if exists farmer_market;

drop table if exists feed;

drop table if exists market;

drop table if exists procedure;

drop table if exists recipe;

drop table if exists timed_ingredient;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists farmer_seq;

drop sequence if exists feed_seq;

drop sequence if exists market_seq;

drop sequence if exists procedure_seq;

drop sequence if exists recipe_seq;

drop sequence if exists timed_ingredient_seq;

