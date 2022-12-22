package com.didi.onekeyshare.track;

import android.content.Context;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.track.OmegaEventId;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OmegaTrack {
    public static void trackSharePagedShow(Context context, List<OneKeyShareInfo> list) {
        if (list != null && !list.isEmpty() && context != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(context.getString(list.get(i).platform.alias()));
                if (i < list.size() - 1) {
                    sb.append("、");
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("chanel", sb.toString());
            hashMap.put("type", 1);
            if (list.size() > 8) {
                hashMap.put("slidetp", 1);
            } else {
                hashMap.put("slidetp", 0);
            }
            OmegaSDKAdapter.trackEvent("share_window_sw", (Map<String, Object>) hashMap);
        }
    }

    public static void trackShareChannelClick(String str, Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put("chanel", str);
        m20897a(map, hashMap);
        OmegaSDKAdapter.trackEvent("share_chanel_ck", (Map<String, Object>) hashMap);
    }

    public static void trackRefreshClick() {
        OmegaSDKAdapter.trackEvent(OmegaEventId.SHARE_REFRESH_CLICK);
    }

    public static void trackRefreshShow() {
        OmegaSDKAdapter.trackEvent(OmegaEventId.SHARE_REFRESH_SHOW);
    }

    public static void trackShareResult(String str, Map map, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("chanel", str);
        m20897a(map, hashMap);
        hashMap.put("result", str2);
        OmegaSDKAdapter.trackEvent(OmegaEventId.SHARE_CHANNEL_RESULT, (Map<String, Object>) hashMap);
    }

    public static void trackCancelClick(String str) {
        new HashMap().put("type", str);
        OmegaSDKAdapter.trackEvent(OmegaEventId.SHARE_CANCEL_CLICK);
    }

    public static void trackSlideShow() {
        OmegaSDKAdapter.trackEvent(OmegaEventId.SHARE_SLIDE_SHOW);
    }

    public static void trackShareShow(List<OneKeyShareInfo> list, Map map) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).platform != null) {
                    sb.append(list.get(i).platform.platformName());
                    if (i < list.size() - 1) {
                        sb.append("、");
                    }
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("chanel", sb.toString());
            m20897a(map, hashMap);
            if (list.size() > 8) {
                hashMap.put("slidetp", 1);
            } else {
                hashMap.put("slidetp", 0);
            }
            OmegaSDKAdapter.trackEvent("share_window_sw", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    private static void m20897a(Map map, Map<String, Object> map2) {
        Map<String, Object> a = m20896a(map);
        if (a != null && a.size() > 0) {
            map2.putAll(a);
        }
    }

    /* renamed from: a */
    private static Map<String, Object> m20896a(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.put("type", map.get(OmegaEventId.AttrKey.TYPE));
            hashMap.put("source", map.get(OmegaEventId.AttrKey.SOURCE));
            hashMap.put("resource_id", map.get("resource_id"));
        }
        return hashMap;
    }
}
