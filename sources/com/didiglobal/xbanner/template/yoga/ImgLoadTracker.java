package com.didiglobal.xbanner.template.yoga;

import android.text.TextUtils;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.xbanner.template.mdel.XBannerCDNData;
import java.util.HashMap;
import java.util.Map;

public class ImgLoadTracker {

    /* renamed from: a */
    private static final String f51517a = "ImgLoadTracker";

    public static void loadUrlOmega(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("img_link", str);
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
    }

    public static void loadUrlRetOmega(String str, Map<String, Object> map, int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("img_link", str);
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put("download_status", Integer.valueOf(i));
        hashMap.put("cost_time", Long.valueOf(System.currentTimeMillis() - j));
    }

    public static Map<String, Object> getMapFromAgentData(XBannerCDNData xBannerCDNData) {
        int optInt;
        if (xBannerCDNData == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(xBannerCDNData.getId())) {
            hashMap.put(BaseCard.KEY_CARD_ID, xBannerCDNData.getId());
        }
        if (!(xBannerCDNData.getExtension() == null || (optInt = xBannerCDNData.getExtension().optInt("activity_id")) == 0)) {
            hashMap.put("act_id", Integer.valueOf(optInt));
        }
        return hashMap;
    }
}
