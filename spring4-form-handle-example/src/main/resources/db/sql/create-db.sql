--DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  name VARCHAR(30),
  age INTEGER,
  neptunKod VARCHAR(30)
);