package com.lou.weixin.sdk.bean.mina;

import java.io.Serializable;
import java.util.List;

/**
 * 开放平台修改小程序服务器地址（注：一个月最多修改5次）
 *
 * @author loufeng
 * @date 2017/8/31 下午3:59.
 */
public class DomainBean implements Serializable {
    public static final String GET = "get";
    public static final String SET = "set";
    public static final String ADD = "add";
    public static final String DEL = "delete";

    private static final long serialVersionUID = 1L;
    private String action;
    /**
     * request合法域名
     */
    private List<String> requestdomain;
    /**
     * socket合法域名
     */
    private List<String> wsrequestdomain;
    /**
     * uploadFile合法域名
     */
    private List<String> uploaddomain;
    /**
     * downloadFile合法域名
     */
    private List<String> downloaddomain;

    public List<String> getRequestdomain() {
        return requestdomain;
    }

    public void setRequestdomain(List<String> requestdomain) {
        this.requestdomain = requestdomain;
    }

    public List<String> getWsrequestdomain() {
        return wsrequestdomain;
    }

    public void setWsrequestdomain(List<String> wsrequestdomain) {
        this.wsrequestdomain = wsrequestdomain;
    }

    public List<String> getUploaddomain() {
        return uploaddomain;
    }

    public void setUploaddomain(List<String> uploaddomain) {
        this.uploaddomain = uploaddomain;
    }

    public List<String> getDownloaddomain() {
        return downloaddomain;
    }

    public void setDownloaddomain(List<String> downloaddomain) {
        this.downloaddomain = downloaddomain;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "DomainBean{" + "action='" + action + '\'' +
                ", requestdomain=" + requestdomain +
                ", wsrequestdomain=" + wsrequestdomain +
                ", uploaddomain=" + uploaddomain +
                ", downloaddomain=" + downloaddomain +
                '}';
    }
}
