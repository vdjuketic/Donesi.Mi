DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    orders     ARRAY DEFAULT NULL
);

INSERT INTO users (first_name, last_name, orders)
VALUES ('Vukasin', 'Djuketic', '1'),
       ('Plebikus', 'Maksimus', '2,3'),
       ('Jaina', 'Proudmoore', '');