package com.datadog.android.event;

import com.datadog.android.core.internal.persistence.Serializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/datadog/android/event/MapperSerializer;", "T", "", "Lcom/datadog/android/core/internal/persistence/Serializer;", "eventMapper", "Lcom/datadog/android/event/EventMapper;", "serializer", "(Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/core/internal/persistence/Serializer;)V", "serialize", "", "model", "(Ljava/lang/Object;)Ljava/lang/String;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MapperSerializer.kt */
public final class MapperSerializer<T> implements Serializer<T> {

    /* renamed from: a */
    private final EventMapper<T> f3608a;

    /* renamed from: b */
    private final Serializer<T> f3609b;

    public MapperSerializer(EventMapper<T> eventMapper, Serializer<T> serializer) {
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.f3608a = eventMapper;
        this.f3609b = serializer;
    }

    public String serialize(T t) {
        Intrinsics.checkNotNullParameter(t, "model");
        T map = this.f3608a.map(t);
        if (map == null) {
            return null;
        }
        return this.f3609b.serialize(map);
    }
}
