package com.didi.dimina.container.util;

import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.service.LogService;

public class LogUtil {

    /* renamed from: a */
    private static final LogService f17945a = new LogService.NoneLogService();

    /* renamed from: i */
    public static void m13411i(String str) {
        if (m13406b()) {
            m13405a().mo55824i(str);
        }
    }

    /* renamed from: i */
    public static void m13412i(String str, String str2) {
        if (m13406b()) {
            m13405a().mo55825i(str, str2);
        }
    }

    /* renamed from: d */
    public static void m13407d(String str) {
        if (m13406b()) {
            m13405a().mo55818d(str);
        }
    }

    /* renamed from: d */
    public static void m13408d(String str, String str2) {
        if (m13406b()) {
            m13405a().mo55819d(str, str2);
        }
    }

    /* renamed from: e */
    public static void m13409e(String str) {
        if (m13406b()) {
            m13405a().mo55821e(str);
        }
    }

    /* renamed from: e */
    public static void m13410e(String str, String str2) {
        if (m13406b()) {
            m13405a().mo55822e(str, str2);
        }
    }

    /* renamed from: w */
    public static void m13413w(String str) {
        if (m13406b()) {
            m13405a().mo55827w(str);
        }
    }

    /* renamed from: w */
    public static void m13414w(String str, String str2) {
        if (m13406b()) {
            m13405a().mo55828w(str, str2);
        }
    }

    public static void iRelease(String str, String str2) {
        m13405a().iRelease(str, str2);
    }

    public static void dRelease(String str, String str2) {
        m13405a().dRelease(str, str2);
    }

    public static void eRelease(String str, String str2) {
        m13405a().eRelease(str, str2);
    }

    public static void wRelease(String str, String str2) {
        m13405a().wRelease(str, str2);
    }

    /* renamed from: a */
    private static LogService m13405a() {
        if (Dimina.getConfig() == null || Dimina.getConfig().getAdapterConfig() == null || Dimina.getConfig().getAdapterConfig().getLogService() == null) {
            return f17945a;
        }
        return Dimina.getConfig().getAdapterConfig().getLogService();
    }

    /* renamed from: b */
    private static boolean m13406b() {
        return Dimina.getConfig() == null || Dimina.getConfig().isDebug();
    }
}
