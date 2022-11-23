package com.example.firstrestapi.entity;

import lombok.Data;

/**
 * user_listテーブルのエンティティクラス
 * 
 */
@Data
public class UserList {

    /** ユーザID */
    private String userId;

    /** ユーザ名 */
    private String userName;

    /** 年齢 */
    private Integer age;

    /** 説明 */
    private String description;
}
