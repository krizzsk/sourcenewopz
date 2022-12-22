package com.datadog.android.tracing.internal.domain.event;

import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.event.EventMapper;
import com.datadog.android.event.SpanEventMapper;
import com.datadog.android.log.Logger;
import com.datadog.android.tracing.model.SpanEvent;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/datadog/android/tracing/internal/domain/event/SpanEventMapperWrapper;", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/tracing/model/SpanEvent;", "wrappedEventMapper", "Lcom/datadog/android/event/SpanEventMapper;", "(Lcom/datadog/android/event/SpanEventMapper;)V", "map", "event", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SpanEventMapperWrapper.kt */
public final class SpanEventMapperWrapper implements EventMapper<SpanEvent> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NOT_SAME_EVENT_INSTANCE_WARNING_MESSAGE = "SpanEventMapper: the returned mapped object was not the same instance as the original object. This event will be dropped: %s";

    /* renamed from: a */
    private final SpanEventMapper f4055a;

    public SpanEventMapperWrapper(SpanEventMapper spanEventMapper) {
        Intrinsics.checkNotNullParameter(spanEventMapper, "wrappedEventMapper");
        this.f4055a = spanEventMapper;
    }

    public SpanEvent map(SpanEvent spanEvent) {
        Intrinsics.checkNotNullParameter(spanEvent, "event");
        SpanEvent map = this.f4055a.map(spanEvent);
        if (map == spanEvent) {
            return map;
        }
        Logger devLogger = RuntimeUtilsKt.getDevLogger();
        String format = String.format(Locale.US, NOT_SAME_EVENT_INSTANCE_WARNING_MESSAGE, Arrays.copyOf(new Object[]{spanEvent}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
        Logger.w$default(devLogger, format, (Throwable) null, (Map) null, 6, (Object) null);
        return null;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/datadog/android/tracing/internal/domain/event/SpanEventMapperWrapper$Companion;", "", "()V", "NOT_SAME_EVENT_INSTANCE_WARNING_MESSAGE", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SpanEventMapperWrapper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
