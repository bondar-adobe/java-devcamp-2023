CREATE TABLE IF NOT EXISTS user (
    id            VARCHAR(60)     PRIMARY KEY,
    email         VARCHAR(60)     NOT NULL,
    gender        VARCHAR(60)     NOT NULL,
    age           int             NOT NULL,
    interests     VARCHAR(255)    NOT NULL,
    created_date  TIMESTAMP       NULL
);

ALTER TABLE user ADD CONSTRAINT email_unique UNIQUE (email);

CREATE TABLE IF NOT EXISTS advertiser (
    id            VARCHAR(60)     PRIMARY KEY,
    name          VARCHAR(60)     NOT NULL,
    created_date  TIMESTAMP       NULL
);

CREATE TABLE IF NOT EXISTS advertising_campaign (
    id            VARCHAR(60)     PRIMARY KEY,
    name          VARCHAR(60)     NOT NULL,
    start_time     TIMESTAMP       NOT NULL,
    end_time       TIMESTAMP       NOT NULL,
    target        VARCHAR(255)    NOT NULL,
    advertiser_id VARCHAR(60)     NOT NULL,
    state         VARCHAR(60)     NOT NULL,
    created_date  TIMESTAMP       NULL
);

ALTER TABLE advertising_campaign ADD CONSTRAINT fk_advertiser_id FOREIGN KEY (advertiser_id) REFERENCES advertiser (id);