-- liquibase formatted sql
-- changeset jorge.gutierrez:202002271900__drop_and_recreate_table.sql

DROP TABLE IF EXISTS operational_limit CASCADE;

CREATE TABLE operational_limit (
    id serial not null primary key,
    date date not null,
    account_external_key uuid not null,
    type varchar(50) not null,
    accumulated bigint not null,
    qty bigint not null,
    CONSTRAINT unq_operation_limit_constr UNIQUE (date, account_external_key, type)
);

comment on table operational_limit is 'Tabela que armazena os limites operacionais';
comment on column operational_limit.id is 'Chave primária artificial';
comment on column operational_limit.date is 'Coluna que armazena a data do limite operacional';
comment on column operational_limit.account_external_key is 'Coluna que armazena o identificação da conta';
comment on column operational_limit.type is 'Coluna que armazena o tipo';
comment on column operational_limit.accumulated is 'Coluna que armazena o valor acumulado das operações';
comment on column operational_limit.qty is 'Coluna que armazena a quantidade de operações';