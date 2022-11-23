package com.example.firstrestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.firstrestapi.dto.SelectConditionDto;
import com.example.firstrestapi.entity.UserList;
import com.example.firstrestapi.mapper.UserListMapper;

/**
 * user_listテーブルのDao
 * 
 */
@Component
public class UserListDao {

    @Autowired
    private UserListMapper userListMapper;

    /**
     * ユーザを登録する
     * 
     * @param userList
     */
    public void insert(UserList userList) {

        // ユーザの登録処理
        userListMapper.insert(userList);
    }

    /**
     * ユーザ名からカラムを抽出する
     * 
     * @param userName
     * @return
     */
    public List<UserList> selectByCondition(SelectConditionDto selectConditionDto) {

        // 指定した名前のユーザをあいまい検索で抽出
        List<UserList> userLists = userListMapper.selectByCondition(selectConditionDto);

        return userLists;
    }

    /**
     * ユーザ情報を更新する
     * 
     * @param userList
     */
    public void update(UserList userList) {

        // ユーザ情報の更新
        userListMapper.update(userList);
    }

    /**
     * ユーザを削除する
     * 
     * @param userId
     */
    public void delete(String userId) {

        // ユーザの削除
        userListMapper.delete(userId);
    }
}
