package com.lou.weixin.sdk.bean;


import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

/**
 * 用户组构造
 *
 * @author loufeng
 * @date 2018/7/9 下午2:26.
 */
public class WxGroup {
    private long id = -1;
    private String name;
    private long count;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public static WxGroup fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxGroup.class);
    }

    public String toJson() {
        return WxGsonBuilder.create().toJson(this);
    }

    @Override
    public String toString() {
        return "WxGroup [id=" + id + ", name=" + name + ", count=" + count + "]";
    }
}
