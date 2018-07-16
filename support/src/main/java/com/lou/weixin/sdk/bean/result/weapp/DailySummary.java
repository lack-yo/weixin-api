package com.lou.weixin.sdk.bean.result.weapp;

/**
 * 小程序每日概览数据
 *
 * @author loufeng
 * @date 2017/11/28 上午11:32.
 */
public class DailySummary {
    /**
     * 日期
     */
    private String refDate;
    /**
     * 累计用户数
     */
    private int visitTotal;
    /**
     * 分享pv
     */
    private int sharePv;
    /**
     * 分享uv
     */
    private int shareUv;
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

    public int getVisitTotal() {
        return visitTotal;
    }

    public void setVisitTotal(int visitTotal) {
        this.visitTotal = visitTotal;
    }

    public int getSharePv() {
        return sharePv;
    }

    public void setSharePv(int sharePv) {
        this.sharePv = sharePv;
    }

    public int getShareUv() {
        return shareUv;
    }

    public void setShareUv(int shareUv) {
        this.shareUv = shareUv;
    }

}
