package com.lou.weixin.model.param;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author loufeng
 * @date 2017/8/31 下午10:19.
 */
public class TemplateMsgBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private String touser;//接收者（用户）的 openid
    private String template_id;//所需下发的模板消息的id
    private String page;//点击模板卡片后的跳转页面
    private String form_id;//表单
    private Map<String,KeyWord> data;//模板内容
    private String emphasis_keyword;//模板需要放大的关键词,示例："keyword1.DATA"

    public class KeyWord{
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

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public Map<String, KeyWord> getData() {
        return data;
    }

    public void setData(Map<String, KeyWord> data) {
        this.data = data;
    }

    public String getEmphasis_keyword() {
        return emphasis_keyword;
    }

    public void setEmphasis_keyword(String emphasis_keyword) {
        this.emphasis_keyword = emphasis_keyword;
    }
}
