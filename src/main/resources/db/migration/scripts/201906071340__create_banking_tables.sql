-- liquibase formatted sql
-- changeset rafael.boekel:201906071340__create_banking_tables.sql

create table marketplace
(
    id serial not null
        constraint branches_pkey
            primary key,
    external_key uuid not null,
    branch bigint not null,
    status varchar(15),
    created_at timestamp default CURRENT_TIMESTAMP not null,
    updated_at timestamp default CURRENT_TIMESTAMP,
    type varchar(20) default 'unknown'::character varying not null,
    name varchar(255) not null,
    phone_number varchar(20) not null,
    alias varchar(20),
    support_email varchar(254) not null,
    dflag smallint default 1 not null,
    description text,
    owner_customer_id uuid,
    id_parent_marketplace uuid,
    statement_descriptor varchar(255),
    origin varchar(255) default 'BANKING'::character varying not null
);

create table holder
(
    id serial not null
        constraint holders_pkey
            primary key,
    external_key uuid not null,
    status varchar(15),
    marketplace_id bigint
        constraint fk_holder_marketplace
            references marketplace,
    name varchar(255) not null,
    cpf varchar(11) not null,
    email varchar(255) null,
    cnpj varchar(14),
    corporate_name varchar(255),
    mothers_name varchar(255),
    address varchar(700),
    phone varchar(20),
    pin integer,
    birthday date,
    metadata text,
    created_at timestamp default CURRENT_TIMESTAMP not null,
    updated_at timestamp default CURRENT_TIMESTAMP,
    origin varchar(255) default 'BANKING'::character varying not null,
    data_validation varchar(255) default 'VALID'::character varying not null,
    delinquent boolean default false not null
);

create table account
(
    id serial not null
        constraint accounts_pkey
            primary key,
    external_key uuid not null,
    balance bigint not null,
    blocked_balance bigint not null,
    currency varchar(255),
    number bigint not null,
    status varchar(15),
    owner_id bigint
        constraint fk_account_holder_owner
            references holder,
    nsu bigint default 0 not null,
    metadata text,
    created_at timestamp default CURRENT_TIMESTAMP not null,
    updated_at timestamp default CURRENT_TIMESTAMP,
    version bigint,
    primary_account boolean default true,
    receiving_policy varchar(6) default 'NONE' not null,
    last_payout_date timestamp
);

create table balance_reserve
(
    id serial not null
        constraint balance_reserve_operation_pk
        primary key,
    external_key uuid not null,
    type varchar(30) not null,
    status varchar(15) not null,
    created_at timestamp default CURRENT_TIMESTAMP not null,
    updated_at timestamp default CURRENT_TIMESTAMP
);

create table auth
(
    id serial not null
        constraint auth_pk
        primary key,
    external_key uuid not null,
    type varchar(20) not null,
    dtype varchar(50) not null,
    status varchar(15) not null,
    balance_reserve_id bigint
        constraint fk_balance_reserve_id
        references balance_reserve ,
    block_reason varchar(50) default null,
    created_at timestamp default CURRENT_TIMESTAMP not null,
    updated_at timestamp default CURRENT_TIMESTAMP
);

create table auth_event
(
    id serial not null
        constraint auth_event_pk
        primary key,
    auth_id bigint
      constraint fk_auth_event_auth_id
        references auth ,
    account_id bigint not null
        constraint fk_auth_event_account_id
            references account,
    amount bigint not null,
    created_at timestamp default CURRENT_TIMESTAMP not null
);

create unique index marketplace_externalkey
    on marketplace (external_key);

create index holders_marketplaceid_index
    on holder (marketplace_id);

create unique index holder_externalkey
    on holder (external_key);

create index accounts_ownerid_index
    on account (owner_id);

create unique index account_externalkey
    on account (external_key);

create unique index auth_external_key_unique
    on auth (external_key);