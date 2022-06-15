create type account_type as ENUM ('checking', 'savings', 'credit');
create type payment_status_type as ENUM ('created', 'sent', 'accepted', 'rejected');

--------------------------------------------------------------------------------

/* SQLEditor (Postgres)*/


CREATE TABLE profiles
(
id UUID NOT NULL UNIQUE ,
name TEXT NOT NULL UNIQUE ,
created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
CONSTRAINT profiles_pkey PRIMARY KEY (id)
);

CREATE TABLE accounts
(
id UUID NOT NULL UNIQUE ,
profile_id UUID NOT NULL,
type ACCOUNT_TYPE NOT NULL,
name TEXT NOT NULL,
number TEXT NOT NULL UNIQUE ,
updated_at TIMESTAMPTZ NOT NULL,
created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
CONSTRAINT accounts_pkey PRIMARY KEY (id)
);

CREATE TABLE payments
(
id UUID NOT NULL UNIQUE ,
amount TEXT NOT NULL,
currency CHAR(3) NOT NULL,
originator UUID NOT NULL,
beneficiary UUID NOT NULL,
sender UUID NOT NULL,
receiver UUID NOT NULL,
status PAYMENT_STATUS_TYPE NOT NULL,
updated_at TIMESTAMPTZ NOT NULL,
created_at TIMESTAMPTZ NOT NULL,
CONSTRAINT payments_pkey PRIMARY KEY (id)
);

CREATE INDEX profiles_name_idx ON profiles(name);

CREATE INDEX accounts_profile_id_idx ON accounts(profile_id);

ALTER TABLE accounts ADD FOREIGN KEY (profile_id) REFERENCES profiles (id);

CREATE INDEX accounts_number_idx ON accounts(number);

ALTER TABLE payments ADD FOREIGN KEY (originator) REFERENCES profiles (id);

ALTER TABLE payments ADD FOREIGN KEY (beneficiary) REFERENCES profiles (id);

ALTER TABLE payments ADD FOREIGN KEY (sender) REFERENCES accounts (id);

ALTER TABLE payments ADD FOREIGN KEY (receiver) REFERENCES accounts (id);

CREATE INDEX payments_status_idx ON payments(status);
