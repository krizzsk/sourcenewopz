package com.android.didi.bfflib.utils;

import android.util.Log;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class TrackUtil {
    public static final int ERROR_TYPE_BFF_CANCEL = 4;
    public static final int ERROR_TYPE_BFF_ERROR = 3;
    public static final int ERROR_TYPE_CODE_ERROR = 5;
    public static final int ERROR_TYPE_JSON_FAIL = 1;
    public static final int ERROR_TYPE_NET_ERROR = 2;
    public static final int ERROR_TYPE_UNKNOWN = -1;

    public static void trackError(int i, String str, String str2, String str3, String str4, int i2, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("err_type", Integer.valueOf(i));
        hashMap.put(ParamConst.TRACE_ID, str);
        hashMap.put("err_msg", str2);
        hashMap.put("err_no", Integer.valueOf(i2));
        hashMap.put("ability_id", str5);
        hashMap.put("err_stack", str3);
        hashMap.put("json", str4);
        LoggerFactory.getLogger("GlobalBff").info("bff error", (Map<?, ?>) hashMap);
        if (i != 2 && i != 4) {
            OmegaSDKAdapter.trackEvent("tech_bff_error", (Map<String, Object>) hashMap);
        }
    }

    public static void trackError(int i, String str, Exception exc, String str2, int i2, String str3) {
        String str4 = "";
        String stackTraceString = (i == 2 || exc == null) ? str4 : Log.getStackTraceString(exc);
        if (exc != null) {
            str4 = exc.getMessage();
        }
        trackError(i, str, str4, stackTraceString, str2, i2, str3);
    }

    public static void trackError(int i, String str, Exception exc, String str2) {
        trackError(i, str, exc, str2, 0, "");
    }

    public static void trackError(int i, String str, Exception exc, String str2, String str3) {
        trackError(i, str, exc, str2, 0, str3);
    }
}
