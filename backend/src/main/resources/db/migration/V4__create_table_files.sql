-- V5__create_table_files.sql

CREATE TABLE IF NOT EXISTS files (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      user_id BIGINT,
                                      relative_path VARCHAR(255) NOT NULL,
    is_file BOOLEAN NOT NULL,
    is_image BOOLEAN NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

