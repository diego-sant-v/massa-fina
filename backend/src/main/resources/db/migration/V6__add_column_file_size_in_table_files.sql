-- V6__add_foreign_key_files_in_orders.sql

ALTER TABLE files
    ADD COLUMN file_size BIGINT NOT NULL;
