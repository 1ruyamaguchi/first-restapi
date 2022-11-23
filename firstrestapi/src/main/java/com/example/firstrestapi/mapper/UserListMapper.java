package com.example.firstrestapi.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.firstrestapi.dto.SelectConditionDto;
import com.example.firstrestapi.entity.UserList;

/**
 * user_listテーブルのmapperインターフェース
 * 
 */
@Component
public interface UserListMapper {

    /**
     * ユーザを登録する
     * 
     * @param userList
     */
    void insert(UserList userList);

    /**
     * 検索条件からカラムを抽出する
     * 
     * @param selectConditionDto
     * @return
     */
    List<UserList> selectByCondition(SelectConditionDto selectConditionDto);

    /**
     * ユーザ情報を更新する
     * 
     * @param userList
     */
    void update(UserList userList);

    /**
     * ユーザを削除する
     * 
     * @param userId
     */
    void delete(String userId);
}
