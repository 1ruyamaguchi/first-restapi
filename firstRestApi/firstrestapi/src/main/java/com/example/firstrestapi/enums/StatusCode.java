package com.example.firstrestapi.enums;

/**
 * ステータスのコード値を管理するenumクラス
 * 
 */
public enum StatusCode {

    Failure(0),
    Success(1);

    private int codeValue;

    // コンストラクタ
    private StatusCode(int codeValue) {
        this.codeValue = codeValue;
    }

    public int getCodeValue() {
        return this.codeValue;
    }

}
