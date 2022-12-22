package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.log.HWLog;
import com.didi.map.MapApolloHawaii;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class NativeLogCallback {
    private static final int BAMAI_LOG = 4;
    private static final String NATIVE_TAG = "native_render_log";
    private static final int OMEGA_LOG = 8;
    private static final int PRINT_LOG = 1;
    private static boolean logEnable = MapApolloHawaii.isNativeLogEnable();
    private static boolean omegaEnable = MapApolloHawaii.isNativeOmegaEnable();

    public static void onLogWrite(String str, boolean z, String str2) {
        HWLog.m16761i(NATIVE_TAG, "log_key=" + str + ",isOk=" + z + ", message=" + str2);
    }

    public static void onEventReport(String str, Object[] objArr, Object[] objArr2, int i) {
        if (str != null) {
            if (i == 0) {
                OmegaSDKAdapter.trackEvent(str);
                return;
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < i; i2++) {
                hashMap.put(objArr[i2], objArr2[i2]);
            }
            OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
        }
    }
}
