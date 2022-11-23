package com.example.firstrestapi.logic.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.firstrestapi.dao.impl.UsersDaoImpl;
import com.example.firstrestapi.dto.InputDto;
import com.example.firstrestapi.dto.OutputDto;
import com.example.firstrestapi.dto.UsersSelectConditionDto;
import com.example.firstrestapi.entity.Users;
import com.example.firstrestapi.logic.SampleLogic;

/**
 * サンプルのロジックの実装クラス
 * 
 */
@Component
public class SampleLogicImpl implements SampleLogic {

    @Autowired
    private UsersDaoImpl userListDao;

    /**
     * {@inheritDoc}
     * 
     * @throws Exception
     * 
     */
    @Override
    public boolean postSample(InputDto inputDto) {

        // 返却値
        boolean result;

        // 入力値からエンティティに詰め替え
        Users userList = new Users();
        BeanUtils.copyProperties(inputDto, userList);

        try {
            // データ挿入処理
            userListDao.insert(userList);
        } catch (Exception e) {
            // 例外をキャッチしたらfalseを返す
            result = false;
        }

        // 例外がキャッチされなければtrueを返す
        result = true;

        return result;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public List<OutputDto> getSample(String userName) {

        // 返却値
        List<OutputDto> returnUserLists = new ArrayList<>();

        // 検索条件を設定
        UsersSelectConditionDto usersSelectConditionDto = new UsersSelectConditionDto();
        usersSelectConditionDto.setUserId("");
        usersSelectConditionDto.setUserName(userName);

        // データ取得処理
        List<Users> userLists = userListDao.selectByCondition(usersSelectConditionDto);

        // データを返却値に詰め替え、取得時間を詰め込む
        for (Users userList : userLists) {
            OutputDto outputDto = new OutputDto();
            BeanUtils.copyProperties(userList, outputDto);
            // 協定世界時のUTC 1970年1月1日深夜零時との差をミリ秒で取得
            outputDto.setNowDate(new Timestamp(System.currentTimeMillis()));
            returnUserLists.add(outputDto);
        }

        return returnUserLists;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean putSample(String userId, InputDto inputDto) {

        // 返却値
        boolean result;

        // 入力値からエンティティに詰め替え
        Users userList = new Users();
        userList.setUserId(userId);
        BeanUtils.copyProperties(inputDto, userList);

        try {
            // データ更新処理
            userListDao.update(userList);
        } catch (Exception e) {
            // 例外をキャッチしたらfalseを返す
            result = false;
        }

        // 例外がキャッチされなければtrueを返す
        result = true;

        return result;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean deleteSample(String userId) {

        // 返却値
        boolean result;

        try {
            // データ削除処理
            userListDao.delete(userId);
        } catch (Exception e) {
            // 例外をキャッチしたらfalseを返す
            result = false;
        }

        // 例外がキャッチされなければtrueを返す
        result = true;

        return result;
    }

}
