package com.example.firstrestapi.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.firstrestapi.dto.SelectConditionDto;
import com.example.firstrestapi.entity.UserList;

/**
 * UserListDaoのテストクラス
 * 
 */
@SpringBootTest
public class UserListDaoTest {

    @Autowired
    private UserListDao userListDao;

    /**
     * Insertのテスト 正常系
     * 
     */
    @Test
    public void testInsert_success() {

        // 挿入するデータの設定
        String userName = "insertマン";
        Integer age = 28;
        String description = "単体テスト用のテストデータです。";

        UserList userList = new UserList();
        userList.setUserName(userName);
        userList.setAge(age);
        userList.setDescription(description);

        try {
            // dao呼び出し
            userListDao.insert(userList);
        } catch (Exception e) {
            // 例外をキャッチしたら失敗
            e.printStackTrace();
            fail();
        }

        // 挿入したデータが存在することの確認
        SelectConditionDto selectConditionDto = new SelectConditionDto();
        selectConditionDto.setUserName(userName);
        // 結果のassert
        List<UserList> userLists = userListDao.selectByCondition(selectConditionDto);
        assertNotNull(userLists);
    }

    /**
     * selectByConditionのテスト userNameが空の場合に動くこと
     * 
     */
    @Test
    public void testSelectByCondition_emptyUserName_success() {

        // 検索条件の設定
        SelectConditionDto selectConditionDto = new SelectConditionDto();
        selectConditionDto.setUserName("");

        // 検索結果
        List<UserList> userLists = new ArrayList<>();

        try {
            // dao呼び出し
            userLists = userListDao.selectByCondition(selectConditionDto);
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
        SelectConditionDto selectConditionDto = new SelectConditionDto();
        selectConditionDto.setUserName("単体");

        // 検索結果
        List<UserList> userLists = new ArrayList<>();

        try {
            // dao呼び出し
            userLists = userListDao.selectByCondition(selectConditionDto);
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
        String description = "単体テスト用のテストデータです。";

        UserList userList = new UserList();
        userList.setUserName(userName);
        userList.setAge(age);
        userList.setDescription(description);

        // データ挿入
        userListDao.insert(userList);

        // 挿入したデータを確認し、userIdを取得する
        SelectConditionDto selectConditionDto = new SelectConditionDto();
        selectConditionDto.setUserName(userName);
        List<UserList> userLists = userListDao.selectByCondition(selectConditionDto);
        String userId = userLists.get(userLists.size() - 1).getUserId();

        // update用のエンティティを作成
        UserList updateUserList = new UserList();
        updateUserList.setUserId(userId);
        updateUserList.setUserName("updateウーマン");
        updateUserList.setAge(20);
        updateUserList.setDescription("更新完了");

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
        String description = "単体テスト用のテストデータです。";

        UserList userList = new UserList();
        userList.setUserName(userName);
        userList.setAge(age);
        userList.setDescription(description);

        // データ挿入
        userListDao.insert(userList);

        // 挿入したデータを確認し、userIdを取得する
        SelectConditionDto selectConditionDto = new SelectConditionDto();
        selectConditionDto.setUserName(userName);
        String userId = userListDao.selectByCondition(selectConditionDto).get(0).getUserId();

        try {
            // dao呼び出し
            userListDao.delete(userId);
        } catch (Exception e) {
            // 例外をキャッチしたら失敗
            e.printStackTrace();
            fail();
        }

        // 削除されたことを確認するためにデータ取得
        List<UserList> userLists = userListDao.selectByCondition(selectConditionDto);
        // 結果のasseret
        assertTrue(userLists.size() == 0);
    }

}
