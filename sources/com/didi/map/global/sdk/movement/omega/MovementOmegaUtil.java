package com.didi.map.global.sdk.movement.omega;

import android.text.TextUtils;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didi.map.global.sdk.movement.apollo.MovementApolloUtil;
import com.didi.map.global.sdk.movement.ble.BlueToothEngine;
import java.util.HashMap;
import java.util.Random;

public class MovementOmegaUtil {
    public static final int NAV_MODE_BLE_TO_BLE = 2;
    public static final int NAV_MODE_BLE_TO_GPS = 1;
    public static final int NAV_MODE_GPS_TO_GPS = 0;

    public static void reportOmegaBTNav(String str, BlueToothEngine.CacheNavInfo cacheNavInfo, int i) {
        if (cacheNavInfo != null && !TextUtils.isEmpty(str) && m19876a(MovementApolloUtil.getBleTrackRate())) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put("mix_mode", Integer.valueOf(i));
            if (cacheNavInfo.gps != null) {
                hashMap.put("angle0", Float.valueOf(cacheNavInfo.gps.direct_pax_toDriver));
            }
            if (cacheNavInfo.pdr != null) {
                hashMap.put("angle1", Float.valueOf(cacheNavInfo.pdr.direct_pax_toDriver));
            }
            if (cacheNavInfo.normal != null) {
                hashMap.put("angle2", Float.valueOf(cacheNavInfo.normal.direct_pax_toDriver));
            }
            if (i == 0 && cacheNavInfo.gps != null) {
                hashMap.put("eda", Double.valueOf(cacheNavInfo.gps.eda));
            } else if (i == 1 && cacheNavInfo.pdr != null) {
                hashMap.put("eda", Double.valueOf(cacheNavInfo.pdr.eda));
            } else if (i == 2 && cacheNavInfo.normal != null) {
                hashMap.put("eda", Double.valueOf(cacheNavInfo.normal.eda));
            }
            GlobalOmegaTracker.trackEvent("map_btnavi_direction_bt", hashMap);
        }
    }

    /* renamed from: a */
    private static boolean m19876a(int i) {
        Random random = new Random(System.currentTimeMillis());
        if (i >= 1000) {
            return true;
        }
        if (i > 0 && random.nextInt(1000) < i) {
            return true;
        }
        return false;
    }
}
