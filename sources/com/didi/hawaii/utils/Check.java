package com.didi.hawaii.utils;

import com.didichuxing.apollo.sdk.Apollo;

public final class Check {
    public static final int FAILED = 0;
    public static final int SUCCESS = 1;

    /* renamed from: a */
    private static Checker f24191a = null;

    /* renamed from: b */
    private static final String f24192b = "apollo_hawaii_enable_check";

    /* renamed from: c */
    private static final boolean f24193c = Apollo.getToggle(f24192b).allow();

    public interface BooleanTester {
        boolean pass();
    }

    public interface Checker {
        void onHappen(String str, int i, String str2);
    }

    private Check() {
    }

    public static void happenIf(boolean z, String str, int i, String str2) {
        Checker checker;
        if (f24193c && (checker = f24191a) != null && z) {
            checker.onHappen(str, i, str2);
        }
    }

    public static void happenIf(BooleanTester booleanTester, String str, int i, String str2) {
        Checker checker;
        if (f24193c && (checker = f24191a) != null && booleanTester.pass()) {
            checker.onHappen(str, i, str2);
        }
    }

    public static void happenFailure(String str) {
        happenFailure(str, (String) null);
    }

    public static void happenFailure(String str, String str2) {
        happen(str, 0, str2);
    }

    public static void happenSuccess(String str) {
        happenSuccess(str, (String) null);
    }

    public static void happenSuccess(String str, String str2) {
        happen(str, 1, str2);
    }

    public static void happen(String str, int i, String str2) {
        Checker checker;
        if (f24193c && (checker = f24191a) != null) {
            checker.onHappen(str, i, str2);
        }
    }

    public static void setChecker(Checker checker) {
        if (f24193c) {
            f24191a = checker;
        }
    }
}
