package com.lou.weixin.sdk.bean.msg.event;

import com.lou.weixin.sdk.bean.msg.EventMessage;
import com.lou.weixin.sdk.constants.EventMsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

/**
 * 小程序审核成功推送
 *
 * @author loufeng
 * @date 2017/10/20 下午2:45.
 */
public class MinaAuditSuccessEventMsg extends EventMessage {
    private String succTime;

    public MinaAuditSuccessEventMsg() {
        this.setEventMsgType(EventMsgType.weapp_audit_success);
    }

    public String getSuccTime() {
        return succTime;
    }

    public void setSuccTime(String succTime) {
        this.succTime = succTime;
    }

    @Override
    public void fromXmlNode(Element element) {
        succTime = XmlParseUtil.getSubElementString(element, "SuccTime");
    }

    @Override
    public void toXmlNode(Element element) {

    }
}
