DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    order_date DATE         NOT NULL,
    items      ARRAY        NOT NULL,
    payment    VARCHAR(250) NOT NULL
);

INSERT INTO orders (order_date, items, payment)
VALUES ('2019-04-15', '1,3', '1'),
       ('2019-07-01', '2,3', '2'),
       ('2019-10-20', '3', '3');