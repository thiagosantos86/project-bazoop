-- liquibase formatted sql
-- changeset michel.dias:201908151210__rename_and_drop_unused_columns.sql

alter table account rename column owner_id to holder_id;

alter index accounts_ownerid_index rename to accounts_holderid_index;

alter table account rename constraint fk_account_holder_owner to fk_account_holder;

alter table marketplace rename column owner_customer_id to holder_customer_id;

alter table marketplace drop column branch;

alter table account	add routing_number varchar(3) default '001' not null;

alter table holder drop column pin;

--rollback alter table account rename column holder_id to owner_id;
--rollback alter index accounts_holderid_index rename to accounts_ownerid_index;
--rollback alter table account rename constraint fk_account_holder to fk_account_holder_owner;
--rollback alter table marketplace rename column holder_customer_id to owner_customer_id;
--rollback alter table marketplace	add branch bigint not null;
--rollback alter index marketplace_pkey rename to branches_pkey;
--rollback alter table marketplace rename constraint marketplace_pkey to branches_pkey;
--rollback alter table account drop column routing_number;
--rollback alter table holder add pin integer;