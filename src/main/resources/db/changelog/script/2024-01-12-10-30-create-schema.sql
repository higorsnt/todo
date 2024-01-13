--liquibase formatted sql
--changeset higor:create-schema

CREATE TABLE person (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(300) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    CONSTRAINT email_ukey UNIQUE (email)
);

CREATE TABLE task (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    desc TEXT,
    estimated_at DATE,
    done_at DATE,
    person_id BIGINT,
    CONSTRAINT person_id_fk FOREIGN KEY (person_id) REFERENCES person(id)
);