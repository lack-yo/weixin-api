package com.lou.weixin.sdk.bean.result;

import java.util.List;

/**
 * 公众号关联小程序result
 *
 * @author loufeng
 * @date 2018/1/23 上午9:58.
 */
public class LinkAppResult {
    private List<LinkApp> items;

    public List<LinkApp> getItems() {
        return items;
    }

    public void setItems(List<LinkApp> items) {
        this.items = items;
    }
}
