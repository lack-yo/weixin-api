package com.lou.weixin.service;


import com.lou.weixin.model.param.CommitItemBean;
import com.lou.weixin.model.param.DomainBean;
import com.lou.weixin.model.param.LoginBean;
import com.lou.weixin.model.param.TemplateMsgBean;

/**
 * 小程序相关的接口访问
 *
 * @author loufeng
 * @date 2017/8/31 上午10:10.
 */
public interface WeAppService {
    /**
     * 微信登录获取openid
     *
     * @param appId 小程序appid
     * @param code  登录code
     * @return 获取的openid
     */
    LoginBean getOpenId(String appId, String code);
    //添加模板消息
    void addTemplateMsg(String appid);
    //获取已有的模板消息列表
    void getTemplateMsgList(String appid);
    //发送模板消息
    void sendTemplateMsg(String appid, TemplateMsgBean msg);

    /**
     * 获取域名配置
     *
     * @param appId 小程序
     * @return 域名配置
     */
    DomainBean getDomain(String appId);

    /**
     * 设置域名（覆盖）
     *
     * @param appId   小程序
     * @param domains 域名
     */
    void setDomain(String appId, DomainBean domains);

    /**
     * 设置域名（添加）
     *
     * @param appId   小程序
     * @param domains 域名
     */
    void addDomain(String appId, DomainBean domains);

    //绑定微信用户为小程序体验者
    void bindTester(String appid, String testid);


    //解除绑定小程序的体验者
    void unbindTester(String appid, String testid);

    //为授权的小程序帐号上传小程序代码
    void uploadCode(String appid, String templateID, String version, String desc);

    //获取体验小程序的体验二维码,下载文件io，转外链souche
    void getQrcode(String appid);

    //获取授权小程序帐号的可选类目
    void getCategory(String appid);

    //将第三方提交的代码包提交审核
    void submitAudit(String appid, CommitItemBean bean);

    //查询最新一次提交的审核状态
    void getLatestCommitStatus(String appid);

    //发布已通过审核的小程序
    void releaseApp(String appid);

    //修改小程序线上代码的可见状态
    void updateVisable(String appid);
}
