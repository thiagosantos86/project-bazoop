-- liquibase formatted sql
-- changeset rafael.boekel:201912261138__update_auth_origin.sql

update auth set origin = 'ACQUIRER' where type = 'CASH_IN';

--rollback update auth set origin = 'BANKING' where type = 'CASH_IN';