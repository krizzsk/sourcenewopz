package com.didi.payment.base.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.util.GlobalCountryCode;

public class AreaUtil {
    public static final int CITY_ID_HONGKONG = 357;
    public static final int CITY_ID_TAIWAN_FROM = 886500000;
    public static final int CITY_ID_TAIWAN_TO = 886599999;

    public static boolean isInHongKong(int i) {
        return i == 357;
    }

    public static boolean isInTaiWan(int i) {
        return i >= 886500000 && i <= 886599999;
    }

    public static boolean isChinese(String str) {
        return !TextUtils.isEmpty(str) && str.toUpperCase().contains("ZH");
    }

    public static boolean isChineseCN(String str) {
        return !TextUtils.isEmpty(str) && str.toUpperCase().contains(GlobalCountryCode.CHINA);
    }

    public static boolean isChineseHK(String str) {
        return !TextUtils.isEmpty(str) && str.toUpperCase().contains("HK");
    }

    public static boolean isChineseTW(String str) {
        return !TextUtils.isEmpty(str) && str.toUpperCase().contains("TW");
    }

    public static boolean isEngLish(String str) {
        return !TextUtils.isEmpty(str) && str.toUpperCase().contains("EN");
    }

    public static String getTripCountry(Context context) {
        return PayBaseParamUtil.getStringParam(context, "trip_country");
    }

    public static boolean isTripInChina(Context context) {
        String tripCountry = getTripCountry(context);
        return "".equalsIgnoreCase(tripCountry) || GlobalCountryCode.CHINA.equalsIgnoreCase(tripCountry) || "HK".equalsIgnoreCase(tripCountry) || "TW".equalsIgnoreCase(tripCountry);
    }

    public static boolean isTripInJapan(Context context) {
        return "JP".equalsIgnoreCase(getTripCountry(context));
    }
}
