DROP TABLE IF EXISTS employees;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1;

CREATE TABLE employees
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR(255) NOT NULL,
    surname    VARCHAR(255) NOT NULL,
    department VARCHAR(255) NOT NULL,
    salary     INTEGER      NOT NULL
);
