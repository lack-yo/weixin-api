package com.lou.weixin.sdk.bean.msg.event;

import com.lou.weixin.sdk.bean.msg.EventMessage;
import com.lou.weixin.sdk.constants.EventMsgType;
import org.dom4j.Element;

/**
 * 未知事件
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class DefaultEventMsg extends EventMessage {

    private static final long serialVersionUID = 500036177817910841L;

    public DefaultEventMsg() {
        this.setEventMsgType(EventMsgType.unknow);
    }

    @Override
    public void fromXmlNode(Element element) {

    }

    @Override
    public void toXmlNode(Element element) {

    }

}
