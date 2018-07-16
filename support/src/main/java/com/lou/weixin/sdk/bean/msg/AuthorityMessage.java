package com.lou.weixin.sdk.bean.msg;

import com.lou.weixin.sdk.bean.WxMessageWrapper;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class AuthorityMessage extends WxMessageWrapper {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static String TYPE_TIKET = "component_verify_ticket";
    public static String MSGTYPE_EVENT = "event";
    public static String MSGTYPE_TEXT = "text";
    public static String FIXTEXT_CONTENT = "TESTCOMPONENT_MSG_TYPE_TEXT";
    public static String QUERY_AUTH_CODE = "QUERY_AUTH_CODE";


    private String appId;
    private long createTime;
    private String infoType;
    private String componentVerifyTicket;
    /**
     * 公众号appid
     */
    private String authorizerAppid;
    /**
     * 授权码（code）
     */
    private String authorizationCode;

    private Integer authorizationCodeExpiredTime;


    @Override
    public String getAppId() {
        return appId;
    }

    @Override
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public long getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getComponentVerifyTicket() {
        return componentVerifyTicket;
    }

    public void setComponentVerifyTicket(String componentVerifyTicket) {
        this.componentVerifyTicket = componentVerifyTicket;
    }

    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public Integer getAuthorizationCodeExpiredTime() {
        return authorizationCodeExpiredTime;
    }

    public void setAuthorizationCodeExpiredTime(Integer authorizationCodeExpiredTime) {
        this.authorizationCodeExpiredTime = authorizationCodeExpiredTime;
    }

    public static AuthorityMessage parseToXml(String xml) {
        AuthorityMessage amVO = null;

        try {
            Document document = DocumentHelper.parseText(xml);
            Element element = document.getRootElement();

            amVO = new AuthorityMessage();
            amVO.setAppId(XmlParseUtil.getSubElementString(element, "AppId"));
            if (XmlParseUtil.getSubElementString(element, "CreateTime") != null) {
                amVO.setCreateTime(Long.parseLong(XmlParseUtil.getSubElementString(element, "CreateTime")));
            }
            amVO.setInfoType(XmlParseUtil.getSubElementString(element, "InfoType"));
            amVO.setComponentVerifyTicket(XmlParseUtil.getSubElementString(element, "ComponentVerifyTicket"));
            amVO.setAuthorizationCode(XmlParseUtil.getSubElementString(element, "AuthorizationCode"));
            amVO.setAuthorizerAppid(XmlParseUtil.getSubElementString(element, "AuthorizerAppid"));
            if (XmlParseUtil.getSubElementString(element, "AuthorizationCodeExpiredTime") != null) {
                amVO.setAuthorizationCodeExpiredTime(Integer.parseInt(XmlParseUtil.getSubElementString(element, "AuthorizationCodeExpiredTime")));
            }
        } catch (DocumentException e) {
            return null;
        }

        return amVO;
    }

    @Override
    public String toString() {
        return "AuthorityMessageVO{" +
                "appId='" + appId + '\'' +
                ", createTime=" + createTime +
                ", infoType='" + infoType + '\'' +
                ", componentVerifyTicket='" + componentVerifyTicket + '\'' +
                ", authorizerAppid='" + authorizerAppid + '\'' +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", authorizationCodeExpiredTime=" + authorizationCodeExpiredTime +
                '}';
    }
}
