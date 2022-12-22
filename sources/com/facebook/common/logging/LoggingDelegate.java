package com.facebook.common.logging;

public interface LoggingDelegate {
    /* renamed from: d */
    void mo127770d(String str, String str2);

    /* renamed from: d */
    void mo127771d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo127772e(String str, String str2);

    /* renamed from: e */
    void mo127773e(String str, String str2, Throwable th);

    int getMinimumLoggingLevel();

    /* renamed from: i */
    void mo127775i(String str, String str2);

    /* renamed from: i */
    void mo127776i(String str, String str2, Throwable th);

    boolean isLoggable(int i);

    void log(int i, String str, String str2);

    void setMinimumLoggingLevel(int i);

    /* renamed from: v */
    void mo127781v(String str, String str2);

    /* renamed from: v */
    void mo127782v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo127783w(String str, String str2);

    /* renamed from: w */
    void mo127784w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
