package com.lou.weixin.sdk.bean.result.weapp;

/**
 * 用户画像item
 *
 * @author loufeng
 * @date 2017/11/30 下午4:02.
 */
public class UserPortraitItem {
    /**
     * 省份，如北京、广东等
     */
    private String province;
    /**
     * 城市，如北京、广州等
     */
    private String city;
    /**
     * 性别，包括男、女、未知
     */
    private String genders;
    /**
     * 终端类型，包括iPhone, android,其他
     */
    private String platfomrs;
    /**
     * 机型，如苹果iPhone6, OPPO R9等
     */
    private String devices;
    /**
     * 年龄，包括17岁以下、18-24岁等区间
     */
    private String ages;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGenders() {
        return genders;
    }

    public void setGenders(String genders) {
        this.genders = genders;
    }

    public String getPlatfomrs() {
        return platfomrs;
    }

    public void setPlatfomrs(String platfomrs) {
        this.platfomrs = platfomrs;
    }

    public String getDevices() {
        return devices;
    }

    public void setDevices(String devices) {
        this.devices = devices;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }
}
