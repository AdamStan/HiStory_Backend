CREATE USER 'history_user' IDENTIFIED BY 'password1';
select user from mysql.user;

GRANT ALL PRIVILEGES ON history_database.* TO 'history_user';
SHOW GRANTS FOR history_user;

USE history_database;
SELECT * FROM history_database.questions;