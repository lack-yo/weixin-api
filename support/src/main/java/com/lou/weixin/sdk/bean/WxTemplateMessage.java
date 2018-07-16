package com.lou.weixin.sdk.bean;


import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送模板消息参数
 *
 * @author loufeng
 * @date 2018/7/9 下午2:26.
 */
public class WxTemplateMessage {
    /**
     * 接收人
     */
    private String toUser;
    /**
     * 模板id
     */
    private String templateId;
    /**
     * 链接
     */
    private String url;
    /**
     * 颜色
     */
    private String topColor;
    private List<WxTemplateData> datas = new ArrayList<WxTemplateData>();

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<WxTemplateData> getDatas() {
        return datas;
    }

    public void setDatas(List<WxTemplateData> datas) {
        this.datas = datas;
    }

    public String getTopColor() {
        return topColor;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    public String toJson() {
        return WxGsonBuilder.INSTANCE.create().toJson(this);
    }
}
