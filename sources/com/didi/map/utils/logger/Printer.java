package com.didi.map.utils.logger;

public interface Printer {
    void addAdapter(LogAdapter logAdapter);

    void clearLogAdapters();

    /* renamed from: d */
    void mo79947d(Object obj);

    /* renamed from: d */
    void mo79948d(String str, Object... objArr);

    /* renamed from: e */
    void mo79949e(String str, Object... objArr);

    /* renamed from: e */
    void mo79950e(Throwable th, String str, Object... objArr);

    /* renamed from: i */
    void mo79951i(String str, Object... objArr);

    void json(String str);

    void log(int i, String str, String str2, Throwable th);

    /* renamed from: t */
    Printer mo79954t(String str);

    /* renamed from: v */
    void mo79955v(String str, Object... objArr);

    /* renamed from: w */
    void mo79956w(String str, Object... objArr);

    void wtf(String str, Object... objArr);

    void xml(String str);
}
