-- V9__add_column_img_type_file_in_table_files.sql

ALTER TABLE files
    ADD COLUMN type_image_upload TEXT NOT NULL
