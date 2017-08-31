package com.lou.weixin.model.param;

import java.io.Serializable;

/**
 * @author loufeng
 * @date 2017/8/31 下午5:02.
 */
public class CommitItemBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private String address;//小程序的页面
    private String tag;//小程序的标签
    private String first_class;//一级类目名称
    private String second_class;//二级类目
    private String first_id;//一级类目id
    private String second_id;//二级类目id
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

    public String getFirst_class() {
        return first_class;
    }

    public void setFirst_class(String first_class) {
        this.first_class = first_class;
    }

    public String getSecond_class() {
        return second_class;
    }

    public void setSecond_class(String second_class) {
        this.second_class = second_class;
    }

    public String getFirst_id() {
        return first_id;
    }

    public void setFirst_id(String first_id) {
        this.first_id = first_id;
    }

    public String getSecond_id() {
        return second_id;
    }

    public void setSecond_id(String second_id) {
        this.second_id = second_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
