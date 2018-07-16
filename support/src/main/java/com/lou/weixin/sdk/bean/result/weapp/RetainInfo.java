package com.lou.weixin.sdk.bean.result.weapp;

/**
 * 小程序留存数据
 *
 * @author loufeng
 * @date 2017/11/28 上午11:36.
 */
public class RetainInfo {
    /**
     * 日期
     */
    private String refDate;
    /**
     * 新用户uv留存
     */
    private String visitUvNew;
    /**
     * 活跃用户uv留存
     */
    private String visitUv;
    /**
     * 小程序id
     */
    private String appId;
    /**
     * 名称
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

    public String getVisitUvNew() {
        return visitUvNew;
    }

    public void setVisitUvNew(String visitUvNew) {
        this.visitUvNew = visitUvNew;
    }

    public String getVisitUv() {
        return visitUv;
    }

    public void setVisitUv(String visitUv) {
        this.visitUv = visitUv;
    }
}
