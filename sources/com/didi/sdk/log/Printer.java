package com.didi.sdk.log;

public interface Printer {
    /* renamed from: d */
    void mo92477d(String str, Object... objArr);

    /* renamed from: e */
    void mo92478e(String str, Object... objArr);

    /* renamed from: e */
    void mo92479e(Throwable th, String str, Object... objArr);

    Settings getSettings();

    /* renamed from: i */
    void mo92481i(String str, Object... objArr);

    Settings init(String str);

    void json(String str);

    void normalLog(String str);

    /* renamed from: t */
    Printer mo92485t(String str, int i);

    /* renamed from: v */
    void mo92486v(String str, Object... objArr);

    /* renamed from: w */
    void mo92487w(String str, Object... objArr);

    void wtf(String str, Object... objArr);

    void xml(String str);
}
