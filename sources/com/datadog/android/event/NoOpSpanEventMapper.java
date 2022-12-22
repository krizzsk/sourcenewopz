package com.datadog.android.event;

import com.datadog.android.tracing.model.SpanEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lcom/datadog/android/event/NoOpSpanEventMapper;", "Lcom/datadog/android/event/SpanEventMapper;", "()V", "map", "Lcom/datadog/android/tracing/model/SpanEvent;", "event", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NoOpSpanEventMapper.kt */
public final class NoOpSpanEventMapper implements SpanEventMapper {
    public SpanEvent map(SpanEvent spanEvent) {
        Intrinsics.checkNotNullParameter(spanEvent, "event");
        return spanEvent;
    }
}
