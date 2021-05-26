CREATE TABLE USERS (
    id VARCHAR(10) PRIMARY KEY,
    email VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(10) NOT NULL,
    level tinyint NOT NULL,
    login int NOT NULL,
    recommend int NOT NULL
);