package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.lou.weixin.sdk.bean.result.weapp.PageItem;
import com.lou.weixin.sdk.bean.result.weapp.VisitPageResult;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 小程序页面访问数据Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class VisitPageAdapter implements JsonDeserializer<VisitPageResult> {

    @Override
    public VisitPageResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        VisitPageResult vp = new VisitPageResult();
        vp.setRefDate(GsonConvertUtil.getString(o, "ref_date"));
        JsonArray list = o.get("list").getAsJsonArray();
        List<PageItem> pageItemList = Lists.newArrayList();
        for (JsonElement e : list) {
            JsonObject temp = e.getAsJsonObject();
            PageItem pageItem = new PageItem();
            pageItem.setPagePath(GsonConvertUtil.getString(temp, "page_path"));
            pageItem.setPageVisitPv(GsonConvertUtil.getInteger(temp, "page_visit_pv"));
            pageItem.setPageVisitUv(GsonConvertUtil.getInteger(temp, "page_visit_uv"));
            pageItem.setPageStaytimePv(GsonConvertUtil.getString(temp, "page_staytime_pv"));
            pageItem.setEntryPagePv(GsonConvertUtil.getInteger(temp, "entrypage_pv"));
            pageItem.setExiPagePv(GsonConvertUtil.getInteger(temp, "exitpage_pv"));
            pageItem.setPageSharePv(GsonConvertUtil.getInteger(temp, "page_share_pv"));
            pageItem.setPageShareUv(GsonConvertUtil.getInteger(temp, "page_share_uv"));
            pageItemList.add(pageItem);
        }
        vp.setList(pageItemList);
        return vp;
    }

    public static void main(String[] args) {
        String str = "{\n" +
                "  \"ref_date\": \"20170313\",\n" +
                "  \"list\": [\n" +
                "    {\n" +
                "      \"page_path\": \"pages/main/main.html\",\n" +
                "      \"page_visit_pv\": 213429,\n" +
                "      \"page_visit_uv\": 55423,\n" +
                "      \"page_staytime_pv\": 8.139198,\n" +
                "      \"entrypage_pv\": 117922,\n" +
                "      \"exitpage_pv\": 61304,\n" +
                "      \"page_share_pv\": 180,\n" +
                "      \"page_share_uv\": 166\n" +
                "    },\n" +
                "    {\n" +
                "      \"page_path\": \"pages/linedetail/linedetail.html\",\n" +
                "      \"page_visit_pv\": 155030,\n" +
                "      \"page_visit_uv\": 42195,\n" +
                "      \"page_staytime_pv\": 35.462395,\n" +
                "      \"entrypage_pv\": 21101,\n" +
                "      \"exitpage_pv\": 47051,\n" +
                "      \"page_share_pv\": 47,\n" +
                "      \"page_share_uv\": 42\n" +
                "    },\n" +
                "    {\n" +
                "      \"page_path\": \"pages/search/search.html\",\n" +
                "      \"page_visit_pv\": 65011,\n" +
                "      \"page_visit_uv\": 24716,\n" +
                "      \"page_staytime_pv\": 6.889634,\n" +
                "      \"entrypage_pv\": 1811,\n" +
                "      \"exitpage_pv\": 3198,\n" +
                "      \"page_share_pv\": 0,\n" +
                "      \"page_share_uv\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"page_path\": \"pages/stationdetail/stationdetail.html\",\n" +
                "      \"page_visit_pv\": 29953,\n" +
                "      \"page_visit_uv\": 9695,\n" +
                "      \"page_staytime_pv\": 7.558508,\n" +
                "      \"entrypage_pv\": 1386,\n" +
                "      \"exitpage_pv\": 2285,\n" +
                "      \"page_share_pv\": 0,\n" +
                "      \"page_share_uv\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"page_path\": \"pages/switch-city/switch-city.html\",\n" +
                "      \"page_visit_pv\": 8928,\n" +
                "      \"page_visit_uv\": 4017,\n" +
                "      \"page_staytime_pv\": 9.22659,\n" +
                "      \"entrypage_pv\": 748,\n" +
                "      \"exitpage_pv\": 1613,\n" +
                "      \"page_share_pv\": 0,\n" +
                "      \"page_share_uv\": 0\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JsonElement json = Streams.parse(new JsonReader(new StringReader(str)));
    }

}
