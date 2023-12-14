CREATE TABLE IF NOT EXISTS user (
    id            INT  PRIMARY KEY,
    email         VARCHAR(60) NOT NULL,
    gender        VARCHAR(60) NOT NULL,
    age           int,
    interests     VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS advertiser (
    id            VARCHAR(60)  PRIMARY KEY,
    name          VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS campaign (
    id            VARCHAR(60) PRIMARY KEY,
    name          VARCHAR(60) NOT NULL,
    startTime     TIMESTAMP NOT NULL,
    endTime       TIMESTAMP NOT NULL,
    target        VARCHAR(255) NOT NULL,
    advertiser_id INT NOT NULL,
    state         VARCHAR(60) NOT NULL
);