package com.lou.weixin.sdk.bean.msg;

import com.lou.weixin.sdk.bean.msg.event.*;
import com.lou.weixin.sdk.constants.EventMsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

/**
 * event事件
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public abstract class EventMessage extends WxMessage {

    private static final long serialVersionUID = -8120511679174679001L;

    private EventMsgType eventMsgType;

    public static EventMessage parseEventMessage(Element element) {
        String typeStr = XmlParseUtil.getSubElementString(element, "event");
        EventMsgType eventType = EventMsgType.parseFromStr(typeStr);
        EventMessage eventMsg;
        switch (eventType) {
            case location:
                eventMsg = new LocationEventMsg();
                break;
            case subscribe:
                eventMsg = new SubscribeEventMsg();
                break;
            case unsubscribe:
                eventMsg = new UnSubscribeEventMsg();
                break;
            case scan:
                eventMsg = new ScanEventMsg();
                break;
            case click:
                eventMsg = new ClickEventMsg();
                break;
            case view:
                eventMsg = new ViewEventMsg();
                break;
            case masssendjobfinish:
                eventMsg = new MassSendJobFinishEventMsg();
                break;
            case templatesendjobfinish:
                eventMsg = new TemplateSendJobFinishEventMsg();
                break;
            case weapp_audit_success:
                eventMsg = new MinaAuditSuccessEventMsg();
                break;
            case weapp_audit_fail:
                eventMsg = new MinaAuditFailEventMsg();
                break;
            default:
                eventMsg = new DefaultEventMsg();
                break;
        }
        return eventMsg;
    }

    public EventMsgType getEventMsgType() {
        return eventMsgType;
    }

    public void setEventMsgType(EventMsgType eventMsgType) {
        this.eventMsgType = eventMsgType;
    }

    @Override
    abstract public void fromXmlNode(Element element);

    @Override
    abstract public void toXmlNode(Element element);

}