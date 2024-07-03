CREATE TABLE IF NOT EXISTS pizzas (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      pizza_name VARCHAR(255) NOT NULL,
                                      type_pizza VARCHAR(255) NOT NULL,
    edge VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    ingredients VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );
