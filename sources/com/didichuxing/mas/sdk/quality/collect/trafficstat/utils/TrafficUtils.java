package com.didichuxing.mas.sdk.quality.collect.trafficstat.utils;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.config.TrafficConfig;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.didichuxing.mas.sdk.quality.report.utils.SavedState;
import java.io.File;
import java.util.Map;

public class TrafficUtils {
    public static final String[] PREDEFINED_TRAFFIC_TRANSACTION_KEYS = {"bg_other_tx", "bg_other_rx", "bg_mobile_tx", "bg_mobile_rx", "bg_wifi_tx", "bg_wifi_rx", "fg_other_tx", "fg_other_rx", "fg_mobile_tx", "fg_mobile_rx", "fg_wifi_tx", "fg_wifi_rx"};

    /* renamed from: a */
    private static Context f48244a = null;

    /* renamed from: b */
    private static SavedState f48245b = null;

    /* renamed from: c */
    private static final String f48246c = "trafficFileCreatedTimeKey";

    public static void init(Context context) {
        f48244a = context;
        f48245b = new SavedState(context, "trafficstat");
    }

    public static boolean isUpperLimitByDay() {
        return CommonUtil.isUpperLimitByDay("upper_limit_traffic_key", TrafficConfig.MAX_UPLOAD_LIMIT_PER_DAY);
    }

    public static void addNetEventNum() {
        CommonUtil.addUpperLimitByDay("upper_limit_traffic_key");
    }

    public static void savefileCreatedTime() {
        f48245b.save(f48246c, System.currentTimeMillis());
    }

    public static long getfileCreatedTime() {
        return f48245b.getLong(f48246c);
    }

    public static boolean hasFileExpiration() {
        long j = getfileCreatedTime();
        return j != 0 && System.currentTimeMillis() - j > TrafficConfig.FILE_EXPIRATION_TIME;
    }

    public static File getTrafficCacheDir() {
        File file = null;
        try {
            file = f48244a.getCacheDir();
            File file2 = new File(file, "alpha_net_cache");
            try {
                if (file2.exists()) {
                    return file2;
                }
                file2.mkdir();
                return file2;
            } catch (Throwable unused) {
                file = file2;
                OLog.m34416d("mkdir fail in getSocketCache");
                return file;
            }
        } catch (Throwable unused2) {
            OLog.m34416d("mkdir fail in getSocketCache");
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
                        OLog.m34418e(str + " missed! when upload TrafficStat");
                        return false;
                    }
                    i++;
                }
            }
        }
        return true;
    }
}
