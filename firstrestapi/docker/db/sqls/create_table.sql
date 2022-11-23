-- データベース作成
CREATE DATABASE snaildb;

USE snaidb;

-- テーブル作成
CREATE TABLE user_list(
    user_id int PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(20) NOT NULL,
    age int NOT NULL,
    description TEXT
);

