package com.lou.weixin.sdk.bean.result.weapp;

/**
 * 小程序代码模板
 *
 * @author loufeng
 * @date 2017/10/23 上午11:03.
 */
public class CodeTemplate implements Comparable {
    /**
     * 模板号
     */
    private int templateId;
    /**
     * 版本
     */
    private String userVersion;
    /**
     * 描述
     */
    private String userDesc;
    /**
     * 时间
     */
    private long createTime;

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
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

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof CodeTemplate) {
            CodeTemplate t2 = (CodeTemplate) o;
            return (int) (t2.getCreateTime() - this.getCreateTime());
        }
        return 0;
    }
}
