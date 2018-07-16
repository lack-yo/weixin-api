package com.lou.weixin.sdk.bean.msg.event;

import com.lou.weixin.sdk.bean.msg.EventMessage;
import com.lou.weixin.sdk.constants.EventMsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

/**
 * 地理位置事件
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class LocationEventMsg extends EventMessage {

    private static final long serialVersionUID = 5843142238883794635L;

    private String latitude;// 地理位置纬度
    private String longitude;// 地理位置经度
    private String precision;// 地理位置精度

    public LocationEventMsg() {
        this.setEventMsgType(EventMsgType.location);
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    @Override
    public void fromXmlNode(Element element) {
        try {
            this.latitude = XmlParseUtil.getSubElementString(element, "latitude");
            this.longitude = XmlParseUtil.getSubElementString(element, "longitude");
            this.precision = XmlParseUtil.getSubElementString(element, "precision");
        } catch (NumberFormatException ignored) {
        }
    }

    @Override
    public void toXmlNode(Element element) {
    }

    @Override
    public String toString() {
        return "LocationEventMsg[msgId=" + this.getMsgId() + ",msgType=" + (null == this.getMsgType() ? ""
                : this.getMsgType().toString()) + ",eventMsgType=" + (null == this.getEventMsgType() ? ""
                : this.getEventMsgType().toString()) + ",latitude=" + this.latitude
                + ",longitude=" + this.longitude + ",precision=" + this.precision + "]";
    }
}
