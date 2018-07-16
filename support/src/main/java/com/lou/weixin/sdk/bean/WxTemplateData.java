package com.lou.weixin.sdk.bean;

/**
 * 发送模板消息数据
 *
 * @author loufeng
 * @date 2018/7/9 下午2:26.
 */
public class WxTemplateData {
    /**
     * key
     */
    private String name;
    /**
     * 内容
     */
    private String value;
    /**
     * 颜色
     */
    private String color;

    public WxTemplateData() {

    }

    public WxTemplateData(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public WxTemplateData(String name, String value, String color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WxTemplateData{");
        sb.append("name='").append(name).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
