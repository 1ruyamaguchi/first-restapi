package com.example.firstrestapi.enums;

/**
 * メッセージのベース部分を定義するenumクラス
 * 
 */
public enum MessageBase {

    // 成功可否のメッセージのベース部分
    Success("に成功しました。"),
    Failure("に失敗しました。");

    private String messageBase;

    // コンストラクタ
    private MessageBase(String messageBase) {
        this.messageBase = messageBase;
    }

    public String getMessageBase() {
        return this.messageBase;
    }
}
