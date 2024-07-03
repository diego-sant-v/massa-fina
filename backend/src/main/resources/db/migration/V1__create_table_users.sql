-- v1_create_table_users.sql

CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     login TEXT NOT NULL UNIQUE,
                                     email VARCHAR(255) NOT NULL,
                                     password TEXT NOT NULL,
                                     role TEXT NOT NULL,
                                     enabled BOOLEAN NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    street_number INT NOT NULL,
    cep VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    complement VARCHAR(255) NOT NULL,
    locality VARCHAR(255) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    dd INT NOT NULL,
    is_admin BOOLEAN NOT NULL,
    is_confirmed BOOLEAN NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
