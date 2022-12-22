package com.didi.entrega.customer.foundation.alarm;

import android.os.Build;

public final class AlarmManagerFactory {

    /* renamed from: a */
    private static volatile AlarmAdapter f19902a;

    private AlarmManagerFactory() {
    }

    public static AlarmAdapter getAdapter() {
        if (f19902a == null) {
            String str = Build.MANUFACTURER;
            String str2 = Build.MODEL;
            if ("HUAWEI".equalsIgnoreCase(str)) {
                f19902a = new AlarmCustomAdapter();
            } else if ("Xiaomi".equalsIgnoreCase(str)) {
                f19902a = new AlarmCustomAdapter();
            } else {
                if ((str2.startsWith("MI") && str2.compareTo("MI 2") >= 0) || str2.equals("K-Touch S2")) {
                    f19902a = new AlarmCustomAdapter();
                }
                f19902a = new AlarmAdapter();
            }
        }
        return f19902a;
    }
}
