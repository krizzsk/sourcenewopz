package com.datadog.android.core.internal.time;

import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.lyft.kronos.SyncListener;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, mo175978d2 = {"Lcom/datadog/android/core/internal/time/LoggingSyncListener;", "Lcom/lyft/kronos/SyncListener;", "()V", "onError", "", "host", "", "throwable", "", "onStartSync", "onSuccess", "ticksDelta", "", "responseTimeMs", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LoggingSyncListener.kt */
public final class LoggingSyncListener implements SyncListener {
    public void onStartSync(String str) {
        Intrinsics.checkNotNullParameter(str, "host");
    }

    public void onSuccess(long j, long j2) {
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(th, "throwable");
        RuntimeUtilsKt.getSdkLogger().mo20185e("Kronos onError @host:host", th, MapsKt.mapOf(TuplesKt.m42317to("kronos.sync.host", str)));
    }
}
