package com.lou.weixin.sdk.support.mp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.lou.weixin.sdk.bean.WxCustomMessage;
import com.lou.weixin.sdk.bean.WxMassGroupMessage;
import com.lou.weixin.sdk.bean.WxMassOpenIdsMessage;
import com.lou.weixin.sdk.bean.WxTemplateMessage;
import com.lou.weixin.sdk.bean.result.WxMassStatusResult;
import com.lou.weixin.sdk.bean.result.WxMessageSendResult;
import com.lou.weixin.sdk.bean.result.WxTemplateIndustry;
import com.lou.weixin.sdk.bean.result.WxTemplateListResult;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.GsonConvertUtil;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

import java.io.StringReader;
import java.util.List;

/**
 * 消息管理
 *
 * @author loufeng
 * @date 2018/7/5 上午10:21.
 */
@SuppressWarnings("unused")
public class MpMsgSupport {
    /**
     * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
     **/
    private static final String MESSAGE_MASS_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
    /**
     * 根据分组进行群发【订阅号与服务号认证后均可用】
     **/
    private static final String MESSAGE_MASS_SENDALL_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
    /**
     * 发送模板消息
     **/
    private static final String TEMPLATE_MESSAGE_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    /**
     * 客服消息发送接口
     **/
    private static final String MESSAGE_CUSTOM_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
    /**
     * 获得模板ID
     **/
    private static final String TEMPLATE_ADD_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
    /**
     * 设置所属行业
     **/
    private static final String TEMPLATE_SET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
    /**
     * 获取模板列表
     **/
    private static final String TEMPLATE_GET_ALL_PRIVATE_URL = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
    /**
     * 获取设置的行业信息
     **/
    private static final String TEMPLATE_GET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
    /**
     * 查询群发消息发送状态【订阅号与服务号认证后均可用】
     **/
    private static final String MESSAGE_MASS_GET_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN";


    /**
     * 向指定粉丝发送消息
     *
     * @param token   公众号token
     * @param message 消息
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxMessageSendResult messageMassSendWithOpenIds(
            String token,
            WxMassOpenIdsMessage message
    ) throws WxErrorException {
        String url = MESSAGE_MASS_SEND_URL.replace("ACCESS_TOKEN", token);
        String result = WxHttpUtil.post(url, message.toJson());
        return WxGsonBuilder.create().fromJson(result, WxMessageSendResult.class);
    }

    /**
     * 向指定分组或全部粉丝发送消息
     *
     * @param token   公众号token
     * @param message 消息
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxMessageSendResult messageMassSendWithGroup(
            String token, WxMassGroupMessage message)
            throws WxErrorException {
        String url = MESSAGE_MASS_SENDALL_URL.replace("ACCESS_TOKEN", token);
        String result = WxHttpUtil.post(url, message.toJson());
        return WxGsonBuilder.create().fromJson(result, WxMessageSendResult.class);

    }

    /**
     * 图文群发
     *
     * @param token      公众号token
     * @param is2All     是否群发
     * @param tagId      分组标签
     * @param mediaId    素材id
     * @param canReprint 是否允许转载
     * @return 群发结果
     * @throws WxErrorException error
     */
    public static WxMessageSendResult graphicMassSendAll(String token, boolean is2All, String tagId, String mediaId, boolean canReprint) throws WxErrorException {
        String url = MESSAGE_MASS_SENDALL_URL.replace("ACCESS_TOKEN", token);
        JSONObject json = new JSONObject();

        JSONObject filter = new JSONObject();
        filter.put("is_to_all", is2All);
        filter.put("tag_id", tagId);
        json.put("filter", filter);

        JSONObject mpNews = new JSONObject();
        mpNews.put("media_id", mediaId);
        json.put("mpnews", mpNews);
        json.put("msgtype", "mpnews");
        //开放公众号原创转载权限设置
        String reprint = canReprint ? "1" : "0";
        json.put("send_ignore_reprint", reprint);
        String result = WxHttpUtil.post(url, json);

        return WxGsonBuilder.create().fromJson(result, WxMessageSendResult.class);
    }

    /**
     * 发送模板消息
     *
     * @param token   公众号token
     * @param message 模板消息
     * @return 结果
     * @throws WxErrorException error
     */
    public static String tempalteMessageSend(String token, WxTemplateMessage message) throws WxErrorException {
        String url = TEMPLATE_MESSAGE_SEND_URL.replace("ACCESS_TOKEN", token);
        return WxHttpUtil.post(url, message.toJson());
    }

    /**
     * 发送客服消息
     *
     * @param appId   公众号
     * @param token   公众号token
     * @param message 消息
     * @return 结果
     * @throws WxErrorException error
     */
    public static String customMessageSend(String appId, String token, WxCustomMessage message) throws WxErrorException {
        String url = MESSAGE_CUSTOM_SEND_URL.replace("ACCESS_TOKEN", token);
        return WxHttpUtil.post(url, message.toJson());
    }

    /**
     * 获取模板id
     *
     * @param token           公众号token
     * @param templateIdShort 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     * @return 结果
     * @throws WxErrorException error
     */
    public static String getTempalteId(String token, String templateIdShort) throws WxErrorException {
        String url = TEMPLATE_ADD_URL.replace("ACCESS_TOKEN", token);
        JsonObject param = new JsonObject();
        param.addProperty("template_id_short", templateIdShort);
        String responseContent = WxHttpUtil.post(url, param);
        JsonElement tmpJsonElement = Streams.parse(new JsonReader(new StringReader(responseContent)));
        return GsonConvertUtil.getAsString(tmpJsonElement.getAsJsonObject().get("template_id"));
    }

    /**
     * 查询群发消息发送状态
     *
     * @param token 公众号token
     * @param msgId 消息id
     * @return 发送状态
     * @throws WxErrorException 微信异常
     */
    public static WxMassStatusResult getMassMessageStatus(String token, String msgId) throws WxErrorException {
        String url = MESSAGE_MASS_GET_URL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("msg_id", msgId);
        String result = WxHttpUtil.post(url, json);
        JSONObject jsonResult = JSON.parseObject(result);
        WxMassStatusResult massStatusResult = new WxMassStatusResult();
        massStatusResult.setMsgId(msgId);
        String status = jsonResult.getString("msg_status");
        massStatusResult.setMsgStatus(status);
        return massStatusResult;
    }

    /**
     * 设置公众号所属行业（用作模板消息）
     *
     * @param token       公众号token
     * @param industryId1 一级从属行业
     * @param industryId2 二级从属行业
     * @throws WxErrorException 微信异常
     */
    public static void setAppIndustry(String token, int industryId1, int industryId2) throws WxErrorException {
        String url = TEMPLATE_SET_INDUSTRY_URL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("industry_id1", industryId1);
        json.addProperty("industry_id2", industryId2);
        WxHttpUtil.post(url, json);
    }

    /**
     * 获取已添加至帐号下所有模板列表
     *
     * @param token 公众号token
     * @return 模板列表
     * @throws WxErrorException 微信异常
     */
    public static List<WxTemplateListResult.WxTemplate> getTemplateList(String token) throws WxErrorException {
        String url = TEMPLATE_GET_ALL_PRIVATE_URL.replace("ACCESS_TOKEN", token);
        String response = WxHttpUtil.get(url);
        WxTemplateListResult listResult = WxGsonBuilder.create().fromJson(response, WxTemplateListResult.class);
        if (null != listResult) {
            return listResult.getTemplateList();
        }
        return null;
    }

    /**
     * 获取公众号所属行业信息
     *
     * @param token 公众号token
     * @return 行业
     */
    public static WxTemplateIndustry getIndustry(String token) throws WxErrorException {
        String url = TEMPLATE_GET_INDUSTRY_URL.replace("ACCESS_TOKEN", token);

        String result = WxHttpUtil.get(url);
        return WxGsonBuilder.create().fromJson(result, WxTemplateIndustry.class);
    }

}
