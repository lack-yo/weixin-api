package com.lou.weixin.sdk.bean.result.weapp;

/**
 * 小程序每日访问数据
 *
 * @author loufeng
 * @date 2017/11/28 上午11:34.
 */
public class DailyVisit {
    /**
     * 日期
     */
    private String refDate;
    /**
     * 打开次数
     */
    private int sessionCnt;
    /**
     * 访问次数
     */
    private int visitPv;
    /**
     * 访问人数
     */
    private int visitUv;
    /**
     * 新用户数
     */
    private int visitUvNew;
    /**
     * 人均停留时长 (浮点型，单位：秒)
     */
    private String stayTimeUv;
    /**
     * 次均停留时长 (浮点型，单位：秒)
     */
    private String stayTimeSession;
    /**
     * 平均访问深度 (浮点型)
     */
    private String visitDepth;

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

    public int getSessionCnt() {
        return sessionCnt;
    }

    public void setSessionCnt(int sessionCnt) {
        this.sessionCnt = sessionCnt;
    }

    public int getVisitPv() {
        return visitPv;
    }

    public void setVisitPv(int visitPv) {
        this.visitPv = visitPv;
    }

    public int getVisitUv() {
        return visitUv;
    }

    public void setVisitUv(int visitUv) {
        this.visitUv = visitUv;
    }

    public int getVisitUvNew() {
        return visitUvNew;
    }

    public void setVisitUvNew(int visitUvNew) {
        this.visitUvNew = visitUvNew;
    }

    public String getStayTimeUv() {
        return stayTimeUv;
    }

    public void setStayTimeUv(String stayTimeUv) {
        this.stayTimeUv = stayTimeUv;
    }

    public String getStayTimeSession() {
        return stayTimeSession;
    }

    public void setStayTimeSession(String stayTimeSession) {
        this.stayTimeSession = stayTimeSession;
    }

    public String getVisitDepth() {
        return visitDepth;
    }

    public void setVisitDepth(String visitDepth) {
        this.visitDepth = visitDepth;
    }
}

