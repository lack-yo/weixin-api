package com.lou.weixin.sdk.bean.msg.event;

import com.lou.weixin.sdk.bean.msg.EventMessage;
import com.lou.weixin.sdk.constants.EventMsgType;
import org.dom4j.Element;

/**
 * 取消关注事件
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class UnSubscribeEventMsg extends EventMessage {

    private static final long serialVersionUID = 8695058031027353709L;

    public UnSubscribeEventMsg() {
        this.setEventMsgType(EventMsgType.unsubscribe);
    }

    @Override
    public void fromXmlNode(Element element) {

    }

    @Override
    public void toXmlNode(Element element) {

    }

    @Override
    public String toString() {
        return "UnSubscribeEventMsg[msgId=" + this.getMsgId() + ",msgType="
                + (null == this.getMsgType() ? "" : this.getMsgType().toString()) + ",eventMsgType="
                + (null == this.getEventMsgType() ? "" : this.getEventMsgType().toString()) + "]";
    }
}
