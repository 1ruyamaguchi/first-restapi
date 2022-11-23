package com.example.firstrestapi.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.firstrestapi.dao.UsersDao;
import com.example.firstrestapi.dto.UsersSelectConditionDto;
import com.example.firstrestapi.entity.Users;
import com.example.firstrestapi.mapper.UsersMapper;

/**
 * usersテーブルのDao実装クラス
 * 
 */
@Component
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void insert(Users users) {

        // ユーザの登録処理
        usersMapper.insert(users);
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public List<Users> selectByCondition(UsersSelectConditionDto usersSelectConditionDto) {

        // 指定した名前のユーザをあいまい検索で抽出
        List<Users> users = usersMapper.selectByCondition(usersSelectConditionDto);

        return users;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void update(Users users) {

        // ユーザ情報の更新
        usersMapper.update(users);
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void delete(String userId) {

        // ユーザの削除
        usersMapper.delete(userId);
    }

}
