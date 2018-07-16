package com.lou.weixin.sdk.bean.mina;

import java.util.Map;

/**
 * @author loufeng
 * @date 2017/8/31 下午10:19.
 */
public class TemplateMsg {
    /**
     * 接收者（用户）的 openid
     */
    private String toUser;
    /**
     * 所需下发的模板消息的id
     */
    private String templateId;
    /**
     * 点击模板卡片后的跳转页面
     */
    private String page;
    /**
     * 表单
     */
    private String formId;
    /**
     * 模板内容
     */
    private Map<String, Object> data;
    /**
     * 模板需要放大的关键词,示例："keyword1.DATA"
     */
    private String emphasisKeyword;

    public static class KeyWord {
        public KeyWord() {
        }

        public KeyWord(String value, String color) {
            this.value = value;
            this.color = color;
        }

        private String value;
        private String color;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getEmphasisKeyword() {
        return emphasisKeyword;
    }

    public void setEmphasisKeyword(String emphasisKeyword) {
        this.emphasisKeyword = emphasisKeyword;
    }

    @Override
    public String toString() {
        return "TemplateMsgBO{" +
                "toUser='" + toUser + '\'' +
                ", templateId='" + templateId + '\'' +
                ", page='" + page + '\'' +
                ", formId='" + formId + '\'' +
                ", data=" + data +
                ", emphasisKeyword='" + emphasisKeyword + '\'' +
                '}';
    }
}
