package com.lou.weixin.sdk.bean.result.weapp;

import java.util.List;

/**
 * 小程序访问页面数据
 *
 * @author loufeng
 * @date 2017/11/28 上午11:36.
 */
public class VisitPageResult {
    /**
     * 日期
     */
    private String refDate;
    /**
     * item
     */
    private List<PageItem> list;
    /**
     * 小程序id
     */
    private String appId;
    /**
     * 小程序名
     */
    private String name;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public List<PageItem> getList() {
        return list;
    }

    public void setList(List<PageItem> list) {
        this.list = list;
    }
}
