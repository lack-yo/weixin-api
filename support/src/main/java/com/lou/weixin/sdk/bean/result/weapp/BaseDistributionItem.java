package com.lou.weixin.sdk.bean.result.weapp;

/**
 * 浏览分布数据item
 *
 * @author loufeng
 * @date 2017/11/30 上午10:07.
 */
public class BaseDistributionItem {
    private int key;
    private int value;
    private String desc;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
