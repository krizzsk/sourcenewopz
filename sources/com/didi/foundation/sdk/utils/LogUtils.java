package com.didi.foundation.sdk.utils;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/foundation/sdk/utils/LogUtils;", "", "()V", "logger", "Lcom/didi/sdk/logging/Logger;", "output", "", "getOutput", "()Z", "setOutput", "(Z)V", "d", "", "msg", "", "e", "i", "print", "global-foundation-sdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LogUtils.kt */
public final class LogUtils {
    public static final LogUtils INSTANCE = new LogUtils();

    /* renamed from: a */
    private static boolean f21394a = true;

    /* renamed from: b */
    private static final Logger f21395b;

    public final void print(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
    }

    static {
        Logger logger = LoggerFactory.getLogger("LocaleServiceImpl");
        Intrinsics.checkExpressionValueIsNotNull(logger, "LoggerFactory.getLogger(\"LocaleServiceImpl\")");
        f21395b = logger;
    }

    private LogUtils() {
    }

    public final boolean getOutput() {
        return f21394a;
    }

    public final void setOutput(boolean z) {
        f21394a = z;
    }

    /* renamed from: d */
    public final void mo63518d(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        if (f21394a) {
            f21395b.debug(str, new Object[0]);
        }
    }

    /* renamed from: i */
    public final void mo63521i(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        if (f21394a) {
            f21395b.info(str, new Object[0]);
        }
    }

    /* renamed from: e */
    public final void mo63519e(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        if (f21394a) {
            f21395b.error(str, new Object[0]);
        }
    }
}
