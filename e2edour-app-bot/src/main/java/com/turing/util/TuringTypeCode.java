package com.turing.util;

/**
 * 图灵返回类型code
 *
 * @author King
 * @version 2016/5/20
 */
public enum TuringTypeCode {

    type_100000("100000", "文本类"),
    type_200000("200000", "链接类"),
    type_302000("302000", "新闻类"),
    type_308000("308000", "菜谱类");

    private final String code;

    private final String desc;

    TuringTypeCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
