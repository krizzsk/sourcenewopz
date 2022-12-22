package com.datadog.android.core.internal.time;

import com.lyft.kronos.Clock;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/core/internal/time/KronosTimeProvider;", "Lcom/datadog/android/core/internal/time/TimeProvider;", "clock", "Lcom/lyft/kronos/Clock;", "(Lcom/lyft/kronos/Clock;)V", "getDeviceTimestamp", "", "getServerOffsetMillis", "getServerOffsetNanos", "getServerTimestamp", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KronosTimeProvider.kt */
public final class KronosTimeProvider implements TimeProvider {

    /* renamed from: a */
    private final Clock f3587a;

    public KronosTimeProvider(Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.f3587a = clock;
    }

    public long getDeviceTimestamp() {
        return System.currentTimeMillis();
    }

    public long getServerTimestamp() {
        return this.f3587a.getCurrentTimeMs();
    }

    public long getServerOffsetMillis() {
        return this.f3587a.getCurrentTimeMs() - System.currentTimeMillis();
    }

    public long getServerOffsetNanos() {
        return TimeUnit.MILLISECONDS.toNanos(getServerOffsetMillis());
    }
}
