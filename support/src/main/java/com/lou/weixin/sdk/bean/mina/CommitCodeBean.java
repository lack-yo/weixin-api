package com.lou.weixin.sdk.bean.mina;

import java.io.Serializable;

/**
 * @author loufeng
 * @date 2017/9/1 下午4:03.
 */
public class CommitCodeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private int templatedI;
    private String extJson;
    private String userVersion;
    private String userDesc;

    public int getTemplatedI() {
        return templatedI;
    }

    public void setTemplatedI(int templatedI) {
        this.templatedI = templatedI;
    }

    public String getExtJson() {
        return extJson;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    public String getUserVersion() {
        return userVersion;
    }

    public void setUserVersion(String userVersion) {
        this.userVersion = userVersion;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    @Override
    public String toString() {
        return "CommitCodeBean{" +
                "templatedI=" + templatedI +
                ", extJson='" + extJson + '\'' +
                ", userVersion='" + userVersion + '\'' +
                ", userDesc='" + userDesc + '\'' +
                '}';
    }
}
