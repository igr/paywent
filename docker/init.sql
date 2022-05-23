CREATE TYPE account_type AS ENUM ('checking', 'savings', 'credit');
CREATE TYPE payment_status_type AS ENUM ('created', 'sent', 'accepted', 'rejected');

--------------------------------------------------------------------------------

/* SQLEditor (Postgres)*/


CREATE TABLE accounts
(
    id         UUID         NOT NULL UNIQUE,
    type       ACCOUNT_TYPE NOT NULL,
    name       TEXT         NOT NULL,
    number     TEXT         NOT NULL UNIQUE,
    updated_at TIMESTAMPTZ  NOT NULL,
    created_at TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    CONSTRAINT accounts_pkey PRIMARY KEY (id)
);

CREATE TABLE profiles
(
    id         UUID        NOT NULL UNIQUE,
    name       TEXT        NOT NULL UNIQUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT profiles_pkey PRIMARY KEY (id)
);

CREATE TABLE payments
(
    id          UUID                NOT NULL UNIQUE,
    amount      TEXT                NOT NULL,
    currency    CHAR(3)             NOT NULL,
    originator  UUID                NOT NULL,
    beneficiary UUID                NOT NULL,
    sender      UUID                NOT NULL,
    receiver    UUID                NOT NULL,
    status      PAYMENT_STATUS_TYPE NOT NULL,
    updated_at  TIMESTAMPTZ         NOT NULL,
    created_at  TIMESTAMPTZ         NOT NULL,
    CONSTRAINT payments_pkey PRIMARY KEY (id)
);

CREATE INDEX accounts_number_idx ON accounts (number);

CREATE INDEX profiles_name_idx ON profiles (name);

ALTER TABLE payments
    ADD FOREIGN KEY (originator) REFERENCES profiles (id);

ALTER TABLE payments
    ADD FOREIGN KEY (beneficiary) REFERENCES profiles (id);

ALTER TABLE payments
    ADD FOREIGN KEY (sender) REFERENCES accounts (id);

ALTER TABLE payments
    ADD FOREIGN KEY (receiver) REFERENCES accounts (id);

CREATE INDEX payments_status_idx ON payments (status);
