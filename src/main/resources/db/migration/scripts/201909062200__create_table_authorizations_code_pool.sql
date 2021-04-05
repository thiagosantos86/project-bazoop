-- liquibase formatted sql
-- changeset thiago.bezerra:201909062200__create_table_authorizations_code_pool.sql

create table authorization_code_pool(
    id serial not null primary key,
    date date not null,
    current_code bigint not null
);

create unique index authorization_code_pool_date
    on authorization_code_pool (date);

comment on table authorization_code_pool is 'Tabela que armazena os próximos códigos de autorização vigentes para uma determinada data';
comment on column authorization_code_pool.id is 'Chave primária artificial';
comment on column authorization_code_pool.date is 'Coluna que armazena a data de vigência do próximo código de autorização';
comment on column authorization_code_pool.current_code is 'Coluna que armazena o próximo código de autorização a ser usado';

--rollback drop table authorization_code_pool cascade