package com.lou.weixin.sdk.bean.result.weapp;

/**
 * 小程序页面访问item
 *
 * @author loufeng
 * @date 2017/11/30 下午3:46.
 */
public class PageItem {
    /**
     * 页面路径
     */
    private String pagePath;
    /**
     * 访问次数
     */
    private int pageVisitPv;
    /**
     * 访问人数
     */
    private int pageVisitUv;
    /**
     * 次均停留时长
     */
    private String pageStaytimePv;
    /**
     * 进入页次数
     */
    private int entryPagePv;
    /**
     * 退出页次数
     */
    private int exiPagePv;
    /**
     * 转发次数
     */
    private int pageSharePv;
    /**
     * 转发人数
     */
    private int pageShareUv;

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public int getPageVisitPv() {
        return pageVisitPv;
    }

    public void setPageVisitPv(int pageVisitPv) {
        this.pageVisitPv = pageVisitPv;
    }

    public int getPageVisitUv() {
        return pageVisitUv;
    }

    public void setPageVisitUv(int pageVisitUv) {
        this.pageVisitUv = pageVisitUv;
    }

    public String getPageStaytimePv() {
        return pageStaytimePv;
    }

    public void setPageStaytimePv(String pageStaytimePv) {
        this.pageStaytimePv = pageStaytimePv;
    }

    public int getEntryPagePv() {
        return entryPagePv;
    }

    public void setEntryPagePv(int entryPagePv) {
        this.entryPagePv = entryPagePv;
    }

    public int getExiPagePv() {
        return exiPagePv;
    }

    public void setExiPagePv(int exiPagePv) {
        this.exiPagePv = exiPagePv;
    }

    public int getPageSharePv() {
        return pageSharePv;
    }

    public void setPageSharePv(int pageSharePv) {
        this.pageSharePv = pageSharePv;
    }

    public int getPageShareUv() {
        return pageShareUv;
    }

    public void setPageShareUv(int pageShareUv) {
        this.pageShareUv = pageShareUv;
    }
}
