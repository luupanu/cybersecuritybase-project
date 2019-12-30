DROP TABLE IF EXISTS Signup;
DROP TABLE IF EXISTS Message;

CREATE TABLE Signup (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(128),
    address VARCHAR(128),
    creditcard VARCHAR(128),
    PRIMARY KEY (id)
);

INSERT INTO Signup (name, address, creditcard) VALUES
    ('Kalle', 'Halpakatu 2', '1234567812345678'),
    ('Jaana', 'Hassukatu 5', '5678123456781234');

CREATE TABLE Message (
    id INTEGER NOT NULL AUTO_INCREMENT,
    message VARCHAR(2048),
    PRIMARY KEY (id)
);

INSERT INTO Message (message) VALUES
    ('Hi everyone! -Jack');