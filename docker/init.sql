/* SQLEditor (Postgres)*/


CREATE TABLE profiles
(
    id         UUID        NOT NULL UNIQUE,
    name       TEXT        NOT NULL UNIQUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT profiles_pkey PRIMARY KEY (id)
);

CREATE INDEX profiles_name_idx ON profiles (name);
