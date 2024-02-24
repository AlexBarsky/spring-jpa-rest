CREATE TABLE IF NOT EXISTS country (
    id       SERIAL CONSTRAINT country_pk PRIMARY KEY,
    name    VARCHAR(100)      NOT NULL,
    population INTEGER NOT NULL,
    capital VARCHAR(100) NOT NULL,
    region VARCHAR(100) NOT NULL
);