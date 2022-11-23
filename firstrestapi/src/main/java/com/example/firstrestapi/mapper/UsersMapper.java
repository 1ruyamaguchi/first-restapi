package com.example.firstrestapi.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.firstrestapi.dto.UsersSelectConditionDto;
import com.example.firstrestapi.entity.Users;

/**
 * usersテーブルのmapperインターフェース
 * 
 */
@Component
public interface UsersMapper {

    /**
     * ユーザを登録する
     * 
     * @param users
     */
    void insert(Users users);

    /**
     * 検索条件からカラムを抽出する
     * 
     * @param usersSelectConditionDto
     * @return
     */
    List<Users> selectByCondition(UsersSelectConditionDto usersSelectConditionDto);

    /**
     * ユーザ情報を更新する
     * 
     * @param users
     */
    void update(Users users);

    /**
     * ユーザを削除する
     * 
     * @param userId
     */
    void delete(String userId);
}
