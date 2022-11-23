package com.example.firstrestapi.common;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvDataSet;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;

import com.example.firstrestapi.enums.Component;

public class TestConfig {

    /**
     * csv形式で作成したテストデータを挿入します。
     * 
     * @param dao         コンポーネント（dao, logic, service）を選択します。
     * @param testDataDir テストデータを格納しているディレクトリを選択します。
     * @throws Exception
     */
    public static void testDataSetup(Component dao, String testDataDir) throws Exception {

        // データベース名
        final String DATABASE_NAME = "snaildb";
        // プロジェクト名
        final String PROJECT_NAME = "firstrestapi";

        // テスト用csvデータのファイルパス
        final String TESTDATA_BASIC_PATH = "src/test/java/com/example/" + PROJECT_NAME + "/" + dao + "/dbdata/";
        // DBの接続情報
        final String DATABASE_URL = "jdbc:mariadb://localhost:3306/" + DATABASE_NAME;
        final String DATABASE_USER_NAME = "root";
        final String DATABASE_PASSWORD = "password";

        // DBコネクション取得
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME,
                DATABASE_PASSWORD);
        IDatabaseConnection databaseConnection = new MySqlConnection(connection, DATABASE_NAME);

        // csv用データセット作成
        IDataSet dataset = new CsvDataSet(new File(TESTDATA_BASIC_PATH + testDataDir));

        // データの削除、挿入
        DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, dataset);
    }

}
