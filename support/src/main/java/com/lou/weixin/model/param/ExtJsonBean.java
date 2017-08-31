package com.lou.weixin.model.param;

import java.util.Map;

/**
 * 小程序代码第三方自定义配置
 *
 * @author loufeng
 * @date 2017/8/31 下午4:39.
 */
public class ExtJsonBean {
    private String extAppid;//授权方Appid，可填入商户AppID，以区分不同商户
    private Map<String,String> ext;//扩展参数

    public String getExtAppid() {
        return extAppid;
    }

    public void setExtAppid(String extAppid) {
        this.extAppid = extAppid;
    }

    public Map<String, String> getExt() {
        return ext;
    }

    public void setExt(Map<String, String> ext) {
        this.ext = ext;
    }
}
