package com.lou.weixin.sdk.bean.result.auth;

/**
 * 授权主体（公众号或者小程序）信息
 *
 * @author loufeng
 * @date 2018/1/22 上午10:54.
 */
public class AuthorizerInfo {
    /**
     * 名称
     */
    private String nickName;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 服务号类型
     */
    private int serviceTypeInfo;
    /**
     * 认证
     */
    private int verifyTypeInfo;
    /**
     * 原始ID
     */
    private String userName;
    /**
     * 微信号
     */
    private String alias;
    /**
     * 二维码
     */
    private String qrcodeUrl;
    /**
     * 主体名称
     */
    private String principalName;
    /**
     * 开通功能
     */
    private BusinessInfo businessInfo;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public BusinessInfo getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(BusinessInfo businessInfo) {
        this.businessInfo = businessInfo;
    }

    public int getServiceTypeInfo() {
        return serviceTypeInfo;
    }

    public void setServiceTypeInfo(int serviceTypeInfo) {
        this.serviceTypeInfo = serviceTypeInfo;
    }

    public int getVerifyTypeInfo() {
        return verifyTypeInfo;
    }

    public void setVerifyTypeInfo(int verifyTypeInfo) {
        this.verifyTypeInfo = verifyTypeInfo;
    }
}
