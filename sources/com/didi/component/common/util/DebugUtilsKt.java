package com.didi.component.common.util;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.DebugUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a8\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\bø\u0001\u0000\u001a\"\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\bø\u0001\u0000\u001a\u001a\u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\bø\u0001\u0000\u001a\u001a\u0010\u000e\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\bø\u0001\u0000\u001a9\u0010\u000f\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0013\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0014"}, mo175978d2 = {"dumpDebugStack4J", "", "tag", "", "message", "dumpStackIfInDebug", "offset", "", "maxDepth", "Lkotlin/Function0;", "logDIfInDebug", "supplier", "runIfDebuggable", "block", "runIfInDebug", "wrapStack", "", "Ljava/lang/StackTraceElement;", "off", "([Ljava/lang/StackTraceElement;Ljava/lang/String;Ljava/lang/String;II)V", "common_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DebugUtils.kt */
public final class DebugUtilsKt {
    public static final void dumpDebugStack4J(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    public static final void dumpStackIfInDebug(String str, int i, int i2, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(function0, "tag");
    }

    public static final void runIfInDebug(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
    }

    public static final void runIfDebuggable(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (DebugUtils.isDebug()) {
            function0.invoke();
        }
    }

    public static final void logDIfInDebug(String str, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(function0, "supplier");
        GLog.m7965d(str, function0.invoke());
    }

    public static /* synthetic */ void dumpStackIfInDebug$default(String str, int i, int i2, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        int i4 = i3 & 2;
        int i5 = i3 & 4;
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(function0, "tag");
    }

    public static final void wrapStack(StackTraceElement[] stackTraceElementArr, String str, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(stackTraceElementArr, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        int length = i2 <= 0 ? stackTraceElementArr.length : Math.min(stackTraceElementArr.length, i2 + i);
        StringBuilder sb = new StringBuilder(str2);
        if (i < length) {
            while (true) {
                int i3 = i + 1;
                StackTraceElement stackTraceElement = stackTraceElementArr[i];
                sb.append("\nat ");
                sb.append(stackTraceElement.getClassName());
                sb.append('.');
                sb.append(stackTraceElement.getMethodName());
                sb.append(VersionRange.LEFT_OPEN + stackTraceElement.getFileName() + ':' + stackTraceElement.getLineNumber() + VersionRange.RIGHT_OPEN);
                if (i3 >= length) {
                    break;
                }
                i = i3;
            }
        }
        SystemUtils.log(3, str, sb.toString(), (Throwable) null, "com.didi.component.common.util.DebugUtilsKt", 50);
    }
}
