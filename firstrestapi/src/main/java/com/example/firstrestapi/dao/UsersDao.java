package com.example.firstrestapi.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.firstrestapi.dto.UsersSelectConditionDto;
import com.example.firstrestapi.entity.Users;

/**
 * usersテーブルのDaoインターフェースクラスです。
 * 
 */
@Component
public interface UsersDao {

    /**
     * ユーザを登録します。
     * 
     * @param users
     */
    void insert(Users users);

    /**
     * ユーザ名からカラムを抽出します。
     * 
     * @param usersSelectConditionDto
     * @return
     */
    List<Users> selectByCondition(UsersSelectConditionDto usersSelectConditionDto);

    // TODO selectByConditionの検索条件にuserId追加
    // TODO selectAll追加

    /**
     * ユーザ情報を更新します。
     * 
     * @param users
     */
    void update(Users users);

    /**
     * ユーザを削除します。
     * 
     * @param userId
     */
    void delete(String userId);
}
