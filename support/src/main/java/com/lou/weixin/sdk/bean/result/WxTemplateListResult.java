package com.lou.weixin.sdk.bean.result;

import java.util.List;

/**
 * 公众号模板消息列表
 *
 * @author loufeng
 * @date 2018/7/9 下午2:14.
 */
public class WxTemplateListResult {
    /**
     * 模板列表
     */
    private List<WxTemplate> templateList;

    public static class WxTemplate {
        /**
         * 模板ID
         */
        private String templateId;
        /**
         * 模板标题
         */
        private String title;
        /**
         * 模板所属行业的一级行业
         */
        private String primaryIndustry;
        /**
         * 模板所属行业的二级行业
         */
        private String deputyIndustry;
        /**
         * 模板内容
         */
        private String content;
        /**
         * 模板示例
         */
        private String example;

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrimaryIndustry() {
            return primaryIndustry;
        }

        public void setPrimaryIndustry(String primaryIndustry) {
            this.primaryIndustry = primaryIndustry;
        }

        public String getDeputyIndustry() {
            return deputyIndustry;
        }

        public void setDeputyIndustry(String deputyIndustry) {
            this.deputyIndustry = deputyIndustry;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }
    }

    public List<WxTemplate> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<WxTemplate> templateList) {
        this.templateList = templateList;
    }

    @Override
    public String toString() {
        return "WxTemplateListResult{" +
                "templateList=" + templateList +
                '}';
    }
}
