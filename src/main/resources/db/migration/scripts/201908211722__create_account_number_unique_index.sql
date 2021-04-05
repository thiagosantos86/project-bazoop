-- liquibase formatted sql
-- changeset rafael.boekel:201908211722__create_account_number_unique_index.sql

create unique index account_number_unique
    on account (number);