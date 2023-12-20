-- set the current working database for the session
USE campaign_manager_db;

-- create the users table
CREATE TABLE IF NOT EXISTS user (
    id            VARCHAR(60)     PRIMARY KEY,
    email         VARCHAR(60)     NOT NULL,
    gender        VARCHAR(60)     NOT NULL,
    age           int             NOT NULL,
    interests     VARCHAR(255)    NOT NULL,
    created_date  TIMESTAMP       NULL
);

-- display the tables in the database
SHOW TABLES;

-- add a unique constraint on the email column
ALTER TABLE user ADD CONSTRAINT email_unique UNIQUE (email);

-- insert some data into the users table
INSERT INTO user (id, email, gender, age, interests, created_date)
values
('aaa', 'ana@adobe.com',"FEMALE",20,'FASHION', '2013-08-05 18:19:03'),
('bbb', 'ionut@adobe.com',"MALE",23,'SPORTS', '2013-08-05 18:19:03');

-- display the data in the users table
SELECT * from user;
