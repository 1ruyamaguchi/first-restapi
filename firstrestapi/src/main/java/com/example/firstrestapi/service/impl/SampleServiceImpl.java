package com.example.firstrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstrestapi.dto.InputDto;
import com.example.firstrestapi.dto.OutputDto;
import com.example.firstrestapi.dto.UpdateDto;
import com.example.firstrestapi.enums.MessageBase;
import com.example.firstrestapi.enums.StatusCode;
import com.example.firstrestapi.logic.SampleLogic;
import com.example.firstrestapi.service.SampleService;

/**
 * サンプルのサービスの実装クラス
 * 
 */
@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleLogic sampleLogic;

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public String postSample(InputDto inputDto) {

        // ロジック呼び出し
        boolean resultJudge = sampleLogic.postSample(inputDto);

        // statusCodeを設定
        int statusCode = getStatusCode(resultJudge);

        // メッセージ作成
        String returnMessage = makeMessage("postSample", statusCode);

        return returnMessage;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public List<OutputDto> getSample(String userName) {

        // ロジック呼び出し
        List<OutputDto> returnUserLists = sampleLogic.getSample(userName);

        return returnUserLists;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public String putSample(UpdateDto updateDto) {

        // ロジック呼び出し
        boolean resultJudge = sampleLogic.putSample(updateDto.getUserId(), updateDto.getInputDto());

        // statusCodeを設定
        int statusCode = getStatusCode(resultJudge);

        // メッセージ作成
        String returnMessage = makeMessage("putSample", statusCode);

        return returnMessage;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public String deleteSample(String userId) {

        // ロジック呼び出し
        boolean resultJudge = sampleLogic.deleteSample(userId);

        // statusCodeを設定
        int statusCode = getStatusCode(resultJudge);

        // メッセージ作成
        String returnMessage = makeMessage("deleteSample", statusCode);

        return returnMessage;
    }

    /**
     * 呼び出しの成否によってstatusCodeを設定
     * 
     * @param resultJudge
     * @return
     */
    private int getStatusCode(boolean resultJudge) {

        int statusCode = StatusCode.Failure.getCodeValue();
        if (resultJudge) {
            statusCode = StatusCode.Success.getCodeValue();
        }

        return statusCode;
    }

    /**
     * メソッド名に対応したメッセージ作成 成功または失敗
     * 
     * @param methodName
     * @return
     */
    private String makeMessage(String methodName, int statusCode) {

        String message = "";

        // statusCodeの値によってメッセージの作成 1:成功、0:失敗
        if (statusCode == 1) {
            message = methodName + MessageBase.Success.getMessageBase();
            return message;
        } else if (statusCode == 0) {
            message = methodName + MessageBase.Failure.getMessageBase();
            return message;
        }

        return message;
    }

}
