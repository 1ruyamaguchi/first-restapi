package com.example.firstrestapi.logic;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.firstrestapi.dto.InputDto;
import com.example.firstrestapi.dto.OutputDto;

/**
 * サンプルのロジックインターフェース CURDそれぞれの処理
 * 
 */
@Component
public interface SampleLogic {

    /**
     * 入力情報をDBに登録する 返却値は登録成否
     * 
     * @param inputDto
     * @return
     * @throws Exception
     */
    boolean postSample(InputDto inputDto);

    /**
     * IDを指定して登録情報を取得する
     * 
     * @param userId
     * @return
     */
    List<OutputDto> getSample(String userName);

    /**
     * 入力情報をもとにDBを更新 返却値は更新成否
     * 
     * @param inputDto
     */
    boolean putSample(String userId, InputDto inputDto);

    /**
     * IDを指定して登録情報を削除する
     * 
     * @param userId
     * @return
     */
    boolean deleteSample(String userId);
}
