package com.lou.weixin.sdk.bean.result.weapp;

/**
 * 小程序用户画像
 *
 * @author loufeng
 * @date 2017/11/28 上午11:36.
 */
public class UserPortrait {
    /**
     * 日期
     */
    private String refDate;
    /**
     * 新访问用户画像
     */
    private UserPortraitItem visitUvNew;
    /**
     * 活跃用户画像
     */
    private UserPortraitItem visitUv;
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

    public UserPortraitItem getVisitUvNew() {
        return visitUvNew;
    }

    public void setVisitUvNew(UserPortraitItem visitUvNew) {
        this.visitUvNew = visitUvNew;
    }

    public UserPortraitItem getVisitUv() {
        return visitUv;
    }

    public void setVisitUv(UserPortraitItem visitUv) {
        this.visitUv = visitUv;
    }
}
