package com.lou.weixin.sdk.bean.msg;

import com.lou.weixin.sdk.constants.MsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

/**
 * 链接消息
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class LinkMessage extends WxMessage {

    private static final long serialVersionUID = -1963735619570573641L;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息链接
     */
    private String url;

    /**
     * 消息描述
     */
    private String description;

    public LinkMessage() {
        this.setMsgType(MsgType.link);
    }

    @Override
    public void fromXmlNode(Element element) {
        this.title = XmlParseUtil.getSubElementString(element, "title");
        this.url = XmlParseUtil.getSubElementString(element, "url");
        this.description = XmlParseUtil.getSubElementString(element, "description");
    }

    @Override
    public void toXmlNode(Element element) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "LinkMessage[msgId=" + this.getMsgId() + ",msgType="
                + (null == this.getMsgType() ? "" : this.getMsgType().toString()) + ",description="
                + this.description + ",url=" + this.url + ",title=" + this.title + "]";
    }
}
