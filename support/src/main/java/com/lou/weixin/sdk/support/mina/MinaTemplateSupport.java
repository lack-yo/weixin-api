package com.lou.weixin.sdk.support.mina;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.lou.weixin.sdk.bean.mina.TemplateMsg;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 小程序模板消息API集成
 *
 * @author loufeng
 * @date 2018/7/5 上午10:14.
 */
@SuppressWarnings("unused")
public class MinaTemplateSupport {
    /**
     * 获取模板库某个模板标题下关键词库
     */
    private static final String URL_GET_TEMPLATE_LIBRARY = "https://api.weixin.qq.com/cgi-bin/wxopen/template/library/get?access_token=ACCESS_TOKEN";
    /**
     * 添加小程序模板
     */
    private static final String URL_ADD_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/wxopen/template/add?access_token=ACCESS_TOKEN";
    /**
     * 获取小程序模板
     */
    private static final String URL_GET_TEMPLATE_LIST = "https://api.weixin.qq.com/cgi-bin/wxopen/template/list?access_token=ACCESS_TOKEN";
    /**
     * 发送模板消息
     */
    private static final String URL_SEND_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";
    /**
     * 删除帐号下的某个模板
     */
    private static final String URL_DEL_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/wxopen/template/del?access_token=ACCESS_TOKEN";

    private static final Logger LOGGER = LoggerFactory.getLogger(MinaTemplateSupport.class);


    /**
     * 获取模板库某个模板标题下关键词库
     *
     * @param token 小程序token
     * @param id    模板编号
     * @throws WxErrorException 微信错误
     */
    public static void getTemplateLibrary(String token, String id) throws WxErrorException {
        String url = URL_GET_TEMPLATE_LIBRARY.replace("ACCESS_TOKEN", token);
        Map<String, String> params = Maps.newHashMap();
        params.put("id", id);
        String result = WxHttpUtil.post(url, params);
        LOGGER.info("模板id：{}，内容：{}", id, result);
    }

    /**
     * 添加模板消息到小程序,获得templateId
     *
     * @param token       小程序token
     * @param id          模板编号
     * @param keywordList 关键词
     * @return 获得templateId
     * @throws WxErrorException 微信错误
     */
    public static String addTemplateMsg(String token, String id, int[] keywordList) throws WxErrorException {
        Map<String, Object> params = Maps.newHashMap();
        params.put("id", id);
        params.put("keyword_id_list", keywordList);
        String url = URL_ADD_TEMPLATE.replace("ACCESS_TOKEN", token);
        String result = WxHttpUtil.post(url, params);
        JSONObject json = JSON.parseObject(result);
        return json.getString("template_id");
    }

    /**
     * 删除已有的模板消息
     *
     * @param token      小程序token
     * @param templateId 小程序模板列表的模板消息id
     * @throws WxErrorException 微信异常
     */
    public static void deleteTemplate(String token, String templateId) throws WxErrorException {
        Map<String, Object> params = Maps.newHashMap();
        params.put("template_id", templateId);
        String url = URL_DEL_TEMPLATE.replace("ACCESS_TOKEN", token);
        WxHttpUtil.post(url, params);
    }


    /**
     * 发送模板消息
     *
     * @param token 小程序token
     * @param msg   模板消息
     * @throws WxErrorException 微信错误
     */
    public static void sendTemplateMsg(String token, TemplateMsg msg) throws WxErrorException {
        String url = URL_SEND_TEMPLATE.replace("ACCESS_TOKEN", token);
        Map<String, Object> param = Maps.newHashMap();
        param.put("touser", msg.getToUser());
        param.put("template_id", msg.getTemplateId());
        param.put("page", msg.getPage());
        param.put("form_id", msg.getFormId());
        param.put("data", msg.getData());
        param.put("emphasis_keyword", msg.getEmphasisKeyword());
        WxHttpUtil.post(url, param);
    }
}
