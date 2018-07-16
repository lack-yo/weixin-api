package com.lou.weixin.sdk.bean.msg.event;

import com.lou.weixin.sdk.bean.msg.EventMessage;
import com.lou.weixin.sdk.constants.EventMsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

/**
 * 模板消息推送结果
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class TemplateSendJobFinishEventMsg extends EventMessage {

    private static final long serialVersionUID = 4172031111545145961L;

    private String status;

    public TemplateSendJobFinishEventMsg() {
        this.setEventMsgType(EventMsgType.templatesendjobfinish);
    }

    @Override
    public void fromXmlNode(Element element) {
        status = XmlParseUtil.getSubElementString(element, "status");
    }

    @Override
    public void toXmlNode(Element element) {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TemplateSendJobFinishEventMsg[msgId=" + this.getMsgId() + ",msgType="
                + (null == this.getMsgType() ? "" : this.getMsgType().toString()) + ",eventMsgType="
                + (null == this.getEventMsgType() ? "" : this.getEventMsgType().toString()) + ",status="
                + this.status + "]";
    }
}
