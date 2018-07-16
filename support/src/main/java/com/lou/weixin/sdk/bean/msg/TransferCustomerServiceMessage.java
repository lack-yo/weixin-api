package com.lou.weixin.sdk.bean.msg;

import com.lou.weixin.sdk.constants.MsgType;
import org.dom4j.Element;

/**
 * 多客服消息
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class TransferCustomerServiceMessage extends WxMessage {
    private static final long serialVersionUID = -8799459694057652624L;

    public TransferCustomerServiceMessage() {
        this.setMsgType(MsgType.transfer_customer_service);
    }

    @Override
    public void fromXmlNode(Element element) {
    }

    @Override
    public void toXmlNode(Element element) {
    }

}
