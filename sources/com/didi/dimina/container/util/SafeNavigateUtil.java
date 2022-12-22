package com.didi.dimina.container.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/dimina/container/util/SafeNavigateUtil;", "", "()V", "invokeGapTime", "", "invokeGapTime$annotations", "getInvokeGapTime", "()J", "lastRunTime", "lastRunTime$annotations", "getLastRunTime", "setLastRunTime", "(J)V", "safeNavigate", "", "navigateMethod", "Lkotlin/Function0;", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SafeNavigateUtil.kt */
public final class SafeNavigateUtil {
    public static final SafeNavigateUtil INSTANCE = new SafeNavigateUtil();

    /* renamed from: a */
    private static long f17962a = 0;

    /* renamed from: b */
    private static final long f17963b = 100;

    @JvmStatic
    public static /* synthetic */ void invokeGapTime$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void lastRunTime$annotations() {
    }

    private SafeNavigateUtil() {
    }

    public static final long getLastRunTime() {
        return f17962a;
    }

    public static final void setLastRunTime(long j) {
        f17962a = j;
    }

    public static final long getInvokeGapTime() {
        return f17963b;
    }

    @JvmStatic
    public static final void safeNavigate(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "navigateMethod");
        if (f17962a == 0) {
            function0.invoke();
            f17962a = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - f17962a < f17963b) {
            UIHandlerUtil.postDelayed(new SafeNavigateUtil$safeNavigate$1(function0), f17963b);
        } else {
            function0.invoke();
            f17962a = System.currentTimeMillis();
        }
    }
}
