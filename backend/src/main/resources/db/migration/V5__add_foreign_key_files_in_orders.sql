-- V6__add_foreign_key_files_in_orders.sql

ALTER TABLE orders
    ADD COLUMN file_id BIGINT,
    ADD CONSTRAINT fk_orders_files FOREIGN KEY (file_id) REFERENCES files(id);
