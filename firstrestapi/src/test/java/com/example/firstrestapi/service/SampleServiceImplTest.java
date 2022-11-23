package com.example.firstrestapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.firstrestapi.dto.InputDto;
import com.example.firstrestapi.dto.OutputDto;
import com.example.firstrestapi.dto.UpdateDto;
import com.example.firstrestapi.logic.SampleLogic;

/**
 * SampleServiceImplのテストクラス
 * 
 */
@SpringBootTest
public class SampleServiceImplTest {

    @Autowired
    private SampleService sampleService;

    @MockBean
    private SampleLogic sampleLogic;

    /**
     * postSampleのテスト 正常系 登録に成功
     * 
     */
    @Test
    public void testPostSample_success_registSuccess() {

        // 入力値の設定
        InputDto inputDto = new InputDto();

        // ロジックのモック化
        Mockito.when(sampleLogic.postSample(inputDto)).thenReturn(true);

        // 返却値
        String returnMessage = "";

        try {
            // サービス呼び出し
            returnMessage = sampleService.postSample(inputDto);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertEquals(returnMessage, "postSampleに成功しました。");
    }

    /**
     * postSampleのテスト 正常系 登録に失敗
     * 
     */
    @Test
    public void testPostSample_success_registFailure() {

        // 入力値の設定
        InputDto inputDto = new InputDto();

        // ロジックのモック化
        Mockito.when(sampleLogic.postSample(inputDto)).thenReturn(false);

        // 返却値
        String returnMessage = "";

        try {
            // サービス呼び出し
            returnMessage = sampleService.postSample(inputDto);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertEquals(returnMessage, "postSampleに失敗しました。");
    }

    /**
     * getSampleのテスト 正常系
     * 
     */
    @Test
    public void testGetSample_success() {

        // 入力値の設定
        String userName = "UT_name";

        // ロジックが返す値の設定
        List<OutputDto> returnUserLists = new ArrayList<>();
        OutputDto output1 = new OutputDto();
        output1.setUserId("1");
        output1.setUserName(userName);
        output1.setAge(10);
        output1.setDescription("テスト１号");
        output1.setNowDate(new Timestamp(System.currentTimeMillis()));
        returnUserLists.add(output1);
        OutputDto output2 = new OutputDto();
        output2.setUserId("1");
        output2.setUserName(userName);
        output2.setAge(20);
        output2.setDescription("テスト２号");
        output2.setNowDate(new Timestamp(System.currentTimeMillis()));
        returnUserLists.add(output2);

        // ロジックのモック化
        Mockito.when(sampleLogic.getSample(userName)).thenReturn(returnUserLists);

        // 返却値
        List<OutputDto> result = new ArrayList<>();

        try {
            // サービス呼び出し
            result = sampleService.getSample(userName);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertEquals(output1, result.get(0));
        assertEquals(output2, result.get(1));
    }

    /**
     * putSampleのテスト 正常系 更新に成功
     * 
     */
    @Test
    public void testPutSample_success_registSuccess() {

        // 入力値の設定
        UpdateDto updateDto = new UpdateDto();

        // ロジックのモック化
        Mockito.when(sampleLogic.putSample(any(), any())).thenReturn(true);

        // 返却値
        String returnMessage = "";

        try {
            // サービス呼び出し
            returnMessage = sampleService.putSample(updateDto);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertEquals(returnMessage, "putSampleに成功しました。");
    }

    /**
     * putSampleのテスト 正常系 更新に失敗
     * 
     */
    @Test
    public void testPutSample_success_registFailure() {

        // 入力値の設定
        UpdateDto updateDto = new UpdateDto();

        // ロジックのモック化
        Mockito.when(sampleLogic.putSample(any(), any())).thenReturn(false);

        // 返却値
        String returnMessage = "";

        try {
            // サービス呼び出し
            returnMessage = sampleService.putSample(updateDto);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertEquals(returnMessage, "putSampleに失敗しました。");
    }

    /**
     * deleteSampleのテスト 正常系 削除に成功
     * 
     */
    @Test
    public void testDeleteSample_success_registSuccess() {

        // 入力値の設定
        String userId = "0";

        // ロジックのモック化
        Mockito.when(sampleLogic.deleteSample(userId)).thenReturn(true);

        // 返却値
        String returnMessage = "";

        try {
            // サービス呼び出し
            returnMessage = sampleService.deleteSample(userId);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertEquals(returnMessage, "deleteSampleに成功しました。");
    }

    /**
     * deleteSampleのテスト 正常系 削除に失敗
     * 
     */
    @Test
    public void testDeleteSample_success_registFailure() {

        // 入力値の設定
        String userId = "0";

        // ロジックのモック化
        Mockito.when(sampleLogic.deleteSample(userId)).thenReturn(false);

        // 返却値
        String returnMessage = "";

        try {
            // サービス呼び出し
            returnMessage = sampleService.deleteSample(userId);
        } catch (Exception e) {
            // 例外が投げられたら失敗
            e.printStackTrace();
            fail();
        }

        // 結果のassert
        assertEquals(returnMessage, "deleteSampleに失敗しました。");
    }

}
