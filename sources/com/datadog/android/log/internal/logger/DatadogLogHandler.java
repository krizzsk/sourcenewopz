package com.datadog.android.log.internal.logger;

import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.sampling.RateBasedSampler;
import com.datadog.android.core.internal.sampling.Sampler;
import com.datadog.android.core.model.NetworkInfo;
import com.datadog.android.core.model.UserInfo;
import com.datadog.android.log.internal.domain.LogGenerator;
import com.datadog.android.log.model.LogEvent;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumErrorSource;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJN\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0!2\u0006\u0010\"\u001a\u00020#H\u0002JU\u0010$\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0002\u0010&R\u0014\u0010\t\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006'"}, mo175978d2 = {"Lcom/datadog/android/log/internal/logger/DatadogLogHandler;", "Lcom/datadog/android/log/internal/logger/LogHandler;", "logGenerator", "Lcom/datadog/android/log/internal/domain/LogGenerator;", "writer", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "Lcom/datadog/android/log/model/LogEvent;", "bundleWithTraces", "", "bundleWithRum", "sampler", "Lcom/datadog/android/core/internal/sampling/Sampler;", "(Lcom/datadog/android/log/internal/domain/LogGenerator;Lcom/datadog/android/core/internal/persistence/DataWriter;ZZLcom/datadog/android/core/internal/sampling/Sampler;)V", "getBundleWithRum$dd_sdk_android_release", "()Z", "getBundleWithTraces$dd_sdk_android_release", "getLogGenerator$dd_sdk_android_release", "()Lcom/datadog/android/log/internal/domain/LogGenerator;", "getSampler$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/sampling/Sampler;", "getWriter$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/DataWriter;", "createLog", "level", "", "message", "", "throwable", "", "attributes", "", "", "tags", "", "timestamp", "", "handleLog", "", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DatadogLogHandler.kt */
public final class DatadogLogHandler implements LogHandler {

    /* renamed from: a */
    private final LogGenerator f3627a;

    /* renamed from: b */
    private final DataWriter<LogEvent> f3628b;

    /* renamed from: c */
    private final boolean f3629c;

    /* renamed from: d */
    private final boolean f3630d;

    /* renamed from: e */
    private final Sampler f3631e;

    public DatadogLogHandler(LogGenerator logGenerator, DataWriter<LogEvent> dataWriter, boolean z, boolean z2, Sampler sampler) {
        Intrinsics.checkNotNullParameter(logGenerator, "logGenerator");
        Intrinsics.checkNotNullParameter(dataWriter, "writer");
        Intrinsics.checkNotNullParameter(sampler, "sampler");
        this.f3627a = logGenerator;
        this.f3628b = dataWriter;
        this.f3629c = z;
        this.f3630d = z2;
        this.f3631e = sampler;
    }

    public final LogGenerator getLogGenerator$dd_sdk_android_release() {
        return this.f3627a;
    }

    public final DataWriter<LogEvent> getWriter$dd_sdk_android_release() {
        return this.f3628b;
    }

    public final boolean getBundleWithTraces$dd_sdk_android_release() {
        return this.f3629c;
    }

    public final boolean getBundleWithRum$dd_sdk_android_release() {
        return this.f3630d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DatadogLogHandler(LogGenerator logGenerator, DataWriter dataWriter, boolean z, boolean z2, Sampler sampler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(logGenerator, dataWriter, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? new RateBasedSampler(1.0f) : sampler);
    }

    public final Sampler getSampler$dd_sdk_android_release() {
        return this.f3631e;
    }

    public void handleLog(int i, String str, Throwable th, Map<String, ? extends Object> map, Set<String> set, Long l) {
        String str2 = str;
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, "attributes");
        Intrinsics.checkNotNullParameter(set, "tags");
        long currentTimeMillis = l == null ? System.currentTimeMillis() : l.longValue();
        if (this.f3631e.sample()) {
            this.f3628b.write(m2399a(i, str, th, map, set, currentTimeMillis));
        }
        if (i >= 6) {
            Throwable th2 = th;
            GlobalRum.get().addError(str, RumErrorSource.LOGGER, th, map);
        }
    }

    /* renamed from: a */
    private final LogEvent m2399a(int i, String str, Throwable th, Map<String, ? extends Object> map, Set<String> set, long j) {
        boolean z = this.f3630d;
        return LogGenerator.generateLog$default(this.f3627a, i, str, th, map, set, j, (String) null, this.f3629c, z, (UserInfo) null, (NetworkInfo) null, 1600, (Object) null);
    }
}
