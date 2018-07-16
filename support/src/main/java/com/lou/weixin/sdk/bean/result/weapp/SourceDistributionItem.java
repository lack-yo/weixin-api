package com.lou.weixin.sdk.bean.result.weapp;


import com.lou.weixin.sdk.constants.DistributionSource;

/**
 * 小程序来源数据
 *
 * @author loufeng
 * @date 2017/11/30 上午10:09.
 */
public class SourceDistributionItem extends BaseDistributionItem {
    void initDesc(int key) {
        DistributionSource source = DistributionSource.find(key);
        if (source != null) {
            super.setDesc(source.getDesc());
        }
    }
}
