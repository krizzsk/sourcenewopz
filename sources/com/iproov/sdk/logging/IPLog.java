package com.iproov.sdk.logging;

import p097while.C3149do;
import p097while.C3150if;

public class IPLog {
    private static boolean loggingEnabled = true;
    private static final C3150if loggingInstance = new C3149do();

    private IPLog() {
    }

    /* renamed from: d */
    public static void m39300d(String str, String str2) {
        if (loggingEnabled) {
            C3150if ifVar = loggingInstance;
            ifVar.m46237new(getPrefix() + str, str2);
        }
    }

    /* renamed from: e */
    public static void m39301e(String str, String str2) {
        if (loggingEnabled) {
            C3150if ifVar = loggingInstance;
            ifVar.mo38697do(getPrefix() + str, str2);
        }
    }

    private static String getPrefix() {
        return String.format("£ [%s] ", new Object[]{Thread.currentThread().getName()});
    }

    /* renamed from: i */
    public static void m39303i(String str, String str2) {
        if (loggingEnabled) {
            C3150if ifVar = loggingInstance;
            ifVar.m46238try(getPrefix() + str, str2);
        }
    }

    public static void setLoggingEnabled(boolean z) {
        loggingEnabled = z;
    }

    /* renamed from: v */
    public static void m39304v(String str, String str2) {
        if (loggingEnabled) {
            C3150if ifVar = loggingInstance;
            ifVar.mo38700if(getPrefix() + str, str2);
        }
    }

    /* renamed from: w */
    public static void m39305w(String str, String str2) {
        if (loggingEnabled) {
            C3150if ifVar = loggingInstance;
            ifVar.m46236for(getPrefix() + str, str2);
        }
    }

    /* renamed from: e */
    public static void m39302e(String str, String str2, Throwable th) {
        if (loggingEnabled) {
            C3150if ifVar = loggingInstance;
            ifVar.mo38701if(getPrefix() + str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m39306w(String str, String str2, Throwable th) {
        if (loggingEnabled) {
            C3150if ifVar = loggingInstance;
            ifVar.mo38698do(getPrefix() + str, str2, th);
        }
    }
}
