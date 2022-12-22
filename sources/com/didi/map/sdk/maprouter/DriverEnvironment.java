package com.didi.map.sdk.maprouter;

import android.text.TextUtils;
import com.didi.map.sdk.maprouter.global.PlatInfo;

public class DriverEnvironment {
    public static void setDomainFlavor(String str) {
        PlatInfo.getInstance().setDomainFlavor(str);
    }

    public static void setFullDomainApiMap(String str) {
        PlatInfo.getInstance().setFullDomainApiMap(str);
    }

    public static void setFullDomainPoiMap(String str) {
        PlatInfo.getInstance().setFullDomainPoiMap(str);
    }

    public static void setTerminalId(int i) {
        PlatInfo.getInstance().setTerminalId(i);
    }

    public static void setClientVersion(String str) {
        if (!TextUtils.isEmpty(str)) {
            PlatInfo.getInstance().setClientVersion(str);
        }
    }

    public static void setDriverPhoneNumber(String str) {
        if (!TextUtils.isEmpty(str)) {
            PlatInfo.getInstance().setDriverPhoneNumber(str);
        }
    }

    public static void setDriverTicket(String str) {
        if (!TextUtils.isEmpty(str)) {
            PlatInfo.getInstance().setDriverTicket(str);
        }
    }

    public static void setDriverId(long j) {
        PlatInfo.getInstance().setDriverId(j);
    }

    public static void setTraverId(String str) {
        if (!TextUtils.isEmpty(str)) {
            PlatInfo.getInstance().setTraverId(str);
        }
    }

    public static void setBizType(int i) {
        PlatInfo.getInstance().setBizType(i);
    }

    @Deprecated
    public static void setCountryID(String str) {
        if (!TextUtils.isEmpty(str)) {
            PlatInfo.getInstance().setCountryID(str);
        }
    }

    public static void setCountryCode(String str) {
        if (!TextUtils.isEmpty(str)) {
            PlatInfo.getInstance().setCountryCode(str);
        }
    }

    public static void setCountryLanguage(String str) {
        if (!TextUtils.isEmpty(str)) {
            PlatInfo.getInstance().setCountryLanguage(str);
        }
    }

    public static void setMapType(MapType mapType) {
        PlatInfo.getInstance().setMapType(mapType);
    }

    public static void setOnNavTtsListener(OnNavTtsListener onNavTtsListener) {
        PlatInfo.getInstance().setOnNavTtsListener(onNavTtsListener);
    }

    public static void setTravelModeNum(int i) {
        PlatInfo.getInstance().setTravelModeNum(i);
    }
}
