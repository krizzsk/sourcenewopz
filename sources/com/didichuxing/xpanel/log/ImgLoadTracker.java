package com.didichuxing.xpanel.log;

import android.text.TextUtils;
import com.didi.soda.compose.card.BaseCard;
import com.didichuxing.xpanel.agent.net.XPanelAgentData;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import java.util.HashMap;
import java.util.Map;

public class ImgLoadTracker {

    /* renamed from: a */
    private static final String f49542a = "ImgLoadTracker";

    public static void loadUrlOmega(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("img_link", str);
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        XPanelOmegaUtils.trackEvent("xpanel_img_download", hashMap);
    }

    public static void loadUrlRetOmega(String str, Map<String, Object> map, int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("img_link", str);
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put("download_status", Integer.valueOf(i));
        hashMap.put("cost_time", Long.valueOf(System.currentTimeMillis() - j));
        XPanelOmegaUtils.trackEvent("xpanel_img_download_ret", hashMap);
    }

    public static Map<String, Object> getMapFromAgentData(XPanelAgentData xPanelAgentData) {
        int optInt;
        if (xPanelAgentData == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(xPanelAgentData.f49304id)) {
            hashMap.put(BaseCard.KEY_CARD_ID, xPanelAgentData.f49304id);
        }
        if (!(xPanelAgentData.extension == null || (optInt = xPanelAgentData.extension.optInt("activity_id")) == 0)) {
            hashMap.put("act_id", Integer.valueOf(optInt));
        }
        return hashMap;
    }
}
