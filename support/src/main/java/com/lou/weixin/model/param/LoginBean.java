package com.lou.weixin.model.param;

import java.io.Serializable;

/**
 * 小程序wx.login获取openid
 *
 * @author loufeng
 * @date 2017/8/31 下午4:09.
 */
public class LoginBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private String openid;//用户唯一标识的openid
    private String session_key;//会话密钥

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginBean{");
        sb.append("openid='").append(openid).append('\'');
        sb.append(", session_key='").append(session_key).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
