package com.lou.weixin.sdk.bean.msg;

import com.lou.weixin.sdk.constants.MsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

/**
 * 文本消息
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class TextMessage extends WxMessage {

    private static final long serialVersionUID = 8061611258082260997L;

    /**
     * 文本消息内容
     */
    private String content;

    public TextMessage() {
        this.setMsgType(MsgType.text);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void fromXmlNode(Element element) {
        this.content = XmlParseUtil.getSubElementString(element, "content");
    }

    @Override
    public void toXmlNode(Element element) {
        element.addElement("Content").addText(content);
        element.addText("\n");
    }

    @Override
    public String toString() {
        return "TextMessage[msgId=" + this.getMsgId() + ",msgType=" + this.getMsgType().toString() + ",content="
                + content + "]";
    }
}
