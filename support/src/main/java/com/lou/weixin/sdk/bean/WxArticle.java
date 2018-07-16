package com.lou.weixin.sdk.bean;

import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

import java.io.Serializable;

/**
 * 图文消息构造
 *
 * @author loufeng
 * @date 2018/7/9 下午2:26.
 */
public class WxArticle implements Serializable {

    private static final long serialVersionUID = -8041815639572118928L;

    /**
     * 图文消息标题
     */
    private String title;
    /**
     * 图文消息描述
     */
    private String description;
    /**
     * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    private String picUrl;
    /**
     * 点击图文消息跳转链接
     */
    private String url;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void fromXmlNode(Element element) {
        title = XmlParseUtil.getSubElementString(element, "title");
        description = XmlParseUtil.getSubElementString(element, "description");
        picUrl = XmlParseUtil.getSubElementString(element, "picUrl");
        url = XmlParseUtil.getSubElementString(element, "url");
    }

    public void toXmlNode(Element element) {
        Element e = element.addElement("item");
        e.addText("\n");
        e.addElement("Title").addCDATA(title);
        e.addText("\n");
        e.addElement("Description").addCDATA(description);
        e.addText("\n");
        e.addElement("PicUrl").addCDATA(picUrl);
        e.addText("\n");
        e.addElement("Url").addCDATA(url);
        e.addText("\n");
        element.addText("\n");
    }

    @Override
    public String toString() {
        return "ArticleItem[title=" + this.getTitle() + ",description=" + this.getDescription()
                + ",picUrl=" + this.getPicUrl() + ",url=" + this.getUrl() + "]";
    }
}
