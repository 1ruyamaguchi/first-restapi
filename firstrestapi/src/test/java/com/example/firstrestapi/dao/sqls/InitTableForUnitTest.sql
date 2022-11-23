/* 単体テストの初期状態を作るSQLです。DBでこれを流してからUTを実行してください。 */

/* テーブルを壊す */
DROP TABLE user_list;

/* テーブル作成 */
CREATE TABLE user_list(
    user_id int PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(20) NOT NULL,
    age int NOT NULL,
    description TEXT
);

/* サンプルデータ */
INSERT INTO user_list(
    user_name,
    age,
    description
) VALUES(
    'test first',
    '3',
    '試験用データの１号です。'
);

INSERT INTO user_list(
    user_name,
    age,
    description
) VALUES(
    'test second',
    '14',
    '試験用データの２号です。'
);
