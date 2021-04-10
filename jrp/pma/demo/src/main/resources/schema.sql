DROP TABLE IF EXISTS project_stakeholder;
DROP TABLE IF EXISTS stakeholder;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS project;

CREATE TABLE project
(
    id          INT         NOT NULL AUTO_INCREMENT,
    name        VARCHAR(32) NOT NULL,
    description VARCHAR(512),
    stage       VARCHAR(32),
    PRIMARY KEY (id)
);

CREATE TABLE employee
(
    id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(32) NOT NULL,
    last_name  VARCHAR(32),
    email      VARCHAR(64),
    project_id INT,
    FOREIGN KEY (project_id) REFERENCES project (id)
);

CREATE TABLE stakeholder
(
    id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(32) NOT NULL,
    last_name  VARCHAR(32),
    role       VARCHAR(32)
);

CREATE TABLE project_stakeholder
(
    project_id     INT NOT NULL,
    stakeholder_id INT NOT NULL,
    FOREIGN KEY (project_id) REFERENCES project (id),
    FOREIGN KEY (stakeholder_id) REFERENCES stakeholder (id)
)