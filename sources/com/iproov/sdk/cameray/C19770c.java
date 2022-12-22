package com.iproov.sdk.cameray;

/* renamed from: com.iproov.sdk.cameray.c */
/* compiled from: CameraFactoryProvider */
class C19770c {

    /* renamed from: a */
    private static final String f54008a = m38673b();

    /* renamed from: a */
    public static C19778else m38672a() {
        C19778else c = m38674c();
        return c != null ? c : new C19781goto();
    }

    /* renamed from: b */
    static String m38673b() {
        return new this$do().toString();
    }

    /* renamed from: c */
    private static C19778else m38674c() {
        try {
            return (C19778else) Class.forName(f54008a).newInstance();
        } catch (Exception unused) {
            return null;
        }
    }
}
