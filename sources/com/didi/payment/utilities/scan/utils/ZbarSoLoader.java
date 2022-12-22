package com.didi.payment.utilities.scan.utils;

import com.didi.payment.base.tracker.PayTracker;
import java.util.HashMap;

public class ZbarSoLoader {
    public static boolean loadSoError = true;

    public static void load() {
    }

    static {
        try {
            System.loadLibrary("iconv");
            System.loadLibrary("zbarjni");
        } catch (Throwable th) {
            th.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("error", th.getCause());
            PayTracker.trackEvent("ibt_gp_scan_zbar_so_load_error_bt", hashMap);
        }
    }
}
