package com.lou.weixin.sdk.bean.result;

/**
 * 公众号图文数据item
 *
 * @author loufeng
 * @date 2017/7/28 下午3:25.
 */
public class WxArticleSummaryDetail {
    /**
     * 当前记录所属日期
     */
    private String refDate;
    /**
     * 图文编号
     */
    private String msgid;
    /**
     * 图文标题
     */
    private String title;
    /**
     * 图文页阅读人数
     */
    private int intPageReadUser;
    /**
     * 图文页阅读次数
     */
    private int intPageReadCount;
    /**
     * 原文页阅读人数
     */
    private int oriPageReadUser;
    /**
     * 原文页阅读次数
     */
    private int oriPageReadCount;
    /**
     * 分享人数
     */
    private int shareUser;
    /**
     * 分享次数
     */
    private int shareCount;
    /**
     * 收藏人数
     */
    private int addToFavUser;
    /**
     * 收藏次数
     */
    private int addToFavCount;

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIntPageReadUser() {
        return intPageReadUser;
    }

    public void setIntPageReadUser(int intPageReadUser) {
        this.intPageReadUser = intPageReadUser;
    }

    public int getIntPageReadCount() {
        return intPageReadCount;
    }

    public void setIntPageReadCount(int intPageReadCount) {
        this.intPageReadCount = intPageReadCount;
    }

    public int getOriPageReadUser() {
        return oriPageReadUser;
    }

    public void setOriPageReadUser(int oriPageReadUser) {
        this.oriPageReadUser = oriPageReadUser;
    }

    public int getOriPageReadCount() {
        return oriPageReadCount;
    }

    public void setOriPageReadCount(int oriPageReadCount) {
        this.oriPageReadCount = oriPageReadCount;
    }

    public int getShareUser() {
        return shareUser;
    }

    public void setShareUser(int shareUser) {
        this.shareUser = shareUser;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getAddToFavUser() {
        return addToFavUser;
    }

    public void setAddToFavUser(int addToFavUser) {
        this.addToFavUser = addToFavUser;
    }

    public int getAddToFavCount() {
        return addToFavCount;
    }

    public void setAddToFavCount(int addToFavCount) {
        this.addToFavCount = addToFavCount;
    }
}
