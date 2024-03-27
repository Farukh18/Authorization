INSERT INTO users (first_name, last_name, email, password, role)
VALUES ('Ivan', 'Ivanov', 'ivan.ivanov@email.com', 'password123', 'admin'),
       ('Anna', 'Petrova', 'anna.petrova@email.com', 'password123', 'user'),
       ('Nikolay', 'Sidorov', 'nikolay.sidorov@email.com', 'password123', 'user');

INSERT INTO tasks (name, describe, status, owner)
VALUES ('Task 1', 'Description for Task 1', 'NEW', 1),
       ('Task 2', 'Description for Task 2', 'IN_PROGRESS', 1),
       ('Task 3', 'Description for Task 3', 'COMPLETED', 2);

INSERT INTO users (first_name, last_name, email, password, role)
VALUES ('Sergey', 'Nikolaev', 'sergey.nikolaev@email.com', 'password123', 'admin'),
       ('Maria', 'Vasilyeva', 'maria.vasilyeva@email.com', 'password123', 'user'),
       ('Alexey', 'Morozov', 'alexey.morozov@email.com', 'password123', 'user'),
       ('Olga', 'Semenova', 'olga.semenova@email.com', 'password123', 'user'),
       ('Dmitry', 'Kozlov', 'dmitry.kozlov@email.com', 'password123', 'user');


INSERT INTO tasks (name, describe, status, owner)
VALUES ('Task 4', 'Description for Task 4', 'NEW', 4),
       ('Task 5', 'Description for Task 5', 'IN_PROGRESS', 4),
       ('Task 6', 'Description for Task 6', 'COMPLETED', 5),
       ('Task 7', 'Description for Task 7', 'COMPLETED', 5),
       ('Task 8', 'Description for Task 8', 'IN_PROGRESS', 6),
       ('Task 9', 'Description for Task 9', 'NEW', 6),
       ('Task 10', 'Description for Task 10', 'IN_PROGRESS', 7),
       ('Task 11', 'Description for Task 11', 'NEW', 8),
       ('Task 12', 'Description for Task 12', 'COMPLETED', 8),
       ('Task 13', 'Description for Task 13', 'NEW', 3);
