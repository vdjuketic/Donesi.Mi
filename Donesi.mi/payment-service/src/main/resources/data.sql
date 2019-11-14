DROP TABLE IF EXISTS payments;

CREATE TABLE payments
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    amount   DOUBLE       NOT NULL,
    currency VARCHAR(250) NOT NULL
);

INSERT INTO payments (amount, currency)
VALUES ('100.0', '$'),
       ('354.3', '€'),
       ('400.06', '€');