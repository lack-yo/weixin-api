package com.lou.weixin.sdk.bean.msg.event;

import com.lou.weixin.sdk.bean.msg.EventMessage;
import com.lou.weixin.sdk.constants.EventMsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

/**
 * 关注事件
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class SubscribeEventMsg extends EventMessage {

    private static final long serialVersionUID = 1L;

    private String eventKey;// 事件KEY值，qrscene_为前缀，后面为二维码的参数值
    private String ticket;// 二维码的ticket，可用来换取二维码图片

    public SubscribeEventMsg() {
        this.setEventMsgType(EventMsgType.subscribe);
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public void fromXmlNode(Element element) {
        this.eventKey = XmlParseUtil.getSubElementString(element, "eventKey");
        this.ticket = XmlParseUtil.getSubElementString(element, "ticket");
    }

    @Override
    public void toXmlNode(Element element) {
    }

    @Override
    public String toString() {
        return "SubscribeEventMsg[msgId=" + this.getMsgId() + ",msgType=" + (null == this.getMsgType() ? ""
                : this.getMsgType().toString()) + ",eventMsgType=" + (null == this.getEventMsgType() ? ""
                : this.getEventMsgType().toString()) + ",eventKey=" + this.eventKey + ",ticket="
                + this.ticket + "]";
    }
}
