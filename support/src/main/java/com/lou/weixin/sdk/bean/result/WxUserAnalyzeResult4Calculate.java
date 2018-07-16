package com.lou.weixin.sdk.bean.result;

import java.util.List;

/**
 * 用户数据分析
 *
 * @author loufeng
 * @date 2018/7/9 下午2:11.
 */
public class WxUserAnalyzeResult4Calculate {
    private List<WxUserCumulateResult> list;

    public List<WxUserCumulateResult> getList() {
        return list;
    }

    public void setList(List<WxUserCumulateResult> list) {
        this.list = list;
    }
}
