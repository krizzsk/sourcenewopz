package com.didichuxing.omega.sdk.common.utils;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.common.OmegaCallback;
import com.didichuxing.omega.sdk.common.OmegaConfig;

public class OLog {
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static void traceLog(int i, String str, Throwable th) {
        if (OmegaCallback.iPrintLogListener == null) {
            return;
        }
        if (OmegaConfig.SWITCH_PRINT_TRACE_LOG || i >= 4) {
            OmegaCallback.iPrintLogListener.printLog(i, str, th);
        }
    }

    /* renamed from: v */
    public static int m34767v(String str) {
        traceLog(2, str, (Throwable) null);
        if (OmegaConfig.SWITCH_PRINT_TRACE_LOG) {
            return SystemUtils.log(2, "omegasdk", str, (Throwable) null, "com.didichuxing.omega.sdk.common.utils.OLog", 42);
        }
        return 0;
    }

    /* renamed from: v */
    public static int m34768v(String str, Throwable th) {
        traceLog(2, str, th);
        if (OmegaConfig.SWITCH_PRINT_TRACE_LOG) {
            return SystemUtils.log(2, "omegasdk", str, th, "com.didichuxing.omega.sdk.common.utils.OLog", 47);
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
                SystemUtils.log(3, "omegasdk", str2.substring(i), (Throwable) null, "com.didichuxing.omega.sdk.common.utils.OLog", 63);
            } else {
                SystemUtils.log(3, "omegasdk", str2.substring(i, i2), (Throwable) null, "com.didichuxing.omega.sdk.common.utils.OLog", 66);
                SystemUtils.log(3, "omegasdk", "-- to be continued --", (Throwable) null, "com.didichuxing.omega.sdk.common.utils.OLog", 67);
            }
            i = i2;
        }
        return 0;
    }

    /* renamed from: d */
    public static int m34761d(String str) {
        traceLog(3, str, (Throwable) null);
        if (OmegaConfig.LOG_PRINT) {
            return SystemUtils.log(3, "omegasdk", str, (Throwable) null, "com.didichuxing.omega.sdk.common.utils.OLog", 76);
        }
        return 0;
    }

    /* renamed from: d */
    public static int m34762d(String str, Throwable th) {
        traceLog(3, str, th);
        if (OmegaConfig.LOG_PRINT) {
            return SystemUtils.log(3, "omegasdk", str, th, "com.didichuxing.omega.sdk.common.utils.OLog", 81);
        }
        return 0;
    }

    /* renamed from: i */
    public static int m34765i(String str) {
        traceLog(4, str, (Throwable) null);
        if (OmegaConfig.LOG_PRINT) {
            return SystemUtils.log(4, "omegasdk", str, (Throwable) null, "com.didichuxing.omega.sdk.common.utils.OLog", 86);
        }
        return 0;
    }

    /* renamed from: i */
    public static int m34766i(String str, Throwable th) {
        traceLog(4, str, th);
        if (OmegaConfig.LOG_PRINT) {
            return SystemUtils.log(4, "omegasdk", str, th, "com.didichuxing.omega.sdk.common.utils.OLog", 91);
        }
        return 0;
    }

    /* renamed from: w */
    public static int m34769w(String str) {
        traceLog(5, str, (Throwable) null);
        if (OmegaConfig.LOG_PRINT) {
            return SystemUtils.log(5, "omegasdk", str, (Throwable) null, "com.didichuxing.omega.sdk.common.utils.OLog", 96);
        }
        return 0;
    }

    /* renamed from: w */
    public static int m34770w(String str, Throwable th) {
        traceLog(5, str, th);
        if (OmegaConfig.LOG_PRINT) {
            return SystemUtils.log(5, "omegasdk", str, th, "com.didichuxing.omega.sdk.common.utils.OLog", 101);
        }
        return 0;
    }

    /* renamed from: e */
    public static int m34763e(String str) {
        traceLog(6, str, (Throwable) null);
        if (OmegaConfig.LOG_PRINT) {
            return SystemUtils.log(6, "omegasdk", str, (Throwable) null, "com.didichuxing.omega.sdk.common.utils.OLog", 106);
        }
        return 0;
    }

    /* renamed from: e */
    public static int m34764e(String str, Throwable th) {
        traceLog(6, str, th);
        if (OmegaConfig.LOG_PRINT) {
            return SystemUtils.log(6, "omegasdk", str, th, "com.didichuxing.omega.sdk.common.utils.OLog", 111);
        }
        return 0;
    }
}
