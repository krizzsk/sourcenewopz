package com.didichuxing.mas.sdk.quality.collect.trafficstat.model;

import java.util.HashMap;
import java.util.Map;

public class TrafficData {
    public static final String BackMobileRxBytes = "bg_mobile_rx";
    public static final String BackMobileTxBytes = "bg_mobile_tx";
    public static final String BackOtherRxBytes = "bg_other_rx";
    public static final String BackOtherTxBytes = "bg_other_tx";
    public static final String BackWifiRxBytes = "bg_wifi_rx";
    public static final String BackWifiTxBytes = "bg_wifi_tx";
    public static final String ForeMobileRxBytes = "fg_mobile_rx";
    public static final String ForeMobileTxBytes = "fg_mobile_tx";
    public static final String ForeOtherRxBytes = "fg_other_rx";
    public static final String ForeOtherTxBytes = "fg_other_tx";
    public static final String ForeWifiRxBytes = "fg_wifi_rx";
    public static final String ForeWifiTxBytes = "fg_wifi_tx";

    public static Map<String, Object> getEmptyDataMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("fg_mobile_rx", 0L);
        hashMap.put("fg_mobile_tx", 0L);
        hashMap.put("fg_wifi_rx", 0L);
        hashMap.put("fg_wifi_tx", 0L);
        hashMap.put("fg_other_rx", 0L);
        hashMap.put("fg_other_tx", 0L);
        hashMap.put("bg_mobile_rx", 0L);
        hashMap.put("bg_mobile_tx", 0L);
        hashMap.put("bg_wifi_rx", 0L);
        hashMap.put("bg_wifi_tx", 0L);
        hashMap.put("bg_other_rx", 0L);
        hashMap.put("bg_other_tx", 0L);
        return hashMap;
    }

    public static boolean isNotEmpty(Map<String, Object> map) {
        return Long.parseLong(map.get("bg_mobile_rx").toString()) > 0 || Long.parseLong(map.get("bg_mobile_tx").toString()) > 0 || Long.parseLong(map.get("bg_mobile_rx").toString()) > 0 || Long.parseLong(map.get("bg_wifi_rx").toString()) > 0 || Long.parseLong(map.get("bg_wifi_tx").toString()) > 0 || Long.parseLong(map.get("bg_other_rx").toString()) > 0 || Long.parseLong(map.get("bg_other_tx").toString()) > 0 || Long.parseLong(map.get("fg_mobile_rx").toString()) > 0 || Long.parseLong(map.get("fg_mobile_tx").toString()) > 0 || Long.parseLong(map.get("fg_wifi_rx").toString()) > 0 || Long.parseLong(map.get("fg_wifi_tx").toString()) > 0 || Long.parseLong(map.get("fg_other_rx").toString()) > 0 || Long.parseLong(map.get("fg_other_tx").toString()) > 0;
    }
}
