package com.lou.weixin.sdk.bean.result;

import java.util.List;

/**
 * 公众号图文数据
 *
 * @author loufeng
 * @date 2017/7/27 下午4:54.
 */
public class WxArticleSummaryResult {
    private List<WxArticleSummaryDetail> list;

    public List<WxArticleSummaryDetail> getList() {
        return list;
    }

    public void setList(List<WxArticleSummaryDetail> list) {
        this.list = list;
    }

}
