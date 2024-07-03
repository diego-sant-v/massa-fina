-- V7__add_foreign_key_files_in_pizzas.sql

ALTER TABLE pizzas
    ADD COLUMN file_id BIGINT,
    ADD CONSTRAINT fk_pizzas_files FOREIGN KEY (file_id) REFERENCES files(id);

