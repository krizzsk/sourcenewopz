package com.map.sdk.nav.libc.common;

import com.didi.common.map.util.DLog;
import com.didi.component.common.net.CarServerParam;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MapMatchTracker {
    private static String mOrderId = "";

    public static void setOrderId(String str) {
        mOrderId = str;
    }

    public static void trackMapMatchEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                HashMap hashMap = new HashMap();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    Iterator<String> keys2 = optJSONObject.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        hashMap.put(next2, optJSONObject.getString(next2));
                    }
                    hashMap.put(CarServerParam.PARAM_DRIVER_ID, Long.valueOf(PlatInfo.getInstance().getDriverId()));
                    hashMap.put("order_id", mOrderId);
                    hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                    traceEvent(next, hashMap);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DLog.m7384d("MapMatchTracker", "trackJson = " + str, new Object[0]);
    }

    public static void traceEvent(String str, Map map) {
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) map);
        StringBuilder sb = new StringBuilder();
        for (Object next : map.entrySet()) {
            sb.append(" " + next.toString() + " ");
        }
        DLog.m7384d("MapMatchTracker", "[trackEvent] id = " + str + ", " + sb.toString(), new Object[0]);
    }
}
