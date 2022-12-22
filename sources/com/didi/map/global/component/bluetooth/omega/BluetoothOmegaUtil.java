package com.didi.map.global.component.bluetooth.omega;

import com.didi.map.global.component.bluetooth.util.C9358Util;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;

public class BluetoothOmegaUtil {
    public static void reportOmegaAdvertiseSucceed(String str, boolean z) {
        if (str != null && !str.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put(Constants.BACKGROUND, Integer.valueOf(z ^ true ? 1 : 0));
            GlobalOmegaTracker.trackEvent("tech_map_bluetooth_advertiser_success", hashMap);
        }
    }

    public static void reportOmegaAdvertiseFailed(String str, boolean z, int i) {
        if (str != null && !str.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put(Constants.BACKGROUND, Integer.valueOf(z ^ true ? 1 : 0));
            hashMap.put("errno", Integer.valueOf(i));
            GlobalOmegaTracker.trackEvent("tech_map_bluetooth_advertiser_fail", hashMap);
        }
    }

    public static void reportOmegaStartScan(String str, boolean z) {
        if (str != null && !str.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put(Constants.BACKGROUND, Integer.valueOf(z ^ true ? 1 : 0));
            try {
                hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
                C9358Util.logWrite(e.toString());
            }
            GlobalOmegaTracker.trackEvent("tech_map_bluetooth_scan_start", hashMap);
        }
    }

    public static void reportOmegaScanFailed(String str, boolean z, int i) {
        if (str != null && !str.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put(Constants.BACKGROUND, Integer.valueOf(z ^ true ? 1 : 0));
            hashMap.put("errno", Integer.valueOf(i));
            try {
                hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
                C9358Util.logWrite(e.toString());
            }
            GlobalOmegaTracker.trackEvent("tech_map_bluetooth_scan_fail", hashMap);
        }
    }
}
