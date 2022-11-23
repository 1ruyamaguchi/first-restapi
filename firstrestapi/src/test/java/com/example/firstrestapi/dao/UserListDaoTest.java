package com.example.firstrestapi.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.firstrestapi.dao.impl.UsersDaoImpl;
import com.example.firstrestapi.dto.UsersSelectConditionDto;
import com.example.firstrestapi.entity.Users;

/**
 * UserListDaoのテストクラス
 * 
 */
@SpringBootTest
public class UserListDaoTest {

    @Autowired
    private UsersDaoImpl userListDao;

    /**
     * Insertのテスト 正常系
     * 
     */
    @Test
    public void testInsert_success() {

        // 挿入するデータの設定
        String userName = "insertマン";
        Integer age = 28;
        String remarks = "単体テスト用のテストデータです。";

        Users userList = new Users();
        userList.setUserName(userName);
        userList.setAge(age);
        userList.setRemarks(remarks);

        try {
            // dao呼び出し
            userListDao.insert(userList);
        } catch (Exception e) {
            // 例外をキャッチしたら失敗
            e.printStackTrace();
            fail();
        }

        // 挿入したデータが存在することの確認
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserName(userName);
        // 結果のassert
        List<Users> userLists = userListDao.selectByCondition(usersSelectConditionDto);
        assertNotNull(userLists);
    }

    /**
     * selectByConditionのテスト userNameが空の場合に動くこと
     * 
     */
    @Test
    public void testSelectByCondition_emptyUserName_success() {

        // 検索条件の設定
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserName("");

        // 検索結果
        List<Users> userLists = new ArrayList<>();

        try {
            // dao呼び出し
            userLists = userListDao.selectByCondition(usersSelectConditionDto);
        } catch (Exception e) {
            // 例外をキャッチしたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertNotNull(userLists);
    }

    /**
     * selectByConditionのテスト userNameが空でない場合に動くこと
     * 
     */
    @Test
    public void testSelectByCondition_notEmptyUserName_success() {

        // 検索条件の設定
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserName("単体");

        // 検索結果
        List<Users> userLists = new ArrayList<>();

        try {
            // dao呼び出し
            userLists = userListDao.selectByCondition(usersSelectConditionDto);
        } catch (Exception e) {
            // 例外をキャッチしたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertNotNull(userLists);
    }

    /**
     * updateのテスト 正常系
     * 
     */
    @Test
    public void testUpdate_success() {

        // updateに使うデータの準備
        String userName = "updateマン";
        Integer age = 30;
        String remarks = "単体テスト用のテストデータです。";

        Users userList = new Users();
        userList.setUserName(userName);
        userList.setAge(age);
        userList.setRemarks(remarks);

        // データ挿入
        userListDao.insert(userList);

        // 挿入したデータを確認し、userIdを取得する
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserName(userName);
        List<Users> userLists = userListDao.selectByCondition(usersSelectConditionDto);
        String userId = userLists.get(userLists.size() - 1).getUserId();

        // update用のエンティティを作成
        Users updateUserList = new Users();
        updateUserList.setUserId(userId);
        updateUserList.setUserName("updateウーマン");
        updateUserList.setAge(20);
        updateUserList.setRemarks("更新完了");

        try {
            // dao呼び出し
            userListDao.update(updateUserList);
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
        String userName = "deleteマン";
        Integer age = 60;
        String remarks = "単体テスト用のテストデータです。";

        Users userList = new Users();
        userList.setUserName(userName);
        userList.setAge(age);
        userList.setRemarks(remarks);

        // データ挿入
        userListDao.insert(userList);

        // 挿入したデータを確認し、userIdを取得する
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserName(userName);
        String userId = userListDao.selectByCondition(usersSelectConditionDto).get(0).getUserId();

        try {
            // dao呼び出し
            userListDao.delete(userId);
        } catch (Exception e) {
            // 例外をキャッチしたら失敗
            e.printStackTrace();
            fail();
        }

        // 削除されたことを確認するためにデータ取得
        List<Users> userLists = userListDao.selectByCondition(usersSelectConditionDto);
        // 結果のasseret
        assertTrue(userLists.size() == 0);
    }

}
