package com.lou.weixin.sdk.bean.msg.event;

import com.lou.weixin.sdk.bean.msg.EventMessage;
import com.lou.weixin.sdk.constants.EventMsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;


/**
 * 点击菜单拉取消息时的事件推送
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class ClickEventMsg extends EventMessage {

    private static final long serialVersionUID = -1730974986593649566L;

    private String eventKey;// 事件KEY值，与自定义菜单接口中KEY值对应

    public ClickEventMsg() {
        this.setEventMsgType(EventMsgType.click);
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @Override
    public void fromXmlNode(Element element) {
        this.eventKey = XmlParseUtil.getSubElementString(element, "eventKey");
    }

    @Override
    public void toXmlNode(Element element) {
    }

    @Override
    public String toString() {
        return "ClickEventMsg[msgId=" + this.getMsgId() + ",msgType=" + (null == this.getMsgType() ? ""
                : this.getMsgType().toString()) + ",eventMsgType=" + (null == this.getEventMsgType() ? ""
                : this.getEventMsgType().toString()) + ",eventKey=" + this.eventKey + "]";
    }
}
