package com.didiglobal.dittoview.util;

import android.text.TextUtils;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.dittoview.mvvm.DittoData;
import java.util.HashMap;
import java.util.Map;

public class DittoImgLoadTracker {

    /* renamed from: a */
    private static final String f49895a = "ImgLoadTracker";

    public static void loadUrlOmega(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("img_link", str);
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        DittoOmegaUtils.trackEvent("xpanel_img_download", hashMap);
    }

    public static void loadUrlRetOmega(String str, Map<String, Object> map, int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("img_link", str);
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put("download_status", Integer.valueOf(i));
        hashMap.put("cost_time", Long.valueOf(System.currentTimeMillis() - j));
        DittoOmegaUtils.trackEvent("xpanel_img_download_ret", hashMap);
    }

    public static Map<String, Object> getMapFromAgentData(DittoData dittoData) {
        int optInt;
        if (dittoData == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(dittoData.getId())) {
            hashMap.put(BaseCard.KEY_CARD_ID, dittoData.getId());
        }
        if (!(dittoData.getExtension() == null || (optInt = dittoData.getExtension().optInt("activity_id")) == 0)) {
            hashMap.put("act_id", Integer.valueOf(optInt));
        }
        return hashMap;
    }
}
