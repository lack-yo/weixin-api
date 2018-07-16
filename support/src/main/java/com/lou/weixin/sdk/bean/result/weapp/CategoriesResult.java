package com.lou.weixin.sdk.bean.result.weapp;


import com.lou.weixin.sdk.bean.mina.MinaCategory;
import com.lou.weixin.sdk.bean.result.Result;

import java.util.List;

/**
 * 小程序类目
 *
 * @author loufeng
 * @date 2017/10/23 下午3:06.
 */
public class CategoriesResult extends Result {
    private List<MinaCategory> categoryList;

    public List<MinaCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<MinaCategory> categoryList) {
        this.categoryList = categoryList;
    }
}
