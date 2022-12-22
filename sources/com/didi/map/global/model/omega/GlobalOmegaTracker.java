package com.didi.map.global.model.omega;

import com.didi.common.map.util.DLog;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.env.RoleType;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;

public abstract class GlobalOmegaTracker {
    public static void trackEvent(String str, Map<String, Object> map, String str2) {
        if (map == null) {
            DLog.m7384d("common-model", "trackEvent:%s ,attrs is null", str);
            return;
        }
        map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        if (str2 == null) {
            str2 = "";
        }
        map.put("product_id", str2);
        map.put("user_type", Integer.valueOf(PaxEnvironment.getInstance().getRoleType() == RoleType.DRIVER ? 1 : 0));
        map.put("uid", PaxEnvironment.getInstance().getUid());
        map.put("page", PaxEnvironment.getInstance().getPage().toString());
        map.put("entrance", PaxEnvironment.getInstance().getEntrance().toString());
        OmegaSDKAdapter.trackEvent(str, map);
        StringBuilder sb = new StringBuilder();
        sb.append("【key:");
        sb.append(str);
        sb.append("】");
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                sb.append("\n");
                sb.append((String) next.getKey());
                sb.append(":");
                sb.append(next.getValue());
            }
        }
        DLog.m7384d("common-model", "trackEvent: %s", sb.toString());
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        if (map == null) {
            DLog.m7384d("common-model", "trackEvent:%s ,attrs is null", str);
            return;
        }
        map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        map.put("product_id", PaxEnvironment.getInstance().getProductId());
        map.put("user_type", Integer.valueOf(PaxEnvironment.getInstance().getRoleType() == RoleType.DRIVER ? 1 : 0));
        map.put("uid", PaxEnvironment.getInstance().getUid());
        map.put("page", PaxEnvironment.getInstance().getPage().toString());
        map.put("entrance", PaxEnvironment.getInstance().getEntrance().toString());
        OmegaSDKAdapter.trackEvent(str, map);
        StringBuilder sb = new StringBuilder();
        sb.append("【key:");
        sb.append(str);
        sb.append("】");
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                sb.append("\n");
                sb.append((String) next.getKey());
                sb.append(":");
                sb.append(next.getValue());
            }
        }
        DLog.m7384d("common-model", "trackEvent: %s", sb.toString());
    }
}
