CREATE ROLE types WITH PASSWORD 'types';
ALTER ROLE types WITH LOGIN;

CREATE DATABASE types OWNER types;

\c types

CREATE DOMAIN ZIPCODE AS VARCHAR(6) CHECK( VALUE ~ '^\d{6}$' );

CREATE TYPE STREETADDRESS AS (city TEXT,  street TEXT, building INT);

CREATE TABLE POSTOFFICE ( id SERIAL PRIMARY KEY, photo bytea, employees varchar(64)[], address STREETADDRESS, code ZIPCODE);

INSERT INTO POSTOFFICE (employees, address, code) VALUES ('{John Doe, Jane Doe}', ('Nowhere', 'Main st.', '17'), '127001');

GRANT SELECT,UPDATE ON TABLE postoffice TO types;

SELECT * FROM POSTOFFICE;
-- id | photo |        employees        |         address
------+-------+-------------------------+-------------------------
--  1 |       | {"John Doe","Jane Doe"} | (Nowhere,"Main st.",17)