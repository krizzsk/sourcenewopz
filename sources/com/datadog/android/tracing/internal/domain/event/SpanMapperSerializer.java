package com.datadog.android.tracing.internal.domain.event;

import com.datadog.android.core.internal.Mapper;
import com.datadog.android.core.internal.persistence.Serializer;
import com.datadog.android.event.EventMapper;
import com.datadog.android.tracing.model.SpanEvent;
import com.datadog.opentracing.DDSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/datadog/android/tracing/internal/domain/event/SpanMapperSerializer;", "Lcom/datadog/android/core/internal/persistence/Serializer;", "Lcom/datadog/opentracing/DDSpan;", "legacyMapper", "Lcom/datadog/android/core/internal/Mapper;", "Lcom/datadog/android/tracing/model/SpanEvent;", "spanEventMapper", "Lcom/datadog/android/event/EventMapper;", "spanSerializer", "(Lcom/datadog/android/core/internal/Mapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/core/internal/persistence/Serializer;)V", "serialize", "", "model", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SpanMapperSerializer.kt */
public final class SpanMapperSerializer implements Serializer<DDSpan> {

    /* renamed from: a */
    private final Mapper<DDSpan, SpanEvent> f4058a;

    /* renamed from: b */
    private final EventMapper<SpanEvent> f4059b;

    /* renamed from: c */
    private final Serializer<SpanEvent> f4060c;

    public SpanMapperSerializer(Mapper<DDSpan, SpanEvent> mapper, EventMapper<SpanEvent> eventMapper, Serializer<SpanEvent> serializer) {
        Intrinsics.checkNotNullParameter(mapper, "legacyMapper");
        Intrinsics.checkNotNullParameter(eventMapper, "spanEventMapper");
        Intrinsics.checkNotNullParameter(serializer, "spanSerializer");
        this.f4058a = mapper;
        this.f4059b = eventMapper;
        this.f4060c = serializer;
    }

    public String serialize(DDSpan dDSpan) {
        Intrinsics.checkNotNullParameter(dDSpan, "model");
        SpanEvent map = this.f4059b.map(this.f4058a.map(dDSpan));
        if (map == null) {
            return null;
        }
        return this.f4060c.serialize(map);
    }
}
