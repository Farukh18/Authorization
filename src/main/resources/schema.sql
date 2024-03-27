drop table if exists TASKS;

drop table if exists USERS;

create table users
(
    id         integer generated by default as identity,
    email      varchar(255) unique,
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255),
    role       varchar(255) check (role in ('USER', 'ADMIN')),
    primary key (id)
);
CREATE TABLE tasks
(
    id       INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    describe VARCHAR(255) NOT NULL,
    status   VARCHAR(255) NOT NULL,
    owner    INT          NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (owner) REFERENCES users (id)
);
