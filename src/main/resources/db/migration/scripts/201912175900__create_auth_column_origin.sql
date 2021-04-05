-- liquibase formatted sql
-- changeset rafael.boekel:201912175900__create_auth_column_origin.sql


alter table auth add column origin varchar(20) default 'BANKING' not null;