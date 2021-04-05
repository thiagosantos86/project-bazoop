-- liquibase formatted sql
-- changeset thiago.bezerra:201910011657__create_receiving_policy_table.sql

create table receiving_policy(
   id serial not null
    constraint receiving_policy_pk
    primary key,
    account_id bigint not null
       constraint fk_receiving_policy_account
           references account,
    payout_interval_type varchar(8) not null,
    payout_day varchar(6) null,
    minimum_amount bigint default 0 not null
);

create unique index receiving_policy_un_index
    on receiving_policy (account_id);

create index receiving_policy_payout_interval_type on receiving_policy(payout_interval_type);

insert into receiving_policy(account_id, payout_interval_type)
select account.id, account.receiving_policy from account where account.receiving_policy = 'DAILY';

insert into receiving_policy (account_id, payout_interval_type, payout_day)
select account.id, 'WEEKLY', account.receiving_policy from account where substring(account.receiving_policy, 1, 2) = 'WD';

insert into receiving_policy (account_id, payout_interval_type, payout_day)
select account.id, 'MONTHLY', account.receiving_policy from account where substring(account.receiving_policy, 1, 2) = 'MD';

comment on table receiving_policy is 'Tabela que armazena as politicas de recebimento para payouts automáticos';
comment on column receiving_policy.id is 'Chave primária artificial';
comment on column receiving_policy.account_id is 'Define a conta digital alvo dessa politica de recebimento';
comment on column receiving_policy.payout_interval_type is 'Define o tipo de periodicidade de pagamentos. DAILY - Diária, WEEKLY - Semanal, MONTHLY - Mensal';
comment on column receiving_policy.payout_day is 'Define o momento, dia do mês ou dia da semana, do payout do automático nas politica mensais ou semanais respectivamente.';
comment on column receiving_policy.minimum_amount is 'Define o balance mínimo que deve existir na conta digital para permitir o payout automático.';


--rollback update account set account.receiving_policy = receiving_policy.payout_interval where receiving_policy.account_id = account.id
--rollback drop table if exists receiving_policy cascade;

