package com.lou.weixin.sdk.bean.result.weapp;


import com.lou.weixin.sdk.bean.result.Result;

import java.util.List;

/**
 * 小程序代码模板列表
 *
 * @author loufeng
 * @date 2017/10/23 上午11:02.
 */
public class CodeTemplateResult extends Result {
    /**
     * 模板列表
     */
    private List<CodeTemplate> templateList;

    public List<CodeTemplate> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<CodeTemplate> templateList) {
        this.templateList = templateList;
    }
}
