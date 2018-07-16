package com.lou.weixin.sdk.support.mina;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lou.weixin.sdk.bean.mina.CommitCodeBean;
import com.lou.weixin.sdk.bean.mina.CommitItemBean;
import com.lou.weixin.sdk.bean.mina.DomainBean;
import com.lou.weixin.sdk.bean.mina.MinaCategory;
import com.lou.weixin.sdk.bean.result.weapp.CategoriesResult;
import com.lou.weixin.sdk.bean.result.weapp.CodeTemplateResult;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 小程序代码维护API集成
 *
 * @author loufeng
 * @date 2018/7/5 上午10:15.
 */
@SuppressWarnings("unused")
public class MinaCodeSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinaCodeSupport.class);
    /**
     * 修改服务器地址
     */
    private static final String URL_MODIFY_DOMAIN = "https://api.weixin.qq.com/wxa/modify_domain?access_token=ACCESS_TOKEN";
    /**
     * 修改业务域名
     */
    private static final String URL_MODIFY_WEB_DOMAIN = "https://api.weixin.qq.com/wxa/setwebviewdomain?access_token=ACCESS_TOKEN";
    /**
     * 绑定小程序体验者
     */
    private static final String URL_BIND_TESTER = "https://api.weixin.qq.com/wxa/bind_tester?access_token=ACCESS_TOKEN";
    /**
     * 解绑小程序体验者
     */
    private static final String URL_UNBIND_TESTER = "https://api.weixin.qq.com/wxa/unbind_tester?access_token=ACCESS_TOKEN";
    /**
     * 为授权的小程序帐号上传小程序代码
     */
    private static final String URL_COMMIT_CODE = "https://api.weixin.qq.com/wxa/commit?access_token=ACCESS_TOKEN";
    /**
     * 获取体验小程序的体验二维码
     */
    private static final String URL_GET_QRCODE = "https://api.weixin.qq.com/wxa/get_qrcode?access_token=ACCESS_TOKEN";
    /**
     * 获取授权小程序帐号的可选类目
     */
    private static final String URL_GET_CATEGORY = "https://api.weixin.qq.com/wxa/get_category?access_token=ACCESS_TOKEN";
    /**
     * 获取小程序的第三方提交代码的页面配置
     */
    private static final String URL_GET_PAGE = "https://api.weixin.qq.com/wxa/get_page?access_token=ACCESS_TOKEN";
    /**
     * 将第三方提交的代码包提交审核
     */
    private static final String URL_COMMIT_AUDIT = "https://api.weixin.qq.com/wxa/submit_audit?access_token=ACCESS_TOKEN";
    /**
     * 查询最新一次提交的审核状态
     */
    private static final String URL_GET_LATEST_AUDITSTATUS = "https://api.weixin.qq.com/wxa/get_latest_auditstatus?access_token=ACCESS_TOKEN";
    /**
     * 查询某个指定版本的审核状态
     */
    private static final String URL_GET_AUDITSTATUS = "https://api.weixin.qq.com/wxa/get_auditstatus?access_token=ACCESS_TOKEN";
    /**
     * 发布已通过审核的小程序
     */
    private static final String URL_RELEASE = "https://api.weixin.qq.com/wxa/release?access_token=ACCESS_TOKEN";
    /**
     * 修改小程序线上代码的可见状态
     */
    private static final String URL_CHANGE_VISITSTATUS = "https://api.weixin.qq.com/wxa/change_visitstatus?access_token=ACCESS_TOKEN";
    /**
     * 获取代码模版库中的所有小程序代码模版
     */
    private static final String URL_TEMPLATE_GET = "https://api.weixin.qq.com/wxa/gettemplatelist?access_token=ACCESS_TOKEN";
    /**
     * 撤回审核
     */
    private static final String URL_AUDIT_REVERT = "https://api.weixin.qq.com/wxa/undocodeaudit?access_token=ACCESS_TOKEN";
    /**
     * 设置可访问状态，发布后默认可访问，open为可见
     */
    private static final String VISIT_OPEN = "open";
    /**
     * 设置可访问状态，发布后默认可访问，close为不可见
     */
    private static final String VISIT_CLOSE = "close";


    /**
     * 获取域名配置
     *
     * @param token 小程序token
     * @return 域名配置
     * @throws WxErrorException 微信错误
     */
    public static DomainBean getDomain(String token) throws WxErrorException {
        String url = URL_MODIFY_DOMAIN.replace("ACCESS_TOKEN", token);
        Map<String, Object> params = Maps.newHashMap();
        params.put("action", "get");
        String result = WxHttpUtil.post(url, params);
        return WxGsonBuilder.INSTANCE.create().fromJson(result, DomainBean.class);
    }

    /**
     * 设置域名（覆盖）
     *
     * @param token   小程序token
     * @param domains 域名
     * @throws WxErrorException 微信错误
     */
    public static void setDomain(String token, DomainBean domains) throws WxErrorException {
        String url = URL_MODIFY_DOMAIN.replace("ACCESS_TOKEN", token);
        domains.setAction(DomainBean.SET);
        WxHttpUtil.post(url, domains);
    }


    /**
     * 设置域名（添加）
     *
     * @param token   小程序token
     * @param domains 域名
     * @throws WxErrorException 微信错误
     */
    public static void addDomain(String token, DomainBean domains) throws WxErrorException {
        String url = URL_MODIFY_DOMAIN.replace("ACCESS_TOKEN", token);
        domains.setAction(DomainBean.ADD);
        WxHttpUtil.post(url, domains);
    }

    /**
     * 设置域名（覆盖）
     *
     * @param token   小程序token
     * @param domains 域名
     * @throws WxErrorException 微信错误
     */
    public static void setWebDomain(String token, List<String> domains) throws WxErrorException {
        String url = URL_MODIFY_WEB_DOMAIN.replace("ACCESS_TOKEN", token);
        Map<String, Object> params = Maps.newHashMap();
        params.put("action", DomainBean.SET);
        params.put("webviewdomain", domains);
        WxHttpUtil.post(url, params);
    }

    /**
     * 设置域名（添加）
     *
     * @param token   小程序token
     * @param domains 域名
     * @throws WxErrorException 微信错误
     */
    public static void addWebDomain(String token, List<String> domains) throws WxErrorException {
        String url = URL_MODIFY_WEB_DOMAIN.replace("ACCESS_TOKEN", token);
        Map<String, Object> params = Maps.newHashMap();
        params.put("action", DomainBean.ADD);
        params.put("webviewdomain", domains);
        WxHttpUtil.post(url, params);
    }

    /**
     * 绑定微信用户为小程序体验者
     *
     * @param token  小程序token
     * @param testId 体验者微信号
     * @throws WxErrorException 微信错误
     */
    public static void bindTester(String token, String testId) throws WxErrorException {
        String url = URL_BIND_TESTER.replace("ACCESS_TOKEN", token);
        Map<String, Object> params = Maps.newHashMap();
        params.put("wechatid", testId);
        WxHttpUtil.post(url, params);
    }


    /**
     * 解除绑定小程序的体验者
     *
     * @param token  小程序token
     * @param testid 体验者微信号
     * @throws WxErrorException 微信错误
     */
    public static void unbindTester(String token, String testid) throws WxErrorException {
        String url = URL_UNBIND_TESTER.replace("ACCESS_TOKEN", token);
        Map<String, Object> params = Maps.newHashMap();
        params.put("wechatid", testid);
        WxHttpUtil.post(url, params);
    }

    /**
     * 为授权的小程序帐号上传小程序代码
     *
     * @param token 小程序token
     * @param bean  上传配置
     * @throws WxErrorException 微信错误
     */
    public static void uploadCode(String token, CommitCodeBean bean) throws WxErrorException {
        String url = URL_COMMIT_CODE.replace("ACCESS_TOKEN", token);
        WxHttpUtil.post(url, bean);
    }

    /**
     * 获取体验小程序的体验二维码,下载文件io
     *
     * @param token 小程序token
     * @return 访问地址
     * @throws WxErrorException 微信错误
     */
    public static InputStream getQrcode(String token) throws WxErrorException {
        String url = URL_GET_QRCODE.replace("ACCESS_TOKEN", token);
        return WxHttpUtil.getDownload(url);
    }

    /**
     * 获取授权小程序帐号的可选类目
     *
     * @param token 小程序token
     * @return 可选类目
     * @throws WxErrorException 微信错误
     */
    public static List<MinaCategory> getCategory(String token) throws WxErrorException {
        String url = URL_GET_CATEGORY.replace("ACCESS_TOKEN", token);
        String result = WxHttpUtil.get(url);
        CategoriesResult categoriesResult = WxGsonBuilder.INSTANCE.create().fromJson(result, CategoriesResult.class);
        return categoriesResult.getCategoryList();
    }

    /**
     * 获取小程序页面配置
     *
     * @param token 小程序token
     * @throws WxErrorException 微信错误
     */
    public static void getPageList(String token) throws WxErrorException {
        String url = URL_GET_PAGE.replace("ACCESS_TOKEN", token);
        String result = WxHttpUtil.get(url);
        LOGGER.info("获取授权小程序的页面配置,result:" + result);
    }

    /**
     * 将第三方提交的代码包提交审核
     *
     * @param token 小程序token
     * @param bean  审核配置
     * @throws WxErrorException 微信错误
     */
    public static void submitAudit(String token, CommitItemBean bean) throws WxErrorException {
        String url = URL_COMMIT_AUDIT.replace("ACCESS_TOKEN", token);
        List<CommitItemBean> list = Lists.newArrayList();
        list.add(bean);
        Map<String, Object> param = Maps.newHashMap();
        param.put("item_list", list);
        String result = WxHttpUtil.post(url, param);
        LOGGER.info("提交审核：" + result);
    }

    /**
     * 查询某个指定版本的审核状态
     *
     * @param token   小程序token
     * @param auditid 审核id
     * @throws WxErrorException 微信错误
     */
    public static void getAuditStatus(String token, String auditid) throws WxErrorException {
        String url = URL_GET_AUDITSTATUS.replace("ACCESS_TOKEN", token);
        Map<String, Object> param = Maps.newHashMap();
        param.put("auditid", auditid);
        String result = WxHttpUtil.post(url, param);
        LOGGER.info("版本{}的查询结果是{}", auditid, result);
    }

    /**
     * 查询最新一次提交的审核状态
     *
     * @param token 小程序token
     * @return 审核状态
     * @throws WxErrorException 微信错误
     */
    public static String getLatestCommitStatus(String token) throws WxErrorException {
        String url = URL_GET_LATEST_AUDITSTATUS.replace("ACCESS_TOKEN", token);
        String result = WxHttpUtil.get(url);
        JSONObject json = JSON.parseObject(result);
        return json.getString("status");
    }

    /**
     * 发布已通过审核的小程序
     *
     * @param token 小程序token
     * @throws WxErrorException 微信错误
     */
    public static void releaseApp(String token) throws WxErrorException {
        String url = URL_RELEASE.replace("ACCESS_TOKEN", token);
        WxHttpUtil.post(url, Maps.newHashMap());
    }

    /**
     * 关闭小程序线上代码的可见状态
     *
     * @param token 小程序token
     * @throws WxErrorException 微信错误
     */
    public static void closeVisable(String token) throws WxErrorException {
        String url = URL_CHANGE_VISITSTATUS.replace("ACCESS_TOKEN", token);
        Map<String, String> param = Maps.newHashMap();
        param.put("action", VISIT_CLOSE);
        WxHttpUtil.post(url, param);
    }

    /**
     * 开放小程序线上代码的可见状态
     *
     * @param token 小程序token
     * @throws WxErrorException 微信错误
     */
    public static void openVisable(String token) throws WxErrorException {
        String url = URL_CHANGE_VISITSTATUS.replace("ACCESS_TOKEN", token);
        Map<String, String> param = Maps.newHashMap();
        param.put("action", VISIT_OPEN);
        WxHttpUtil.post(url, param);
    }

    /**
     * 获取小程序代码模板库
     *
     * @param token 小程序token
     * @return 小程序代码模板库
     * @throws WxErrorException 微信错误
     */
    public static CodeTemplateResult getTemplateList(String token) throws WxErrorException {
        String url = URL_TEMPLATE_GET.replace("ACCESS_TOKEN", token);
        String result = WxHttpUtil.get(url);
        return WxGsonBuilder.INSTANCE.create().fromJson(result, CodeTemplateResult.class);
    }

    /**
     * 清理小程序域名配置
     *
     * @param appId   小程序id
     * @param token   小程序token
     * @param domains 清理的域名
     * @throws WxErrorException 异常
     */
    public static void clearDomain(String appId, String token, DomainBean domains) throws WxErrorException {
        String url = URL_MODIFY_DOMAIN.replace("ACCESS_TOKEN", token);
        domains.setAction(DomainBean.DEL);
        WxHttpUtil.post(url, domains);
    }

    /**
     * 版本审核撤回
     *
     * @param appId 小程序id
     * @param token 小程序token
     * @throws WxErrorException 微信错误
     */
    public static void commitRevert(String appId, String token) throws WxErrorException {
        String url = URL_AUDIT_REVERT.replace("ACCESS_TOKEN", token);
        WxHttpUtil.get(url);
    }
}
