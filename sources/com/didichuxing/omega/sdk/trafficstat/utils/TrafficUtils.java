package com.didichuxing.omega.sdk.trafficstat.utils;

import android.content.Context;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.didichuxing.omega.sdk.common.utils.SavedState;
import com.didichuxing.omega.sdk.trafficstat.config.TrafficConfig;
import java.io.File;
import java.util.Map;

public class TrafficUtils {
    public static final String[] PREDEFINED_TRAFFIC_TRANSACTION_KEYS = {"bg_other_tx", "bg_other_rx", "bg_mobile_tx", "bg_mobile_rx", "bg_wifi_tx", "bg_wifi_rx", "fg_other_tx", "fg_other_rx", "fg_mobile_tx", "fg_mobile_rx", "fg_wifi_tx", "fg_wifi_rx"};
    private static final String fileCreatedTimeKey = "trafficFileCreatedTimeKey";
    private static Context mContext;
    private static SavedState mSavedState;

    public static void init(Context context) {
        mContext = context;
        mSavedState = new SavedState(context, "trafficstat");
    }

    public static boolean isUpperLimitByDay() {
        return CommonUtil.isUpperLimitByDay("upper_limit_traffic_key", TrafficConfig.MAX_UPLOAD_LIMIT_PER_DAY);
    }

    public static void addNetEventNum() {
        CommonUtil.addUpperLimitByDay("upper_limit_traffic_key");
    }

    public static void savefileCreatedTime() {
        mSavedState.save(fileCreatedTimeKey, System.currentTimeMillis());
    }

    public static long getfileCreatedTime() {
        return mSavedState.getLong(fileCreatedTimeKey);
    }

    public static boolean hasFileExpiration() {
        long j = getfileCreatedTime();
        return j != 0 && System.currentTimeMillis() - j > TrafficConfig.FILE_EXPIRATION_TIME;
    }

    public static File getTrafficCacheDir() {
        File file = null;
        try {
            file = mContext.getCacheDir();
            File file2 = new File(file, "alpha_net_cache");
            try {
                if (file2.exists()) {
                    return file2;
                }
                file2.mkdir();
                return file2;
            } catch (Throwable unused) {
                file = file2;
                OLog.m34761d("mkdir fail in getSocketCache");
                return file;
            }
        } catch (Throwable unused2) {
            OLog.m34761d("mkdir fail in getSocketCache");
            return file;
        }
    }

    public static boolean containsAllKey(Map<String, Object> map) {
        for (Map.Entry<String, Object> value : map.entrySet()) {
            Map map2 = (Map) value.getValue();
            if (map2 == null || map2.isEmpty()) {
                return false;
            }
            String[] strArr = PREDEFINED_TRAFFIC_TRANSACTION_KEYS;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    String str = strArr[i];
                    if (!map2.containsKey(str)) {
                        OLog.m34763e(str + " missed! when upload TrafficStat");
                        return false;
                    }
                    i++;
                }
            }
        }
        return true;
    }
}
