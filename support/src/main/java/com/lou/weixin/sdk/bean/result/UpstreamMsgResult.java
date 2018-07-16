package com.lou.weixin.sdk.bean.result;

import java.util.List;

/**
 * 公众号消息数据
 *
 * @author loufeng
 * @date 2017/7/27 下午5:01.
 */
public class UpstreamMsgResult {
    private List<UpstreamMsgDetail> list;

    public List<UpstreamMsgDetail> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgDetail> list) {
        this.list = list;
    }

}
