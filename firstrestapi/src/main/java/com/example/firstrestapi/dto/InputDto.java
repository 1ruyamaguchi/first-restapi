package com.example.firstrestapi.dto;

import lombok.Data;

/**
 * サンプルサービスの入力モデル
 * 
 */
@Data
public class InputDto {

    /** ユーザ名 */
    private String userName;

    /** 年齢 */
    private Integer age;

    /** 説明 */
    private String description;
}
