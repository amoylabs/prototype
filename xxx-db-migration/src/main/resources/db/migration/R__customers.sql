CREATE TABLE IF NOT EXISTS customers
(
    id            INT AUTO_INCREMENT,
    mobile_phone  VARCHAR(20)  NOT NULL,
    password      VARCHAR(100) NOT NULL,
    password_salt VARCHAR(50)  NOT NULL,
    status        VARCHAR(20)  NOT NULL,
    created_time  DATETIME     NOT NULL,
    updated_time  DATETIME     NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY `idx_customers_mobile_phone` (`mobile_phone`) USING BTREE,
    KEY `idx_customers_mobile_phone_status` (`mobile_phone`, `status`) USING BTREE
) ENGINE = InnoDB;
