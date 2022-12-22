package com.didichuxing.mas.sdk.quality.report.utils;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.MASCallback;
import com.didichuxing.mas.sdk.quality.report.MASConfig;

public class OLog {
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static void traceLog(int i, String str, Throwable th) {
        if (MASCallback.iPrintLogListener == null) {
            return;
        }
        if (MASConfig.SWITCH_PRINT_TRACE_LOG || i >= 4) {
            MASCallback.iPrintLogListener.printLog(i, str, th);
        }
    }

    /* renamed from: v */
    public static int m34422v(String str) {
        traceLog(2, str, (Throwable) null);
        if (MASConfig.SWITCH_PRINT_TRACE_LOG) {
            return SystemUtils.log(2, Constants.LOG_TAG, str, (Throwable) null, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 40);
        }
        return 0;
    }

    /* renamed from: v */
    public static int m34423v(String str, Throwable th) {
        traceLog(2, str, th);
        if (MASConfig.SWITCH_PRINT_TRACE_LOG) {
            return SystemUtils.log(2, Constants.LOG_TAG, str, th, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 45);
        }
        return 0;
    }

    public static int dBig(String str) {
        String str2 = str;
        traceLog(3, str2, (Throwable) null);
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 3000;
            if (i2 > str.length()) {
                SystemUtils.log(3, Constants.LOG_TAG, str2.substring(i), (Throwable) null, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 62);
            } else {
                SystemUtils.log(3, Constants.LOG_TAG, str2.substring(i, i2), (Throwable) null, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 65);
                SystemUtils.log(3, Constants.LOG_TAG, "-- to be continued --", (Throwable) null, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 66);
            }
            i = i2;
        }
        return 0;
    }

    /* renamed from: d */
    public static int m34416d(String str) {
        traceLog(3, str, (Throwable) null);
        if (MASConfig.LOG_PRINT) {
            return SystemUtils.log(3, Constants.LOG_TAG, str, (Throwable) null, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 75);
        }
        return 0;
    }

    /* renamed from: d */
    public static int m34417d(String str, Throwable th) {
        traceLog(3, str, th);
        if (MASConfig.LOG_PRINT) {
            return SystemUtils.log(3, Constants.LOG_TAG, str, th, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 80);
        }
        return 0;
    }

    /* renamed from: i */
    public static int m34420i(String str) {
        traceLog(4, str, (Throwable) null);
        if (MASConfig.LOG_PRINT) {
            return SystemUtils.log(4, Constants.LOG_TAG, str, (Throwable) null, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 85);
        }
        return 0;
    }

    /* renamed from: i */
    public static int m34421i(String str, Throwable th) {
        traceLog(4, str, th);
        if (MASConfig.LOG_PRINT) {
            return SystemUtils.log(4, Constants.LOG_TAG, str, th, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 90);
        }
        return 0;
    }

    /* renamed from: w */
    public static int m34424w(String str) {
        traceLog(5, str, (Throwable) null);
        if (MASConfig.LOG_PRINT) {
            return SystemUtils.log(5, Constants.LOG_TAG, str, (Throwable) null, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 95);
        }
        return 0;
    }

    /* renamed from: w */
    public static int m34425w(String str, Throwable th) {
        traceLog(5, str, th);
        if (MASConfig.LOG_PRINT) {
            return SystemUtils.log(5, Constants.LOG_TAG, str, th, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 100);
        }
        return 0;
    }

    /* renamed from: e */
    public static int m34418e(String str) {
        traceLog(6, str, (Throwable) null);
        if (MASConfig.LOG_PRINT) {
            return SystemUtils.log(6, Constants.LOG_TAG, str, (Throwable) null, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 105);
        }
        return 0;
    }

    /* renamed from: e */
    public static int m34419e(String str, Throwable th) {
        traceLog(6, str, th);
        if (MASConfig.LOG_PRINT) {
            return SystemUtils.log(6, Constants.LOG_TAG, str, th, "com.didichuxing.mas.sdk.quality.report.utils.OLog", 110);
        }
        return 0;
    }
}
