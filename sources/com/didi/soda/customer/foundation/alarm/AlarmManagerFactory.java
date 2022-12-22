package com.didi.soda.customer.foundation.alarm;

import android.os.Build;

public final class AlarmManagerFactory {

    /* renamed from: a */
    private static volatile AlarmAdapter f40908a;

    private AlarmManagerFactory() {
    }

    public static AlarmAdapter getAdapter() {
        if (f40908a == null) {
            String str = Build.MANUFACTURER;
            String str2 = Build.MODEL;
            if ("HUAWEI".equalsIgnoreCase(str)) {
                f40908a = new AlarmCustomAdapter();
            } else if ("Xiaomi".equalsIgnoreCase(str)) {
                f40908a = new AlarmCustomAdapter();
            } else {
                if ((str2.startsWith("MI") && str2.compareTo("MI 2") >= 0) || str2.equals("K-Touch S2")) {
                    f40908a = new AlarmCustomAdapter();
                }
                f40908a = new AlarmAdapter();
            }
        }
        return f40908a;
    }
}
