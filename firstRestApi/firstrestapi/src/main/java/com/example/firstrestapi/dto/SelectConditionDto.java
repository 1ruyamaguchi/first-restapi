package com.example.firstrestapi.dto;

import lombok.Data;

/**
 * user_listの検索に使うDto
 * 
 */
@Data
public class SelectConditionDto {

    /** ユーザ名 */
    private String userName;
}
