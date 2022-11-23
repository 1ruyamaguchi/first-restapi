package com.example.firstrestapi.dto;

import lombok.Data;

/**
 * usersの検索に使うDto
 * 
 */
@Data
public class UsersSelectConditionDto {

    /** ユーザID */
    private String userId;

    /** ユーザ名 */
    private String userName;
}
