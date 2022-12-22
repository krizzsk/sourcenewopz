package com.datadog.android.core.internal.utils;

import com.datadog.android.BuildConfig;
import com.datadog.android.log.Logger;
import com.datadog.android.log.internal.logger.ConditionalLogHandler;
import com.datadog.android.log.internal.logger.LogcatLogHandler;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\b\u0010\r\u001a\u00020\u000eH\u0000\u001a\b\u0010\u000f\u001a\u00020\u0007H\u0002\u001a\b\u0010\u0010\u001a\u00020\u0007H\u0000\u001a\b\u0010\u0011\u001a\u00020\u0012H\u0000\u001a,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo175978d2 = {"DEV_LOG_PREFIX", "", "SDK_LOGGER_NAME", "SDK_LOG_PREFIX", "WARN_DEPRECATED", "WARN_DEPRECATED_WITH_ALT", "devLogger", "Lcom/datadog/android/log/Logger;", "getDevLogger", "()Lcom/datadog/android/log/Logger;", "<set-?>", "sdkLogger", "getSdkLogger", "buildDevLogHandler", "Lcom/datadog/android/log/internal/logger/ConditionalLogHandler;", "buildDevLogger", "buildSdkLogger", "rebuildSdkLogger", "", "warnDeprecated", "target", "deprecatedSince", "removedInVersion", "alternative", "dd-sdk-android_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RuntimeUtils.kt */
public final class RuntimeUtilsKt {
    public static final String DEV_LOG_PREFIX = "Datadog";
    public static final String SDK_LOGGER_NAME = "sdkLogger";
    public static final String SDK_LOG_PREFIX = "DD_LOG";
    public static final String WARN_DEPRECATED = "%s has been deprecated since version %s, and will be removed in version %s.";
    public static final String WARN_DEPRECATED_WITH_ALT = "%s has been deprecated since version %s, and will be removed in version %s. Please use %s instead";

    /* renamed from: a */
    private static Logger f3589a = buildSdkLogger();

    /* renamed from: b */
    private static final Logger f3590b = m2368a();

    public static final Logger getSdkLogger() {
        return f3589a;
    }

    public static final void rebuildSdkLogger() {
        f3589a = buildSdkLogger();
    }

    public static final Logger buildSdkLogger() {
        Logger.Builder builder = new Logger.Builder();
        Boolean bool = BuildConfig.LOGCAT_ENABLED;
        Intrinsics.checkNotNullExpressionValue(bool, "LOGCAT_ENABLED");
        return builder.setLogcatLogsEnabled(bool.booleanValue()).setServiceName(SDK_LOG_PREFIX).setLoggerName(SDK_LOGGER_NAME).setBundleWithRumEnabled(false).setBundleWithTraceEnabled(false).setNetworkInfoEnabled(true).setInternal$dd_sdk_android_release(true).build();
    }

    public static final Logger getDevLogger() {
        return f3590b;
    }

    /* renamed from: a */
    private static final Logger m2368a() {
        return new Logger(buildDevLogHandler());
    }

    public static final ConditionalLogHandler buildDevLogHandler() {
        return new ConditionalLogHandler(new LogcatLogHandler(DEV_LOG_PREFIX, false), RuntimeUtilsKt$buildDevLogHandler$1.INSTANCE);
    }

    public static /* synthetic */ void warnDeprecated$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = null;
        }
        warnDeprecated(str, str2, str3, str4);
    }

    public static final void warnDeprecated(String str, String str2, String str3, String str4) {
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str, "target");
        Intrinsics.checkNotNullParameter(str2, "deprecatedSince");
        Intrinsics.checkNotNullParameter(str7, "removedInVersion");
        if (str4 == null) {
            Logger logger = f3590b;
            String format = String.format(Locale.US, WARN_DEPRECATED, Arrays.copyOf(new Object[]{str5, str6, str7}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
            Logger.w$default(logger, format, (Throwable) null, (Map) null, 6, (Object) null);
            return;
        }
        Logger logger2 = f3590b;
        String format2 = String.format(Locale.US, WARN_DEPRECATED_WITH_ALT, Arrays.copyOf(new Object[]{str5, str6, str7, str4}, 4));
        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, this, *args)");
        Logger.w$default(logger2, format2, (Throwable) null, (Map) null, 6, (Object) null);
    }
}
