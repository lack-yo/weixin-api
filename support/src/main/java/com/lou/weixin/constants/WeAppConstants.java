package com.lou.weixin.constants;

/**
 * @author loufeng
 * @date 2017/8/31 上午11:13.
 */
public class WeAppConstants {
    //获取小程序openid
    public static final String URL_GET_OPENID = "https://api.weixin.qq.com/sns/component/jscode2session?appid=APPID&js_code=JSCODE&grant_type=authorization_code&component_appid=COMPONENT_APPID&component_access_token=ACCESS_TOKEN";
    //添加小程序模板
    public static final String URL_ADD_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/wxopen/template/add?access_token=ACCESS_TOKEN";
    //获取小程序模板
    public static final String URL_GET_TEMPLATE_LIST = "https://api.weixin.qq.com/cgi-bin/wxopen/template/list?access_token=ACCESS_TOKEN";
    //发送模板消息
    public static final String URL_SEND_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";
    //修改服务器地址
    public static final String URL_MODIFY_DOMAIN = "https://api.weixin.qq.com/wxa/modify_domain?access_token=TOKEN";
    //绑定小程序体验者
    public static final String URL_BIND_TESTER = "https://api.weixin.qq.com/wxa/bind_tester?access_token=TOKEN";
    //解绑小程序体验者
    public static final String URL_UNBIND_TESTER = "https://api.weixin.qq.com/wxa/unbind_tester?access_token=TOKEN";
    //为授权的小程序帐号上传小程序代码
    public static final String URL_COMMIT_CODE = "https://api.weixin.qq.com/wxa/commit?access_token=TOKEN";
    //获取体验小程序的体验二维码
    public static final String URL_GET_QRCODE = "https://api.weixin.qq.com/wxa/get_qrcode?access_token=TOKEN";
    //获取授权小程序帐号的可选类目
    public static final String URL_GET_CATEGORY = "https://api.weixin.qq.com/wxa/get_category?access_token=TOKEN";
    //获取小程序的第三方提交代码的页面配置
    public static final String URL_GET_PAGE = "https://api.weixin.qq.com/wxa/get_page?access_token=TOKEN";
    //将第三方提交的代码包提交审核
    public static final String URL_COMMIT_AUDIT = "https://api.weixin.qq.com/wxa/submit_audit?access_token=TOKEN";
    //查询某个指定版本的审核状态
    public static final String URL_GET_AUDITSTATUS = "https://api.weixin.qq.com/wxa/get_auditstatus?access_token=TOKEN";
    //查询最新一次提交的审核状态
    public static final String URL_GET_LATEST_AUDITSTATUS = "https://api.weixin.qq.com/wxa/get_latest_auditstatus?access_token=TOKEN";
    //发布已通过审核的小程序
    public static final String URL_RELEASE = "https://api.weixin.qq.com/wxa/release?access_token=TOKEN";
    //修改小程序线上代码的可见状态
    public static final String URL_CHANGE_VISITSTATUS = "https://api.weixin.qq.com/wxa/change_visitstatus?access_token=TOKEN";


}
