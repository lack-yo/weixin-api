package com.lou.weixin.sdk.bean.msg.event;

import com.lou.weixin.sdk.bean.msg.EventMessage;
import com.lou.weixin.sdk.constants.EventMsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

/**
 * 小程序失败推送消息
 *
 * @author loufeng
 * @date 2017/10/20 下午2:48.
 */
public class MinaAuditFailEventMsg extends EventMessage {
    private static final long serialVersionUID = -2286208693302270874L;
    private String reason;

    public MinaAuditFailEventMsg() {
        this.setEventMsgType(EventMsgType.weapp_audit_fail);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public void fromXmlNode(Element element) {
        reason = XmlParseUtil.getSubElementString(element, "Reason");
    }

    @Override
    public void toXmlNode(Element element) {

    }
}
