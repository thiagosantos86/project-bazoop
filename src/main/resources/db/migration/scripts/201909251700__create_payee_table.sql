-- liquibase formatted sql
-- changeset michel.dias:201909251700__create_payee_table.sql

create table payee(
   id serial not null
    constraint payee_pk
    primary key,
    name varchar(125),
    external_key uuid not null,
	type varchar(20),
	holder_id bigint
        constraint fk_payee_holder
            references holder,
	taxpayer_id varchar(50),
	description varchar(125),
	bank_name varchar(100),
	bank_code varchar(30),
	holder_name varchar(125),
	country_code varchar(20),
	account_number varchar(50),
	routing_number varchar(10),
	phone_number varchar(20),
	fingerprint varchar(255),
	address varchar(700),
	debitable boolean,
	verified boolean,
	postal_code_check varchar(20),
	address_line1_check varchar(20),
	deposit_check varchar(20),
	uri varchar(500),
	metadata text,
    created_at timestamp default CURRENT_TIMESTAMP not null,
    updated_at timestamp default CURRENT_TIMESTAMP
);

--rollback drop table payee cascade