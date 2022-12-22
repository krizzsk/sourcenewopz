package com.didiglobal.ibg_rpc_service.internal;

import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/internal/Logger;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "e", "", "tag", "", "message", "throwable", "", "v", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Logger.kt */
public final class Logger {
    public static final Logger INSTANCE = new Logger();

    /* renamed from: a */
    private static volatile boolean f50252a;

    private Logger() {
    }

    public final boolean getEnable() {
        return f50252a;
    }

    public final void setEnable(boolean z) {
        f50252a = z;
    }

    @JvmStatic
    /* renamed from: v */
    public static final void m36210v(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        if (f50252a) {
            SystemUtils.log(2, str, str2, (Throwable) null, "com.didiglobal.ibg_rpc_service.internal.Logger", 12);
        }
    }

    @JvmStatic
    /* renamed from: e */
    public static final void m36209e(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        if (f50252a) {
            SystemUtils.log(2, str, str2, th, "com.didiglobal.ibg_rpc_service.internal.Logger", 19);
        }
    }
}
