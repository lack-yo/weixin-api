package com.lou.weixin.sdk.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lou.weixin.sdk.bean.*;
import com.lou.weixin.sdk.bean.mina.DomainBean;
import com.lou.weixin.sdk.bean.result.*;
import com.lou.weixin.sdk.bean.result.auth.AuthInfoResult;
import com.lou.weixin.sdk.bean.result.weapp.*;

/**
 * Gson适配器容器
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxGsonBuilder {

    public static final GsonBuilder INSTANCE = new GsonBuilder();

    static {
        INSTANCE.disableHtmlEscaping();
        INSTANCE.registerTypeAdapter(WxError.class, new WxErrorAdapter());
        INSTANCE.registerTypeAdapter(WxToken.class, new WxTokenAdapter());
        INSTANCE.registerTypeAdapter(WxMediaUploadResult.class, new WxMediaUploadResultAdapter());
        INSTANCE.registerTypeAdapter(WxUser.class, new WxUserAdapter());
        INSTANCE.registerTypeAdapter(WxQrCodeTicket.class, new WxQrCodeTicketAdapter());
        INSTANCE.registerTypeAdapter(WxMessageSendResult.class, new WxMassSendResultAdapter());
        INSTANCE.registerTypeAdapter(WxMassUploadResult.class, new WxMassUploadResultAdapter());
        INSTANCE.registerTypeAdapter(WxMassOpenIdsMessage.class, new WxMassOpenIdsMessageAdapter());
        INSTANCE.registerTypeAdapter(WxMassGroupMessage.class, new WxMassGroupMessageAdapter());
        INSTANCE.registerTypeAdapter(WxCustomMessage.class, new WxCustomMessageAdapter());
        INSTANCE.registerTypeAdapter(WxGroup.class, new WxGroupAdapter());
        INSTANCE.registerTypeAdapter(WxMenu.class, new WxMenuAdapter());
        INSTANCE.registerTypeAdapter(WxTemplateMessage.class, new WxTemplateMessageAdapter());
        INSTANCE.registerTypeAdapter(LoginBean.class, new LoginBeanAdapter());
        INSTANCE.registerTypeAdapter(DailySummary.class, new DailySummaryAdapter());
        INSTANCE.registerTypeAdapter(DailyVisit.class, new DailyVisitAdapter());
        INSTANCE.registerTypeAdapter(VisitDistributionResult.class, new VisitDistributionAdapter());
        INSTANCE.registerTypeAdapter(RetainInfo.class, new RetainInfoAdapter());
        INSTANCE.registerTypeAdapter(VisitPageResult.class, new VisitPageAdapter());
        INSTANCE.registerTypeAdapter(UserPortrait.class, new UserPortraitItemAdapter());
        INSTANCE.registerTypeAdapter(AuthInfoResult.class, new AuthorizerInfoAdapter());
        INSTANCE.registerTypeAdapter(LinkAppResult.class, new LinkAppResultAdapter());
        INSTANCE.registerTypeAdapter(DomainBean.class, new DomainBeanAdapter());
        INSTANCE.registerTypeAdapter(CategoriesResult.class, new CategoriesResultAdapter());
        INSTANCE.registerTypeAdapter(CodeTemplateResult.class, new CodeTemplateResultAdapter());
        INSTANCE.registerTypeAdapter(UpstreamMsgResult.class, new UpstreamMsgResultAdapter());
        INSTANCE.registerTypeAdapter(WxArticleSummaryResult.class, new WxArticleSummaryResultAdapter());
        INSTANCE.registerTypeAdapter(WxUserAnalyzeResult4Calculate.class, new WxUserAnalyzeResult4CaculateAdapter());
        INSTANCE.registerTypeAdapter(WxUserAnalyzeResult4Summary.class, new WxUserAnalyzeResult4SummaryAdapter());
        INSTANCE.registerTypeAdapter(WxArticleTotalResult.class, new WxArticleTotalResultAdapter());
        INSTANCE.registerTypeAdapter(WxMaterialListResult.class, new WxMaterialListResultAdapter());
        INSTANCE.registerTypeAdapter(WxTemplateListResult.class, new WxTemplateListResultAdapter());
        INSTANCE.registerTypeAdapter(WxTemplateIndustry.class, new WxTemplateIndustryAdapter());
        INSTANCE.registerTypeAdapter(WxUserListResult.class, new WxUserListResultAdapter());
        INSTANCE.registerTypeAdapter(Oauth2TokenResult.class, new Oauth2TokenResultAdapter());
    }

    public static Gson create() {
        return INSTANCE.create();
    }
}
