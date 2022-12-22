package com.didichuxing.mas.sdk.quality.report.collector;

import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.EncryptUtils;
import com.didichuxing.mas.sdk.quality.report.customevent.CustomEvent;
import com.didichuxing.mas.sdk.quality.report.customevent.CustomEventUp;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomCollector {
    private static String mAppKey;
    private static String mSessionId;

    public static void init() {
    }

    public static String getUid() {
        String str;
        try {
            if (MASConfig.iGetUid != null) {
                str = MASConfig.iGetUid.getUid();
                if (str != null) {
                }
                str = "";
            } else {
                str = MASConfig.userIdFromH5;
            }
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getUid", th, true);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getUtk() {
        String didiToken;
        String str = null;
        try {
            if (!(MASConfig.iGetDidiToken == null || (didiToken = MASConfig.iGetDidiToken.getDidiToken()) == null || didiToken.length() <= 0)) {
                str = didiToken;
            }
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getUtk", th);
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static int getCityId() {
        try {
            if (MASConfig.iGetCityId != null) {
                return MASConfig.iGetCityId.getCityId();
            }
            return MASConfig.cityIdFromH5;
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getCityId", th);
            return 0;
        }
    }

    public static Map<String, Object> getExtraParams() {
        HashMap hashMap = new HashMap();
        try {
            if (MASConfig.iGetExtraParams != null) {
                return MASConfig.iGetExtraParams.getExtraParams();
            }
            return hashMap;
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getExtraParams", th);
            return hashMap;
        }
    }

    public static String getPhone() {
        String str;
        try {
            if (MASConfig.iGetPhone != null) {
                str = MASConfig.iGetPhone.getPhone();
                if (str != null && str.length() > 0) {
                }
                str = "";
            } else {
                str = MASConfig.phoneNumberFromH5;
            }
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getPhone", th, true);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getEncryptedPhone() {
        String phone = getPhone();
        return !TextUtils.isEmpty(phone) ? EncryptUtils.encrypt(phone.getBytes()) : phone;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        if (r1.length() > 0) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDailingCountryCode() {
        /*
            java.lang.String r0 = ""
            com.didichuxing.mas.sdk.quality.report.MASConfig$IGetDailingCountryCode r1 = com.didichuxing.mas.sdk.quality.report.MASConfig.iGetDailingCountryCode     // Catch:{ all -> 0x0015 }
            if (r1 == 0) goto L_0x001b
            com.didichuxing.mas.sdk.quality.report.MASConfig$IGetDailingCountryCode r1 = com.didichuxing.mas.sdk.quality.report.MASConfig.iGetDailingCountryCode     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = r1.getDailingCountryCode()     // Catch:{ all -> 0x0015 }
            if (r1 == 0) goto L_0x001b
            int r2 = r1.length()     // Catch:{ all -> 0x0015 }
            if (r2 <= 0) goto L_0x001b
            goto L_0x001c
        L_0x0015:
            r1 = move-exception
            java.lang.String r2 = "MAS.getDailingCountryCode"
            com.didichuxing.mas.sdk.quality.report.utils.CommonUtil.operateErr((java.lang.String) r2, (java.lang.Throwable) r1)
        L_0x001b:
            r1 = r0
        L_0x001c:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.collector.CustomCollector.getDailingCountryCode():java.lang.String");
    }

    public static void startSession() {
        mSessionId = CommonUtil.randomBase64UUID();
    }

    public static boolean isInSession() {
        return mSessionId != null;
    }

    public static String getSessionId() {
        return mSessionId;
    }

    public static void stopSession() {
        mSessionId = null;
    }

    public static String getAppKey() {
        return mAppKey;
    }

    public static void setAppKey(String str) {
        mAppKey = str;
    }

    public static String getDidiDeviceId() {
        String str;
        if (MASConfig.iGetDidiDeviceId == null) {
            return "";
        }
        try {
            str = MASConfig.iGetDidiDeviceId.getDidiDeviceId();
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getDidiDeviceId", th);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getDidiSuuid() {
        String str;
        if (MASConfig.iGetDidiSuuid == null) {
            return "";
        }
        try {
            str = MASConfig.iGetDidiSuuid.getDidiSuuid();
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getDidiSuuid", th);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getGetUiCid() {
        String str;
        if (MASConfig.iGetUiCid == null) {
            return "";
        }
        try {
            str = MASConfig.iGetUiCid.getUiCid();
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getGetUiCid", th);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getLocale() {
        String str;
        if (MASConfig.iLocale == null) {
            return "";
        }
        try {
            str = MASConfig.iLocale.getLocale();
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getLocale", th);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getChannel() {
        String str;
        if (MASConfig.iGetChannel == null) {
            return "";
        }
        try {
            str = MASConfig.iGetChannel.getChannel();
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getChannel", th);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static long getTimeOffSet() {
        if (MASConfig.iGetTimeOffset == null) {
            return 0;
        }
        try {
            return MASConfig.iGetTimeOffset.getTimeOffset();
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getTimeOffSet", th);
            return 0;
        }
    }

    public static long getHotPatchVersion() {
        if (MASConfig.iGetHotPatchVersion == null) {
            return -1;
        }
        try {
            return MASConfig.iGetHotPatchVersion.getHotPatchVersion();
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getHotPatchVersion", th);
            return -1;
        }
    }

    public static String getPluginInfo() {
        String str;
        if (MASConfig.iGetPluginInfo == null) {
            return "{}";
        }
        try {
            str = MASConfig.iGetPluginInfo.getPluginInfo();
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getPluginInfo", th);
            str = "{}";
        }
        if (TextUtils.isEmpty(str)) {
            return "{}";
        }
        return str;
    }

    public static int getCountryId() {
        if (MASConfig.iGetCountryId == null) {
            return 0;
        }
        try {
            return MASConfig.iGetCountryId.getCountryId();
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getCountryId", th);
            return 0;
        }
    }

    public static List<String> getUploadURLWhiteList() {
        if (MASConfig.iGetUploadURLWhiteList == null) {
            return null;
        }
        try {
            return MASConfig.iGetUploadURLWhiteList.getURLWhiteList();
        } catch (Throwable th) {
            CommonUtil.operateErr("MAS.getUploadURLWhiteList", th);
            return null;
        }
    }

    public static String getJsonByCustomEventMap() {
        if (MASConfig.customEventMap == null) {
            OLog.m34420i("CustomCollector [getJsonCustomEventMap] customEventMap is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, CustomEvent> customEventMap = MASConfig.customEventMap.getCustomEventMap();
        for (String str : customEventMap.keySet()) {
            CustomEvent customEvent = customEventMap.get(str);
            if (customEvent != null) {
                arrayList.add(new CustomEventUp(customEvent));
            }
        }
        return new Gson().toJson((Object) arrayList);
    }
}
