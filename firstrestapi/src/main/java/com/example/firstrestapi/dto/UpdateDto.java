package com.example.firstrestapi.dto;

import lombok.Data;

/**
 * DBの更新に使うDto
 * 
 */
@Data
public class UpdateDto {

    /** ユーザID */
    private String userId;

    /** 更新内容 */
    private InputDto inputDto;
}
