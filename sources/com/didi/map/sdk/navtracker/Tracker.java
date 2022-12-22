package com.didi.map.sdk.navtracker;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.text.TextUtils;
import com.didi.component.common.net.CarServerParam;
import com.didi.map.sdk.navtracker.log.DLog;
import com.didi.map.sdk.sharetrack.net.DUrl;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

public class Tracker {

    /* renamed from: a */
    private static final String f28553a = Tracker.class.getSimpleName();

    public static void pickup(Context context, TrackerNavInfo trackerNavInfo, String str) {
        if (trackerNavInfo == null) {
            DLog.m20199d(f28553a, "pickup info is null", new Object[0]);
        } else if (context == null) {
            DLog.m20199d(f28553a, "pickup context is null", new Object[0]);
        } else {
            trackerNavInfo.methodType = "0";
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", trackerNavInfo.orderId);
            hashMap.put(FirebaseAnalytics.Param.TRANSACTION_ID, trackerNavInfo.transactionId);
            hashMap.put("app_version", trackerNavInfo.appVersion);
            hashMap.put("app_name", trackerNavInfo.appName);
            hashMap.put("country_code", trackerNavInfo.countryCode);
            hashMap.put("phone_num", trackerNavInfo.phoneNumber);
            hashMap.put("method_type", trackerNavInfo.methodType);
            hashMap.put("os", trackerNavInfo.f28557os);
            hashMap.put("dt", trackerNavInfo.f28556dt);
            DLog.m20199d(f28553a, "start track pickup", new Object[0]);
            OmegaSDKAdapter.trackEvent("mex_dri_google_navigate_transaction_pickup_ck", (Map<String, Object>) hashMap);
            TrackerUploader.m20193a(context, trackerNavInfo, str);
        }
    }

    public static void dropoff(Context context, TrackerNavInfo trackerNavInfo, String str) {
        if (trackerNavInfo == null) {
            DLog.m20199d(f28553a, "dropoff info is null", new Object[0]);
        } else if (context == null) {
            DLog.m20199d(f28553a, "dropoff context is null", new Object[0]);
        } else {
            trackerNavInfo.methodType = "1";
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", trackerNavInfo.orderId);
            hashMap.put(FirebaseAnalytics.Param.TRANSACTION_ID, trackerNavInfo.transactionId);
            hashMap.put("app_version", trackerNavInfo.appVersion);
            hashMap.put("app_name", trackerNavInfo.appName);
            hashMap.put("country_code", trackerNavInfo.countryCode);
            hashMap.put("phone_num", trackerNavInfo.phoneNumber);
            hashMap.put("method_type", trackerNavInfo.methodType);
            hashMap.put("os", trackerNavInfo.f28557os);
            hashMap.put("dt", trackerNavInfo.f28556dt);
            DLog.m20199d(f28553a, "start track dropoff", new Object[0]);
            OmegaSDKAdapter.trackEvent("mex_dri_google_navigate_transaction_dropoff_ck", (Map<String, Object>) hashMap);
            TrackerUploader.m20193a(context, trackerNavInfo, str);
        }
    }

    public static void onMapCreate(Context context, TrackerMapInfo trackerMapInfo, long j) {
        if (context == null) {
            DLog.m20199d(f28553a, "map context is null", new Object[0]);
        } else if (trackerMapInfo == null) {
            DLog.m20199d(f28553a, "map info is null", new Object[0]);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("time", Long.valueOf(j));
            hashMap.put("app_name", trackerMapInfo.appName);
            hashMap.put("map_id", trackerMapInfo.mapId);
            hashMap.put("os", trackerMapInfo.f28555os);
            hashMap.put("dt", trackerMapInfo.f28554dt);
            hashMap.put("user_id", TrackerAdditionInfo.usrId);
            hashMap.put("app_version", TrackerAdditionInfo.appVersion);
            hashMap.put("country_code", TrackerAdditionInfo.countryCode);
            hashMap.put("phone_num", TrackerAdditionInfo.phoneNum);
            DLog.m20199d(f28553a, "start track map", new Object[0]);
            OmegaSDKAdapter.trackEvent("google_map_oncreate_time", (Map<String, Object>) hashMap);
            TrackerUploader.m20192a(context.getApplicationContext(), trackerMapInfo);
        }
    }

    public static void updateMapAdditionArgs(Context context, String str, String str2, String str3, String str4) {
        if (context == null) {
            TrackerOmegaUtil.trackOraFail(105);
        } else if (TextUtils.isEmpty(str)) {
            TrackerOmegaUtil.trackOraFail(107);
        } else {
            TrackerAdditionInfo.countryCode = str;
            TrackerAdditionInfo.usrId = str2;
            TrackerAdditionInfo.phoneNum = str3;
            TrackerAdditionInfo.appVersion = str4;
            TrackerPreference.setCountryCode(str, context);
            TrackerPreference.setPhoneNum(str3, context);
            TrackerPreference.setUserId(str2, context);
            TrackerPreference.setAppVersion(str4, context);
            DLog.m20199d(f28553a, "start track with args", new Object[0]);
            TrackerUploader.m20192a(context.getApplicationContext(), (TrackerMapInfo) null);
            m20189a(str2);
        }
    }

    public static boolean isRussia(Context context) {
        return DUrl.PACKAGE_NAME_DRIVER_RU.compareToIgnoreCase(getPackageName(context)) == 0;
    }

    public static String getPackageName(Context context) {
        return context != null ? context.getApplicationContext().getPackageName() : "";
    }

    /* renamed from: a */
    private static void m20189a(String str) {
        int i;
        if (Apollo.getToggle("global_map_driver_bluetooth_permission_toggle").allow()) {
            HashMap hashMap = new HashMap();
            hashMap.put(CarServerParam.PARAM_DRIVER_ID, str);
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                i = 3;
                hashMap.put("status", 3);
                SystemUtils.log(6, "ccc", "本机没有找到蓝牙硬件或驱动！", (Throwable) null, "com.didi.map.sdk.navtracker.Tracker", 182);
            } else if (defaultAdapter.isEnabled()) {
                i = 1;
                hashMap.put("status", 1);
                SystemUtils.log(6, "ccc", "蓝牙已打开！", (Throwable) null, "com.didi.map.sdk.navtracker.Tracker", 187);
            } else {
                i = 2;
                hashMap.put("status", 2);
                SystemUtils.log(6, "ccc", "蓝牙关闭着！", (Throwable) null, "com.didi.map.sdk.navtracker.Tracker", 191);
            }
            OmegaSDKAdapter.trackEvent("map_drvnearvibration_bluetooth_bt", (Map<String, Object>) hashMap);
            SystemUtils.log(6, "ccc", "map_drvnearvibration_bluetooth_bt; driver_id:" + str + " status:" + i, (Throwable) null, "com.didi.map.sdk.navtracker.Tracker", 196);
        }
    }
}
