package com.lou.weixin.sdk.bean.result.weapp;


import com.lou.weixin.sdk.constants.DepthInfoType;

/**
 * 小程序访问深度item
 *
 * @author loufeng
 * @date 2017/11/30 上午10:09.
 */
public class DepthDistributionItem extends BaseDistributionItem {
    public void initDesc(int key) {
        DepthInfoType source = DepthInfoType.find(key);
        if (source != null) {
            super.setDesc(source.getDesc());
        }
    }
}
