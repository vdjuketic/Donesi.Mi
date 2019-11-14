DROP TABLE IF EXISTS items;

CREATE TABLE items (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  store VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) DEFAULT NULL
);

INSERT INTO items (store, name, description) VALUES
  ('Nike', 'LeBron XVII', 'Chaos red colorway, size 43 EU'),
  ('Adidas', 'EQT 93/17', 'GTX white colorway'),
  ('Jordan', '1', 'Backboard colorway');