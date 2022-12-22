package com.didi.aoe.library.logging.impl;

import com.didi.aoe.library.logging.Logger;
import com.didi.sdk.apm.SystemUtils;

public class AoeLoggerImpl implements Logger {

    /* renamed from: a */
    private String f8210a = "AoeLogger";

    public AoeLoggerImpl(String str) {
        this.f8210a = str;
    }

    public void debug(String str, Object... objArr) {
        SystemUtils.log(3, this.f8210a, String.format(str, objArr), (Throwable) null, "com.didi.aoe.library.logging.impl.AoeLoggerImpl", 19);
    }

    public void info(String str, Object... objArr) {
        SystemUtils.log(3, this.f8210a, String.format(str, objArr), (Throwable) null, "com.didi.aoe.library.logging.impl.AoeLoggerImpl", 24);
    }

    public void warn(String str, Throwable th) {
        SystemUtils.log(5, this.f8210a, str, th, "com.didi.aoe.library.logging.impl.AoeLoggerImpl", 29);
    }

    public void warn(String str, Object... objArr) {
        SystemUtils.log(3, this.f8210a, String.format(str, objArr), (Throwable) null, "com.didi.aoe.library.logging.impl.AoeLoggerImpl", 34);
    }

    public void error(String str, Throwable th) {
        SystemUtils.log(6, this.f8210a, str, th, "com.didi.aoe.library.logging.impl.AoeLoggerImpl", 39);
    }

    public void error(String str, Object... objArr) {
        SystemUtils.log(6, this.f8210a, String.format(str, objArr), (Throwable) null, "com.didi.aoe.library.logging.impl.AoeLoggerImpl", 44);
    }
}
