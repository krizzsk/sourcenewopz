package com.didi.map.sdk.navtracker;

import android.text.TextUtils;

public class TrackerAdditionInfo {
    public static String appVersion = "";
    public static String countryCode = "";
    public static String phoneNum = "";
    public static String usrId = "";

    /* renamed from: a */
    static boolean m20190a() {
        return !TextUtils.isEmpty(countryCode);
    }
}
