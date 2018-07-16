package com.lou.weixin.sdk.bean.msg;

import com.lou.weixin.sdk.constants.MsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

import java.io.Serializable;

/**
 * 微信消息
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public abstract class WxMessage implements Serializable {

    private static final long serialVersionUID = -9125389051166774767L;
    /**
     * 消息id，64位整型
     */
    private long msgId;
    /**
     * 消息类型
     */
    private MsgType msgType;

    public static WxMessage parseWxMessage(Element element) {
        WxMessage msg;
        String typeStr = XmlParseUtil.getSubElementString(element, "msgType");
        MsgType msgType = MsgType.parseFromStr(typeStr);
        switch (msgType) {
            case text:
                msg = new TextMessage();
                break;
            case event:
                msg = EventMessage.parseEventMessage(element);
                break;
            case voice:
                msg = new VoiceMessage();
                break;
            case video:
                msg = new VideoMessage();
                break;
            case image:
                msg = new ImageMessage();
                break;
            case link:
                msg = new LinkMessage();
                break;
            default:
                msg = new TextMessage();
                break;
        }
        msg.setMsgType(msgType);
        String tmp = XmlParseUtil.getSubElementString(element, "msgId");
        if (tmp != null) {
            long msgId = Long.parseLong(tmp);
            msg.setMsgId(msgId);
        }
        msg.fromXmlNode(element);
        return msg;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }

    abstract public void fromXmlNode(Element element);

    abstract public void toXmlNode(Element element);
}
