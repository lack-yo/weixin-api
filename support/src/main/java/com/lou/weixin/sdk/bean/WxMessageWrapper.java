package com.lou.weixin.sdk.bean;

import com.lou.weixin.sdk.bean.msg.WxMessage;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.*;

/**
 * 微信推送和被动回复时的消息数据结构(xml格式)
 *
 * @author loufeng
 * @date 2018/7/9 下午2:26.
 */
public class WxMessageWrapper implements Serializable {
    private static final long serialVersionUID = 513886656914906724L;

    /**
     * 推送消息对应的公众号appid
     */
    private String appId;
    /**
     * 开发者微信号
     */
    private String toUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private long createTime;
    /**
     * 消息
     */
    private WxMessage msg;

    public static WxMessageWrapper parseFromInput(InputStream inputStream) {
        try {
            String inputString = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                inputString += line;
            }
            br.close();
            return parseFromXml(inputString);
        } catch (IOException e) {
            return null;
        }
    }

    public static WxMessageWrapper parseFromXml(String xml) {
        WxMessageWrapper wrapper = new WxMessageWrapper();
        try {
            Document document = DocumentHelper.parseText(xml);
            Element element = document.getRootElement();
            wrapper.setToUserName(XmlParseUtil.getSubElementString(element, "toUserName"));
            wrapper.setFromUserName(XmlParseUtil.getSubElementString(element, "fromUserName"));
            wrapper.setCreateTime(Long.parseLong(XmlParseUtil.getSubElementString(element, "createTime")));
            wrapper.setMsg(WxMessage.parseWxMessage(element));
        } catch (Exception e) {
            return null;
        }
        return wrapper;
    }

    public String toXml() {
        Element rootElement = DocumentHelper.createElement("xml");
        rootElement.addText("\n");
        rootElement.addElement("ToUserName").addCDATA(toUserName);
        rootElement.addText("\n");
        rootElement.addElement("FromUserName").addCDATA(fromUserName);
        rootElement.addText("\n");
        rootElement.addElement("CreateTime").addText(String.valueOf(createTime));
        rootElement.addText("\n");
        rootElement.addElement("MsgType").addCDATA(msg.getMsgType().toString());
        rootElement.addText("\n");
        msg.toXmlNode(rootElement);
        return rootElement.asXML();
    }

    @SuppressWarnings("unchecked")
    public <T extends WxMessage> T getMsg(Class<T> clazz) {
        return (T) msg;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public WxMessage getMsg() {
        return msg;
    }

    public void setMsg(WxMessage msg) {
        this.msg = msg;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "WxMessageWrapper[toUserName=" + this.toUserName + ",appId=" + this.appId + ",fromUserName=" + this.fromUserName
                + ",createTime=" + this.createTime + ",Msg=" + (null == this.msg ? "" : this.msg.toString())
                + "]";
    }
}
