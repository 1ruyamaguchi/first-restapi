-- データベース作成
CREATE DATABASE snaildb;

USE snaildb;

-- テーブル作成
CREATE TABLE users(
    user_id int PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(20) NOT NULL,
    age int NOT NULL,
    remarks TEXT
);

