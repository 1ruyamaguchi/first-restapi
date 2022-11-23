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

    // TODO selectAll追加
    // TODO 検索条件が入らなかった時のnull -> 空文字処理、およびそれに伴う業務処理側の掃除

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
