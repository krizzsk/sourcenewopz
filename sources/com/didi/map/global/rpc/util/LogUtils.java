package com.didi.map.global.rpc.util;

import com.didi.map.global.rpc.model.addr.Address;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class LogUtils {

    /* renamed from: a */
    private static final Logger f27356a = LoggerFactory.getLogger("poi-base-lib");

    public static void logInfo(String str) {
        f27356a.info(str, new Object[0]);
    }

    public static void logWarn(String str) {
        f27356a.warn(str, new Object[0]);
    }

    public static boolean isValidLocation(Address address) {
        return (address == null || Double.compare(address.latitude, 0.0d) == 0 || Double.compare(address.longitude, 0.0d) == 0) ? false : true;
    }
}
