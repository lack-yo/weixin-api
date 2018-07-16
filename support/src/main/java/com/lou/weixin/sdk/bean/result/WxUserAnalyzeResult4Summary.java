package com.lou.weixin.sdk.bean.result;

import java.util.List;

/**
 * 增减用户数据分析
 *
 * @author loufeng
 * @date 2018/7/9 下午2:11.
 */
public class WxUserAnalyzeResult4Summary {
    /**
     * 数据列表
     */
    private List<WxUserSummaryResult> list;

    public List<WxUserSummaryResult> getList() {
        return list;
    }

    public void setList(List<WxUserSummaryResult> list) {
        this.list = list;
    }
}
