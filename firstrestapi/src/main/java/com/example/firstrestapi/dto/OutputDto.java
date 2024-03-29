package com.example.firstrestapi.dto;

import java.sql.Timestamp;

import lombok.Data;

/**
 * サンプルサービスの出力モデル
 * 
 */
@Data
public class OutputDto {

    /** ユーザID */
    private String userId;

    /** ユーザ名 */
    private String userName;

    /** 年齢 */
    private Integer age;

    /** 備考 */
    private String remarks;

    /** 現在日付 */
    private Timestamp nowDate;
}
