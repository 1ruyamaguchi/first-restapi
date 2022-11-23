package com.example.firstrestapi.logic;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.firstrestapi.dao.impl.UsersDaoImpl;
import com.example.firstrestapi.dto.InputDto;
import com.example.firstrestapi.dto.OutputDto;
import com.example.firstrestapi.dto.UsersSelectConditionDto;
import com.example.firstrestapi.entity.Users;

/**
 * SampleLogicImplのテストクラス
 * 
 */
@SpringBootTest
public class SampleLogicImplTest {

    @Autowired
    private SampleLogic sampleLogic;

    @Autowired
    private UsersDaoImpl userListDao;

    /**
     * postSampleのテスト 正常系
     * 
     */
    @Test
    public void testPostSample_success() {

        // 入力値の設定
        String userName = "postSample";
        Integer age = 15;
        String remarks = "SampleLogic#postSampleのテスト用データ";

        InputDto inputDto = new InputDto();
        inputDto.setUserName(userName);
        inputDto.setAge(age);
        inputDto.setRemarks(remarks);

        // 返却値の定義
        boolean result = false;

        try {
            // ロジック呼び出し
            result = sampleLogic.postSample(inputDto);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertTrue(result);
    }

    /**
     * getSampleのテスト 正常系
     * 
     */
    @Test
    public void testGetSample_success() {

        // 入力値の設定
        String userName = "getSample";

        // データを仕込む
        Users userList = new Users();
        userList.setUserName(userName);
        userList.setAge(20);
        userList.setRemarks("SampleLogic#getSampleのテスト用データ");
        userListDao.insert(userList);

        // 返却値の定義
        List<OutputDto> resultUserLists = new ArrayList<>();

        try {
            // ロジック呼び出し
            resultUserLists = sampleLogic.getSample(userName);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertNotNull(resultUserLists);
    }

    /**
     * putSampleのテスト 正常系
     * 
     */
    @Test
    public void testPutSample_success() {

        // 入力値の設定
        String userName = "putSample";

        // データを仕込む
        Users userList = new Users();
        userList.setUserName(userName);
        userList.setAge(38);
        userList.setRemarks("SampleLogic#putSampleのテスト用データ");
        userListDao.insert(userList);

        // 挿入したデータを確認し、userIdを取得する
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserName(userName);
        List<Users> userLists = userListDao.selectByCondition(usersSelectConditionDto);
        String userId = userLists.get(userLists.size() - 1).getUserId();

        // update用のinputを作成
        InputDto inputDto = new InputDto();
        inputDto.setUserName("putSample2");
        inputDto.setAge(20);
        inputDto.setRemarks("SampleLogic#putSampleのテスト用データ_更新完了");

        try {
            // ロジック呼び出し
            sampleLogic.putSample(userId, inputDto);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }
    }

    /**
     * deleteSampleのテスト 正常系
     * 
     */
    @Test
    public void testDeleteSample_success() {

        // データを仕込む
        Users userList = new Users();
        String userName = "delSample";
        userList.setUserName(userName);
        userList.setAge(52);
        userList.setRemarks("SampleLogic#deleteSampleのテスト用データ");
        userListDao.insert(userList);

        // 挿入したデータを確認し、userIdを取得する
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserName(userName);
        List<Users> userLists = userListDao.selectByCondition(usersSelectConditionDto);
        String userId = userLists.get(userLists.size() - 1).getUserId();

        try {
            // ロジック呼び出し
            sampleLogic.deleteSample(userId);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // データが削除されていることを確認
        List<Users> resultUserLists = userListDao.selectByCondition(usersSelectConditionDto);
        assertTrue(resultUserLists.size() == 0);
    }
}
