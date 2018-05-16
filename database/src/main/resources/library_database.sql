CREATE SCHEMA library_storage;

CREATE TABLE library_storage.role (
  id   SERIAL PRIMARY KEY,
  name CHARACTER VARYING(128) NOT NULL UNIQUE
);

INSERT INTO library_storage.role (name) VALUES (
  'admin'
);

CREATE TABLE library_storage."user" (
  id             BIGSERIAL PRIMARY KEY,
  name           CHARACTER VARYING(128) NOT NULL UNIQUE,
  password       CHARACTER VARYING(128) NOT NULL UNIQUE,
  telephone      CHARACTER VARYING(128),
  addres_mailbox CHARACTER VARYING(128),
  role_id        INTEGER                NOT NULL REFERENCES library_storage.role (id)
);

CREATE TABLE library_storage.genre (
  id   BIGSERIAL PRIMARY KEY,
  name CHARACTER VARYING(128) NOT NULL UNIQUE
);

CREATE TABLE library_storage.author (
  id   BIGSERIAL PRIMARY KEY,
  name CHARACTER VARYING(128) NOT NULL UNIQUE
);

CREATE TABLE library_storage.publisher (
  id   BIGSERIAL PRIMARY KEY,
  name CHARACTER VARYING(128) NOT NULL UNIQUE
);

CREATE TABLE library_storage.book (
  id            BIGSERIAL PRIMARY KEY,
  name          CHARACTER VARYING NOT NULL UNIQUE,
  genre_id      BIGINT REFERENCES library_storage.genre (id),
  author_id     BIGINT REFERENCES library_storage.author (id),
  publisher_id  BIGINT REFERENCES library_storage.publisher (id),
  page_count    INTEGER,
  image         CHARACTER VARYING(256),
  number_copies INTEGER,
  description   TEXT
);

CREATE TABLE library_storage.review (
  id          BIGSERIAL PRIMARY KEY,
  book_id     BIGINT NOT NULL REFERENCES library_storage.book (id),
  user_id     BIGINT REFERENCES library_storage."user" (id),
  text_review TEXT   NOT NULL
);
DROP TABLE library_storage.review;

CREATE TABLE library_storage.vote (
  id      BIGSERIAL PRIMARY KEY,
  book_id BIGINT  NOT NULL REFERENCES library_storage.book (id),
  value   NUMERIC NOT NULL
);

CREATE TABLE library_storage.user_book (
  id          BIGSERIAL PRIMARY KEY,
  user_id     BIGINT NOT NULL REFERENCES library_storage."user" (id),
  book_id     BIGINT NOT NULL  REFERENCES library_storage.book (id),
  date_issue  DATE   NOT NULL,
  date_return DATE   NOT NULL
);

INSERT INTO library_storage."user" (name, password, telephone, addres_mailbox, role_id) VALUES (
  'admin', 'admin', '1234567', 'admin@mail.com', (SELECT id
                                                  FROM library_storage.role
                                                  WHERE name = 'admin')
);