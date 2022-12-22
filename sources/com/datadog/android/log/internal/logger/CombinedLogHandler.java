package com.datadog.android.log.internal.logger;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001¢\u0006\u0002\u0010\u0004JU\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017R\u001e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, mo175978d2 = {"Lcom/datadog/android/log/internal/logger/CombinedLogHandler;", "Lcom/datadog/android/log/internal/logger/LogHandler;", "handlers", "", "([Lcom/datadog/android/log/internal/logger/LogHandler;)V", "getHandlers$dd_sdk_android_release", "()[Lcom/datadog/android/log/internal/logger/LogHandler;", "[Lcom/datadog/android/log/internal/logger/LogHandler;", "handleLog", "", "level", "", "message", "", "throwable", "", "attributes", "", "", "tags", "", "timestamp", "", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CombinedLogHandler.kt */
public final class CombinedLogHandler implements LogHandler {

    /* renamed from: a */
    private final LogHandler[] f3624a;

    public CombinedLogHandler(LogHandler... logHandlerArr) {
        Intrinsics.checkNotNullParameter(logHandlerArr, "handlers");
        this.f3624a = logHandlerArr;
    }

    public final LogHandler[] getHandlers$dd_sdk_android_release() {
        return this.f3624a;
    }

    public void handleLog(int i, String str, Throwable th, Map<String, ? extends Object> map, Set<String> set, Long l) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, "attributes");
        Intrinsics.checkNotNullParameter(set, "tags");
        for (LogHandler handleLog : this.f3624a) {
            handleLog.handleLog(i, str, th, map, set, l);
        }
    }
}
