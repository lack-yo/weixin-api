package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.auth.AuthInfoResult;
import com.lou.weixin.sdk.bean.result.auth.AuthorizerInfo;
import com.lou.weixin.sdk.bean.result.auth.BusinessInfo;
import com.lou.weixin.sdk.bean.result.auth.MiniProgramInfo;
import com.lou.weixin.sdk.constants.FuncInfoType;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 授权信息Gson适配
 *
 * @author loufeng
 * @date 2018/1/22 上午10:43.
 */
public class AuthorizerInfoAdapter implements JsonDeserializer<AuthInfoResult> {

    @Override
    public AuthInfoResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject o = json.getAsJsonObject();

        AuthInfoResult ai = new AuthInfoResult();
        JsonObject funcInfo = o.get("authorization_info").getAsJsonObject();
        JsonArray array = funcInfo.getAsJsonArray("func_info");
        List<FuncInfoType> funcInfoTypeList = Lists.newArrayList();
        for (JsonElement e : array) {
            int id = e.getAsJsonObject().get("funcscope_category").getAsJsonObject().get("id").getAsInt();
            FuncInfoType type = FuncInfoType.find(id);
            funcInfoTypeList.add(type);
        }
        //授权权限
        ai.setFuncInfo(funcInfoTypeList);
        ai.setAppId(funcInfo.get("authorizer_appid").getAsString());
        AuthorizerInfo authorizerInfo = new AuthorizerInfo();
        JsonObject authorizerInfoObject = o.get("authorizer_info").getAsJsonObject();
        authorizerInfo.setAlias(authorizerInfoObject.get("alias").getAsString());
        authorizerInfo.setNickName(authorizerInfoObject.get("nick_name").getAsString());
        BusinessInfo businessInfo = new BusinessInfo();
        JsonObject businessInfoObject = authorizerInfoObject.get("business_info").getAsJsonObject();
        businessInfo.setOpenCard(businessInfoObject.get("open_card").getAsInt());
        businessInfo.setOpenPay(businessInfoObject.get("open_pay").getAsInt());
        businessInfo.setOpenScan(businessInfoObject.get("open_scan").getAsInt());
        businessInfo.setOpenShake(businessInfoObject.get("open_shake").getAsInt());
        businessInfo.setOpenStore(businessInfoObject.get("open_store").getAsInt());
        authorizerInfo.setBusinessInfo(businessInfo);
        if (authorizerInfoObject.get("head_img") != null) {
            authorizerInfo.setHeadImg(authorizerInfoObject.get("head_img").getAsString());
        }
        authorizerInfo.setPrincipalName(authorizerInfoObject.get("principal_name").getAsString());
        authorizerInfo.setQrcodeUrl(authorizerInfoObject.get("qrcode_url").getAsString());
        authorizerInfo.setUserName(authorizerInfoObject.get("user_name").getAsString());
        authorizerInfo.setServiceTypeInfo(authorizerInfoObject.get("service_type_info").getAsJsonObject().get("id").getAsInt());
        authorizerInfo.setVerifyTypeInfo(authorizerInfoObject.get("verify_type_info").getAsJsonObject().get("id").getAsInt());
        //公共信息
        ai.setAuthorizerInfo(authorizerInfo);
        MiniProgramInfo miniProgramInfo = new MiniProgramInfo();
        //小程序特有信息
        if (authorizerInfoObject.get("MiniProgramInfo") != null) {
            JsonObject miniProgramInfoObject = authorizerInfoObject.get("MiniProgramInfo").getAsJsonObject();
            miniProgramInfo.setVisitStatus(miniProgramInfoObject.get("visit_status").getAsInt());
            ai.setMiniProgramInfo(miniProgramInfo);
        }

        return ai;
    }
}
