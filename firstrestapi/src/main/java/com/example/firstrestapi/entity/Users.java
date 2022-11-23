package com.example.firstrestapi.entity;

import lombok.Data;

/**
 * usersテーブルのエンティティクラス
 * 
 */
@Data
public class Users {

    /** ユーザID */
    private String userId;

    /** ユーザ名 */
    private String userName;

    /** 年齢 */
    private Integer age;

    /** 尾行 */
    private String remarks;
}
