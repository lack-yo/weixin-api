package com.lou.weixin.sdk.bean.mina;

/**
 * @author loufeng
 * @date 2017/10/23 下午2:46.
 */
public class MinaCategory {
    /**
     * 小程序一级类目id
     */
    private int firstId;
    /**
     * 小程序一级类目
     */
    private String firstClass;
    /**
     * 小程序二级类目id
     */
    private int secondId;
    /**
     * 小程序二级类目
     */
    private String secondClass;

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }

    @Override
    public String toString() {
        return "MinaCategoryVo{" +
                "firstId=" + firstId +
                ", firstClass='" + firstClass + '\'' +
                ", secondId=" + secondId +
                ", secondClass='" + secondClass + '\'' +
                '}';
    }
}
