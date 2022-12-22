package com.didichuxing.dfbasesdk.utils;

import com.squareup.otto.Bus;

public class BusUtils {

    /* renamed from: a */
    private static Bus f46694a = new Bus();

    public static Bus getBus() {
        return f46694a;
    }

    public static void register(Object obj) {
        getBus().register(obj);
    }

    public static void unregister(Object obj) {
        try {
            getBus().unregister(obj);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }

    public static void post(Object obj) {
        getBus().post(obj);
    }
}
