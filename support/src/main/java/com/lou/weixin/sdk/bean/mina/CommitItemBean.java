package com.lou.weixin.sdk.bean.mina;

import java.io.Serializable;

/**
 * @author loufeng
 * @date 2017/8/31 下午5:02.
 */
public class CommitItemBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String address;//小程序的页面
    private String tag;//小程序的标签
    private String firstClass;//一级类目名称
    private String secondClass;//二级类目
    private int firstId;//一级类目id
    private int secondId;//二级类目id
    private String title;//小程序页面的标题

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CommitItemBean{" +
                "address='" + address + '\'' +
                ", tag='" + tag + '\'' +
                ", firstClass='" + firstClass + '\'' +
                ", secondClass='" + secondClass + '\'' +
                ", firstId=" + firstId +
                ", secondId=" + secondId +
                ", title='" + title + '\'' +
                '}';
    }
}
