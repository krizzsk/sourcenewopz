package com.datadog.android.tracing.internal.domain.event;

import com.datadog.android.core.internal.constraints.DataConstraints;
import com.datadog.android.core.internal.constraints.DatadogDataConstraints;
import com.datadog.android.core.internal.persistence.Serializer;
import com.datadog.android.core.internal.utils.MapUtilsKt;
import com.datadog.android.tracing.model.SpanEvent;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/datadog/android/tracing/internal/domain/event/SpanEventSerializer;", "Lcom/datadog/android/core/internal/persistence/Serializer;", "Lcom/datadog/android/tracing/model/SpanEvent;", "envName", "", "dataConstraints", "Lcom/datadog/android/core/internal/constraints/DataConstraints;", "(Ljava/lang/String;Lcom/datadog/android/core/internal/constraints/DataConstraints;)V", "sanitizeKeys", "model", "sanitizeMetrics", "Lcom/datadog/android/tracing/model/SpanEvent$Metrics;", "metrics", "sanitizeUserAttributes", "Lcom/datadog/android/tracing/model/SpanEvent$Usr;", "usr", "serialize", "toMetaString", "element", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SpanEventSerializer.kt */
public final class SpanEventSerializer implements Serializer<SpanEvent> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String META_USR_KEY_PREFIX = "meta.usr";
    public static final String METRICS_KEY_PREFIX = "metrics";
    public static final String TAG_ENV = "env";
    public static final String TAG_SPANS = "spans";

    /* renamed from: a */
    private final String f4056a;

    /* renamed from: b */
    private final DataConstraints f4057b;

    public SpanEventSerializer(String str, DataConstraints dataConstraints) {
        Intrinsics.checkNotNullParameter(str, "envName");
        Intrinsics.checkNotNullParameter(dataConstraints, "dataConstraints");
        this.f4056a = str;
        this.f4057b = dataConstraints;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpanEventSerializer(String str, DataConstraints dataConstraints, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new DatadogDataConstraints() : dataConstraints);
    }

    public String serialize(SpanEvent spanEvent) {
        Intrinsics.checkNotNullParameter(spanEvent, "model");
        JsonElement json = m2546a(spanEvent).toJson();
        JsonArray jsonArray = new JsonArray(1);
        jsonArray.add(json);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(TAG_SPANS, jsonArray);
        jsonObject.addProperty("env", this.f4056a);
        String jsonObject2 = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jsonObject2, "jsonObject.toString()");
        return jsonObject2;
    }

    /* renamed from: a */
    private final SpanEvent m2546a(SpanEvent spanEvent) {
        return SpanEvent.copy$default(spanEvent, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, 0, m2544a(spanEvent.getMetrics()), SpanEvent.Meta.copy$default(spanEvent.getMeta(), (String) null, (SpanEvent.C2211Dd) null, (SpanEvent.Span) null, (SpanEvent.Tracer) null, m2545a(spanEvent.getMeta().getUsr()), (SpanEvent.Network) null, (Map) null, 111, (Object) null), 511, (Object) null);
    }

    /* renamed from: a */
    private final SpanEvent.Usr m2545a(SpanEvent.Usr usr) {
        Map validateAttributes$default = DataConstraints.DefaultImpls.validateAttributes$default(this.f4057b, usr.getAdditionalProperties(), META_USR_KEY_PREFIX, (String) null, (Set) null, 12, (Object) null);
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(validateAttributes$default.size()));
        for (Map.Entry entry : validateAttributes$default.entrySet()) {
            linkedHashMap.put(entry.getKey(), m2547a(entry.getValue()));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (((String) entry2.getValue()) != null) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return SpanEvent.Usr.copy$default(usr, (String) null, (String) null, (String) null, linkedHashMap2, 7, (Object) null);
    }

    /* renamed from: a */
    private final SpanEvent.Metrics m2544a(SpanEvent.Metrics metrics) {
        return SpanEvent.Metrics.copy$default(metrics, (Long) null, DataConstraints.DefaultImpls.validateAttributes$default(this.f4057b, metrics.getAdditionalProperties(), METRICS_KEY_PREFIX, (String) null, (Set) null, 12, (Object) null), 1, (Object) null);
    }

    /* renamed from: a */
    private final String m2547a(Object obj) {
        if (Intrinsics.areEqual(obj, MapUtilsKt.getNULL_MAP_VALUE()) || obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return String.valueOf(((Date) obj).getTime());
        }
        if (obj instanceof JsonPrimitive) {
            return ((JsonPrimitive) obj).getAsString();
        }
        return obj.toString();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/datadog/android/tracing/internal/domain/event/SpanEventSerializer$Companion;", "", "()V", "META_USR_KEY_PREFIX", "", "METRICS_KEY_PREFIX", "TAG_ENV", "TAG_SPANS", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SpanEventSerializer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
