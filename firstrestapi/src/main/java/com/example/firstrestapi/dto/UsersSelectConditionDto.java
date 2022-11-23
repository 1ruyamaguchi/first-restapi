package com.example.firstrestapi.dto;

import lombok.Data;

/**
 * usersの検索に使うDto
 * 
 */
@Data
public class UsersSelectConditionDto {

    /** ユーザ名 */
    private String userName;
}
