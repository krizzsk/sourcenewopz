package com.didiglobal.xbanner.template.yoga;

import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.xbanner.router.XBRouter;
import com.didiglobal.xbanner.template.mdel.XBannerCDNData;
import com.didiglobal.xbanner.template.mdel.XBannerExtension;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class CommonEventListener implements EventListener {

    /* renamed from: a */
    private static String f51514a = "CommonEventListener";

    /* renamed from: b */
    private long f51515b;

    /* renamed from: c */
    private long f51516c = 500;
    protected XBannerCDNData data;

    public CommonEventListener(XBannerCDNData xBannerCDNData) {
        this.data = xBannerCDNData;
    }

    public boolean handleEvent(String str, String str2, Map<String, Object> map) {
        String str3 = str2;
        Map<String, Object> map2 = map;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f51515b < this.f51516c) {
            return false;
        }
        this.f51515b = uptimeMillis;
        JSONObject jSONObject = (JSONObject) map2.get("extension");
        String str4 = (String) map2.get("id");
        int intValue = ((Integer) map2.get("index")).intValue();
        XBannerExtension xBannerExtension = null;
        if (jSONObject != null) {
            xBannerExtension = m36875a(new JsonParser().parse(jSONObject.toString()).getAsJsonObject(), intValue, str4);
        }
        String str5 = f51514a;
        SystemUtils.log(3, str5, "handleEvent:" + str + ",data:" + map2, (Throwable) null, "com.didiglobal.xbanner.template.yoga.CommonEventListener", 47);
        if (str3 != null) {
            XBRouter.routerStart(str3, xBannerExtension);
            HashMap hashMap = new HashMap();
            if (xBannerExtension != null) {
                hashMap.put(BaseCard.KEY_CARD_ID, xBannerExtension.f51476id);
                if (xBannerExtension.log_data != null) {
                    try {
                        hashMap.putAll((Map) new Gson().fromJson((JsonElement) xBannerExtension.log_data, new HashMap().getClass()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            hashMap.put("type", 0);
            hashMap.put("rank", 0);
            OmegaSDKAdapter.trackEvent("ibt_gp_operationcard_ck", (Map<String, Object>) hashMap);
        }
        return false;
    }

    /* renamed from: a */
    private XBannerExtension m36875a(JsonObject jsonObject, int i, String str) {
        XBannerExtension xBannerExtension = new XBannerExtension();
        if (jsonObject == null) {
            return xBannerExtension;
        }
        try {
            if (jsonObject.has("biz_params")) {
                xBannerExtension.biz_params = jsonObject.get("biz_params").getAsJsonObject();
            }
            if (jsonObject.has("log_data")) {
                xBannerExtension.log_data = jsonObject.get("log_data").getAsJsonObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        xBannerExtension.index = i;
        xBannerExtension.f51476id = str;
        return xBannerExtension;
    }
}
