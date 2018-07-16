package com.lou.weixin.sdk.constants;

/**
 * 语言类型
 *
 * @author loufeng
 * @date 2018/1/4 下午4:12.
 */

public enum LanguageType {
    //简体
    zh_CN,
    //繁体
    zh_TW,
    //英语
    en;

    @Override
    public String toString() {
        String type = "";
        switch (this) {
            case zh_CN:
                type = "zh_CN";
                break;
            case zh_TW:
                type = "zh_TW";
                break;
            case en:
                type = "en";
                break;
            default:
                type = "zh_CN";
                break;
        }
        return type;
    }
}
