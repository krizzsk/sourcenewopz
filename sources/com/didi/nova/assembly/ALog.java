package com.didi.nova.assembly;

public class ALog {

    /* renamed from: a */
    static boolean f29089a;

    /* renamed from: b */
    static ILog f29090b;

    public interface ILog {
        /* renamed from: d */
        void mo80004d(String str);

        /* renamed from: e */
        void mo80005e(String str);

        /* renamed from: i */
        void mo80006i(String str);
    }

    /* renamed from: d */
    public static void m20507d(String str) {
        if (f29089a) {
            f29090b.mo80004d(str);
        }
    }

    /* renamed from: i */
    public static void m20509i(String str) {
        if (f29089a) {
            f29090b.mo80006i(str);
        }
    }

    /* renamed from: e */
    public static void m20508e(String str) {
        if (f29089a) {
            f29090b.mo80005e(str);
        }
    }
}
