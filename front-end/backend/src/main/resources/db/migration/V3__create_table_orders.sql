-- v4_create_table_orders.sql

CREATE TABLE IF NOT EXISTS orders (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      pizza_id BIGINT,
                                      user_id BIGINT,
                                      price VARCHAR(255) NOT NULL,
    estimated_time TIME NOT NULL,
    observation VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (pizza_id) REFERENCES pizzas(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

