package com.lou.weixin.sdk.bean.result;

/**
 * 行业设置
 *
 * @author loufeng
 * @date 2018/7/9 下午2:11.
 */
public class WxTemplateIndustry {
    private static final String ITKJ = "IT科技";
    private static final String ITRJFU = "IT软件与服务";

    /**
     * 帐号设置的主营行业
     */
    private Industry primaryIndustry;
    /**
     * 帐号设置的副营行业
     */
    private Industry secondaryIndustry;

    public static class Industry {
        private String firstClass;// 一级分类
        private String secondClass;// 耳机分类

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
    }

    public Industry getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(Industry primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Industry getSecondaryIndustry() {
        return secondaryIndustry;
    }

    public void setSecondaryIndustry(Industry secondaryIndustry) {
        this.secondaryIndustry = secondaryIndustry;
    }

    @Override
    public String toString() {
        return "WxTemplateIndustry{" +
                "primaryIndustry=" + primaryIndustry +
                ", secondaryIndustry=" + secondaryIndustry +
                '}';
    }

    /**
     * 是否是IT科技-IT软件与服务行业
     *
     * @return
     */
    public boolean isITIndustry() {
        if (null != primaryIndustry) {
            if (ITKJ.equals(primaryIndustry.getFirstClass()) && ITRJFU.equals(primaryIndustry.getSecondClass())) {
                return true;
            }
        }

        if (null != secondaryIndustry) {
            if (ITKJ.equals(secondaryIndustry.getFirstClass()) && ITRJFU.equals(secondaryIndustry.getSecondClass())) {
                return true;
            }
        }

        return false;
    }
}
