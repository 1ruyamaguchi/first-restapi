package com.example.firstrestapi.enums;

/**
 * コンポーネントを列挙します。
 * 
 */
public enum Component {

    // コンポーネント一覧
    Dao("dao"),
    Logic("logic"),
    Service("service");

    private String component;

    // コンストラクタ
    private Component(String component) {
        this.component = component;
    }

    public String getComponent() {
        return this.component;
    }

}
