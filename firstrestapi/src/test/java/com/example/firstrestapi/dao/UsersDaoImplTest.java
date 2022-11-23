package com.example.firstrestapi.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.firstrestapi.common.TestConfig;
import com.example.firstrestapi.dao.impl.UsersDaoImpl;
import com.example.firstrestapi.dto.UsersSelectConditionDto;
import com.example.firstrestapi.entity.Users;
import com.example.firstrestapi.enums.Component;

/**
 * UserListDaoのテストクラス
 * 
 */
@SpringBootTest
public class UsersDaoImplTest {

    @Autowired
    private UsersDaoImpl usersDao;

    /**
     * テスト設定
     * 
     */
    @BeforeEach
    private void testConfig() throws Exception {

        // テストデータ作成
        TestConfig.testDataSetup(Component.Dao, "usersDaoImplTest");
    }

    /**
     * insertのテスト 正常系
     * 
     */
    @Test
    public void testInsert_success() {

        // 挿入するデータの設定
        String userName = "insertマン";
        Integer age = 28;
        String remarks = "単体テスト用のテストデータです。";

        Users users = new Users();
        users.setUserName(userName);
        users.setAge(age);
        users.setRemarks(remarks);

        try {
            // dao呼び出し
            usersDao.insert(users);
        } catch (Exception e) {
            // 例外をキャッチしたら失敗
            e.printStackTrace();
            fail();
        }
    }

    /**
     * usersSelectByConditionのテスト userNameが空の場合に動くこと
     * 
     */
    @Test
    public void testSelectByCondition_emptyUserName_success() {

        // 検索条件の設定
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserName("");

        List<Users> usersList = new ArrayList<Users>();

        try {
            // dao呼び出し
            usersList = usersDao.selectByCondition(usersSelectConditionDto);
        } catch (Exception e) {
            // 例外をキャッチしたら失敗
            e.printStackTrace();
            fail();
        }

        assertEquals(2, usersList.size());
    }

    /**
     * usersSelectByConditionのテスト userNameが空でない場合に動くこと
     * 
     */
    @Test
    public void testSelectByCondition_notEmptyUserName_success() {

        // 検索条件の設定
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserName("nob");

        // 検索結果
        List<Users> usersList = new ArrayList<Users>();

        try {
            // dao呼び出し
            usersList = usersDao.selectByCondition(usersSelectConditionDto);
        } catch (Exception e) {
            // 例外をキャッチしたら失敗
            e.printStackTrace();
            fail();
        }

        assertEquals(1, usersList.size());
    }

    /**
     * updateのテスト 正常系
     * 
     */
    @Test
    public void testUpdate_success() {

        // updateに使うデータの準備
        String userId = "1";
        String userName = "updateマン";
        Integer age = 30;
        String remarks = "単体テスト用のテストデータです。";

        Users users = new Users();
        users.setUserId(userId);
        users.setUserName(userName);
        users.setAge(age);
        users.setRemarks(remarks);

        try {
            // dao呼び出し
            usersDao.update(users);
        } catch (Exception e) {
            // 例外をキャッチしたら失敗
            e.printStackTrace();
            fail();
        }
    }

    /**
     * deleteのテスト 正常系
     * 
     */
    @Test
    public void testDelete_success() {

        // deleteに使うデータの準備
        String userId = "1";
        try {
            // dao呼び出し
            usersDao.delete(userId);
        } catch (Exception e) {
            // 例外をキャッチしたら失敗
            e.printStackTrace();
            fail();
        }
    }

}
