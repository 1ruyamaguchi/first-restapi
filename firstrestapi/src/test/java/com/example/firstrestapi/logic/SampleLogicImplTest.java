package com.example.firstrestapi.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.firstrestapi.common.TestConfig;
import com.example.firstrestapi.dao.UsersDao;
import com.example.firstrestapi.dto.InputDto;
import com.example.firstrestapi.dto.OutputDto;
import com.example.firstrestapi.dto.UsersSelectConditionDto;
import com.example.firstrestapi.entity.Users;
import com.example.firstrestapi.enums.Component;

/**
 * SampleLogicImplのテストクラス
 * 
 */
@SpringBootTest
public class SampleLogicImplTest {

    @Autowired
    private SampleLogic sampleLogic;

    @Autowired
    private UsersDao usersDao;

    /**
     * テスト設定
     * 
     */
    @BeforeEach
    private void testConfig() throws Exception {

        // テストデータ作成
        TestConfig.testDataSetup(Component.Logic, "sampleLogicImplTest");
    }

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

        // 最初にデータがないこと
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserId("");
        usersSelectConditionDto.setUserName(userName);
        List<Users> before = usersDao.selectByCondition(usersSelectConditionDto);
        assertEquals(0, before.size());

        InputDto inputDto = new InputDto();
        inputDto.setUserName(userName);
        inputDto.setAge(age);
        inputDto.setRemarks(remarks);

        try {
            // ロジック呼び出し
            sampleLogic.postSample(inputDto);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        List<Users> result = usersDao.selectByCondition(usersSelectConditionDto);
        assertEquals(1, result.size());
    }

    /**
     * getSampleのテスト 正常系
     * 
     */
    @Test
    public void testGetSample_success() {

        // 入力値の設定
        String userName = "getSample";

        // 返却値の定義
        List<OutputDto> usersList = new ArrayList<>();

        try {
            // ロジック呼び出し
            usersList = sampleLogic.getSample(userName);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertEquals(2, usersList.size());
    }

    /**
     * putSampleのテスト 正常系
     * 
     */
    @Test
    public void testPutSample_success() {

        String userId = "4";

        // 更新前のデータを取得
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserId(userId);
        usersSelectConditionDto.setUserName("");
        List<Users> before = usersDao.selectByCondition(usersSelectConditionDto);
        assertEquals(1, before.size());
        assertEquals("putSample", before.get(0).getUserName());
        assertEquals(2, before.get(0).getAge());
        assertEquals("put sample", before.get(0).getRemarks());

        InputDto inputDto = new InputDto();
        inputDto.setUserName("putSample2");
        inputDto.setAge(3);
        inputDto.setRemarks("updated");

        try {
            // ロジック呼び出し
            sampleLogic.putSample(userId, inputDto);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        List<Users> result = usersDao.selectByCondition(usersSelectConditionDto);
        assertEquals(1, result.size());
        assertEquals("putSample2", result.get(0).getUserName());
        assertEquals(3, result.get(0).getAge());
        assertEquals("updated", result.get(0).getRemarks());
    }

    /**
     * deleteSampleのテスト 正常系
     * 
     */
    @Test
    public void testDeleteSample_success() {

        String userId = "1";

        try {
            // ロジック呼び出し
            sampleLogic.deleteSample(userId);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserId(userId);
        usersSelectConditionDto.setUserName("");
        List<Users> result = usersDao.selectByCondition(usersSelectConditionDto);
        assertEquals(0, result.size());
    }
}
