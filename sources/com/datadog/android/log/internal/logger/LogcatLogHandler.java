package com.datadog.android.log.internal.logger;

import android.os.Build;
import android.util.Log;
import com.datadog.android.Datadog;
import com.datadog.android.log.Logger;
import com.didi.sdk.apm.SystemUtils;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\u0012JU\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\fH\u0002J\u0017\u0010$\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b%R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006'"}, mo175978d2 = {"Lcom/datadog/android/log/internal/logger/LogcatLogHandler;", "Lcom/datadog/android/log/internal/logger/LogHandler;", "serviceName", "", "useClassnameAsTag", "", "(Ljava/lang/String;Z)V", "getServiceName$dd_sdk_android_release", "()Ljava/lang/String;", "getUseClassnameAsTag$dd_sdk_android_release", "()Z", "findValidCallStackElement", "Ljava/lang/StackTraceElement;", "stackTrace", "", "findValidCallStackElement$dd_sdk_android_release", "([Ljava/lang/StackTraceElement;)Ljava/lang/StackTraceElement;", "getCallerStackElement", "getCallerStackElement$dd_sdk_android_release", "handleLog", "", "level", "", "message", "throwable", "", "attributes", "", "", "tags", "", "timestamp", "", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", "resolveSuffix", "stackTraceElement", "resolveTag", "resolveTag$dd_sdk_android_release", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LogcatLogHandler.kt */
public final class LogcatLogHandler implements LogHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final int f3632c = 23;

    /* renamed from: d */
    private static final Regex f3633d = new Regex("(\\$\\d+)+$");
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final String[] f3634e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String[] f3635f = {"com.datadog.android.timber", "timber.log"};

    /* renamed from: a */
    private final String f3636a;

    /* renamed from: b */
    private final boolean f3637b;

    public LogcatLogHandler(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "serviceName");
        this.f3636a = str;
        this.f3637b = z;
    }

    public final String getServiceName$dd_sdk_android_release() {
        return this.f3636a;
    }

    public final boolean getUseClassnameAsTag$dd_sdk_android_release() {
        return this.f3637b;
    }

    public void handleLog(int i, String str, Throwable th, Map<String, ? extends Object> map, Set<String> set, Long l) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, "attributes");
        Intrinsics.checkNotNullParameter(set, "tags");
        StackTraceElement callerStackElement$dd_sdk_android_release = getCallerStackElement$dd_sdk_android_release();
        String resolveTag$dd_sdk_android_release = resolveTag$dd_sdk_android_release(callerStackElement$dd_sdk_android_release);
        SystemUtils.log(i, resolveTag$dd_sdk_android_release, Intrinsics.stringPlus(str, m2400a(callerStackElement$dd_sdk_android_release)), (Throwable) null, "com.datadog.android.log.internal.logger.LogcatLogHandler", 32);
        if (th != null) {
            SystemUtils.log(i, resolveTag$dd_sdk_android_release, Log.getStackTraceString(th), (Throwable) null, "com.datadog.android.log.internal.logger.LogcatLogHandler", 34);
        }
    }

    public final String resolveTag$dd_sdk_android_release(StackTraceElement stackTraceElement) {
        String str;
        if (stackTraceElement == null) {
            str = this.f3636a;
        } else {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "stackTraceElement.className");
            str = StringsKt.substringAfterLast$default(f3633d.replace((CharSequence) className, ""), '.', (String) null, 2, (Object) null);
        }
        if (str.length() < 23 || Build.VERSION.SDK_INT >= 24) {
            return str;
        }
        if (str != null) {
            String substring = str.substring(0, 23);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private final String m2400a(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            return "";
        }
        return "\t| at ." + stackTraceElement.getMethodName() + VersionRange.LEFT_OPEN + stackTraceElement.getFileName() + ':' + stackTraceElement.getLineNumber() + VersionRange.RIGHT_OPEN;
    }

    public final StackTraceElement getCallerStackElement$dd_sdk_android_release() {
        if (!Datadog.INSTANCE.isDebug$dd_sdk_android_release() || !this.f3637b) {
            return null;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        return findValidCallStackElement$dd_sdk_android_release(stackTrace);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/datadog/android/log/internal/logger/LogcatLogHandler$Companion;", "", "()V", "ANONYMOUS_CLASS", "Lkotlin/text/Regex;", "IGNORED_CLASS_NAMES", "", "", "getIGNORED_CLASS_NAMES$dd_sdk_android_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "IGNORED_PACKAGE_PREFIXES", "getIGNORED_PACKAGE_PREFIXES$dd_sdk_android_release", "MAX_TAG_LENGTH", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogcatLogHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String[] getIGNORED_CLASS_NAMES$dd_sdk_android_release() {
            return LogcatLogHandler.f3634e;
        }

        public final String[] getIGNORED_PACKAGE_PREFIXES$dd_sdk_android_release() {
            return LogcatLogHandler.f3635f;
        }
    }

    static {
        String str = null;
        String[] strArr = new String[7];
        strArr[0] = Logger.class.getCanonicalName();
        strArr[1] = LogHandler.class.getCanonicalName();
        String canonicalName = LogHandler.class.getCanonicalName();
        if (canonicalName != null) {
            str = Intrinsics.stringPlus(canonicalName, "$DefaultImpls");
        }
        strArr[2] = str;
        strArr[3] = LogcatLogHandler.class.getCanonicalName();
        strArr[4] = ConditionalLogHandler.class.getCanonicalName();
        strArr[5] = CombinedLogHandler.class.getCanonicalName();
        strArr[6] = DatadogLogHandler.class.getCanonicalName();
        f3634e = strArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (r3 != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.StackTraceElement findValidCallStackElement$dd_sdk_android_release(java.lang.StackTraceElement[] r13) {
        /*
            r12 = this;
            java.lang.String r0 = "stackTrace"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            int r0 = r13.length
            r1 = 0
            r2 = 0
        L_0x0008:
            r3 = 0
            if (r2 >= r0) goto L_0x0043
            r4 = r13[r2]
            java.lang.String[] r5 = f3634e
            java.lang.String r6 = r4.getClassName()
            boolean r5 = kotlin.collections.ArraysKt.contains((T[]) r5, r6)
            r6 = 1
            if (r5 != 0) goto L_0x003b
            java.lang.String[] r5 = f3635f
            int r7 = r5.length
            r8 = 0
        L_0x001e:
            if (r8 >= r7) goto L_0x0037
            r9 = r5[r8]
            java.lang.String r10 = r4.getClassName()
            java.lang.String r11 = "element.className"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r11 = 2
            boolean r9 = kotlin.text.StringsKt.startsWith$default(r10, r9, r1, r11, r3)
            if (r9 == 0) goto L_0x0034
            r3 = 0
            goto L_0x0038
        L_0x0034:
            int r8 = r8 + 1
            goto L_0x001e
        L_0x0037:
            r3 = 1
        L_0x0038:
            if (r3 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            if (r6 == 0) goto L_0x0040
            r3 = r4
            goto L_0x0043
        L_0x0040:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x0043:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.log.internal.logger.LogcatLogHandler.findValidCallStackElement$dd_sdk_android_release(java.lang.StackTraceElement[]):java.lang.StackTraceElement");
    }
}
