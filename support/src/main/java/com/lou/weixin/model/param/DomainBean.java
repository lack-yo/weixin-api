package com.lou.weixin.model.param;

import java.io.Serializable;
import java.util.List;

/**
 * 开放平台修改小程序服务器地址（注：一个月最多修改5次）
 *
 * @author loufeng
 * @date 2017/8/31 下午3:59.
 */
public class DomainBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<String> requestdomain;// request合法域名
    private List<String> wsrequestdomain;// socket合法域名
    private List<String> uploaddomain;//uploadFile合法域名
    private List<String> downloaddomain;//downloadFile合法域名

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DomainBean{");
        sb.append("requestdomain=").append(requestdomain);
        sb.append(", wsrequestdomain=").append(wsrequestdomain);
        sb.append(", uploaddomain=").append(uploaddomain);
        sb.append(", downloaddomain=").append(downloaddomain);
        sb.append('}');
        return sb.toString();
    }
}
