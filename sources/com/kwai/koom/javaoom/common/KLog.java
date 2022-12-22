package com.kwai.koom.javaoom.common;

import com.didi.sdk.apm.SystemUtils;

public class KLog {

    /* renamed from: a */
    private static KLogger f55603a;

    public interface KLogger {
        /* renamed from: d */
        void mo164789d(String str, String str2);

        /* renamed from: e */
        void mo164790e(String str, String str2);

        /* renamed from: i */
        void mo164791i(String str, String str2);
    }

    public static class DefaultLogger implements KLogger {
        /* renamed from: i */
        public void mo164791i(String str, String str2) {
            SystemUtils.log(4, str, str2, (Throwable) null, "com.kwai.koom.javaoom.common.KLog$DefaultLogger", 18);
        }

        /* renamed from: d */
        public void mo164789d(String str, String str2) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.kwai.koom.javaoom.common.KLog$DefaultLogger", 23);
        }

        /* renamed from: e */
        public void mo164790e(String str, String str2) {
            SystemUtils.log(6, str, str2, (Throwable) null, "com.kwai.koom.javaoom.common.KLog$DefaultLogger", 28);
        }
    }

    public static void init(KLogger kLogger) {
        f55603a = kLogger;
    }

    /* renamed from: i */
    public static void m40102i(String str, String str2) {
        if (f55603a == null) {
            init(new DefaultLogger());
        }
        f55603a.mo164791i(str, str2);
    }

    /* renamed from: d */
    public static void m40100d(String str, String str2) {
        if (f55603a == null) {
            init(new DefaultLogger());
        }
        f55603a.mo164789d(str, str2);
    }

    /* renamed from: e */
    public static void m40101e(String str, String str2) {
        if (f55603a == null) {
            init(new DefaultLogger());
        }
        f55603a.mo164790e(str, str2);
    }
}
