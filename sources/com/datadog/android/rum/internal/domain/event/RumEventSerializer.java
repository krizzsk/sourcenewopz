package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.core.internal.constraints.DataConstraints;
import com.datadog.android.core.internal.constraints.DatadogDataConstraints;
import com.datadog.android.core.internal.persistence.Serializer;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0015H\u0002J,\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0017H\u0002J,\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/event/RumEventSerializer;", "Lcom/datadog/android/core/internal/persistence/Serializer;", "", "dataConstraints", "Lcom/datadog/android/core/internal/constraints/DataConstraints;", "(Lcom/datadog/android/core/internal/constraints/DataConstraints;)V", "extractKnownAttributes", "Lcom/google/gson/JsonObject;", "jsonObject", "serialize", "", "model", "serializeActionEvent", "Lcom/datadog/android/rum/model/ActionEvent;", "serializeErrorEvent", "Lcom/datadog/android/rum/model/ErrorEvent;", "serializeLongTaskEvent", "Lcom/datadog/android/rum/model/LongTaskEvent;", "serializeResourceEvent", "Lcom/datadog/android/rum/model/ResourceEvent;", "serializeViewEvent", "Lcom/datadog/android/rum/model/ViewEvent;", "validateContextAttributes", "", "attributes", "validateUserAttributes", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumEventSerializer.kt */
public final class RumEventSerializer implements Serializer<Object> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String GLOBAL_ATTRIBUTE_PREFIX = "context";
    public static final String USER_ATTRIBUTE_PREFIX = "usr";
    public static final String USER_EXTRA_GROUP_VERBOSE_NAME = "user extra information";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Set<String> f3712b = SetsKt.setOf(RumAttributes.ACTION_GESTURE_DIRECTION, RumAttributes.ACTION_TARGET_PARENT_RESOURCE_ID, RumAttributes.ACTION_TARGET_PARENT_CLASSNAME, RumAttributes.ACTION_TARGET_PARENT_INDEX, RumAttributes.ACTION_TARGET_CLASS_NAME, RumAttributes.ACTION_TARGET_RESOURCE_ID, RumAttributes.ACTION_TARGET_TITLE, RumAttributes.ERROR_RESOURCE_METHOD, RumAttributes.ERROR_RESOURCE_STATUS_CODE, RumAttributes.ERROR_RESOURCE_URL);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Set<String> f3713c = SetsKt.setOf(RumAttributes.INTERNAL_TIMESTAMP, RumAttributes.INTERNAL_ERROR_TYPE, RumAttributes.INTERNAL_ERROR_SOURCE_TYPE, RumAttributes.INTERNAL_ERROR_IS_CRASH);

    /* renamed from: a */
    private final DataConstraints f3714a;

    public RumEventSerializer() {
        this((DataConstraints) null, 1, (DefaultConstructorMarker) null);
    }

    public RumEventSerializer(DataConstraints dataConstraints) {
        Intrinsics.checkNotNullParameter(dataConstraints, "dataConstraints");
        this.f3714a = dataConstraints;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RumEventSerializer(DataConstraints dataConstraints, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DatadogDataConstraints() : dataConstraints);
    }

    public String serialize(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "model");
        if (obj instanceof ViewEvent) {
            return m2421a((ViewEvent) obj);
        }
        if (obj instanceof ErrorEvent) {
            return m2418a((ErrorEvent) obj);
        }
        if (obj instanceof ActionEvent) {
            return m2417a((ActionEvent) obj);
        }
        if (obj instanceof ResourceEvent) {
            return m2420a((ResourceEvent) obj);
        }
        if (obj instanceof LongTaskEvent) {
            return m2419a((LongTaskEvent) obj);
        }
        String jsonObject = new JsonObject().toString();
        Intrinsics.checkNotNullExpressionValue(jsonObject, "{\n                JsonObject().toString()\n            }");
        return jsonObject;
    }

    /* renamed from: a */
    private final String m2421a(ViewEvent viewEvent) {
        ViewEvent.Usr usr = viewEvent.getUsr();
        ViewEvent.CustomTimings customTimings = null;
        ViewEvent.Usr copy$default = usr == null ? null : ViewEvent.Usr.copy$default(usr, (String) null, (String) null, (String) null, m2423b(viewEvent.getUsr().getAdditionalProperties()), 7, (Object) null);
        ViewEvent.Context context = viewEvent.getContext();
        ViewEvent.Context copy = context == null ? null : context.copy(m2422a((Map<String, ? extends Object>) viewEvent.getContext().getAdditionalProperties()));
        ViewEvent.View view = viewEvent.getView();
        ViewEvent.CustomTimings customTimings2 = viewEvent.getView().getCustomTimings();
        if (customTimings2 != null) {
            customTimings = customTimings2.copy(this.f3714a.validateTimings(viewEvent.getView().getCustomTimings().getAdditionalProperties()));
        }
        JsonObject asJsonObject = ViewEvent.copy$default(viewEvent, 0, (ViewEvent.Application) null, (String) null, (ViewEvent.ViewEventSession) null, ViewEvent.View.copy$default(view, (String) null, (String) null, (String) null, (String) null, (Long) null, (ViewEvent.LoadingType) null, 0, (Long) null, (Long) null, (Long) null, (Long) null, (Number) null, (Long) null, (Long) null, (Long) null, (Long) null, customTimings, (Boolean) null, (Boolean) null, (ViewEvent.Action) null, (ViewEvent.Error) null, (ViewEvent.Crash) null, (ViewEvent.LongTask) null, (ViewEvent.FrozenFrame) null, (ViewEvent.Resource) null, (List) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null, -65537, (Object) null), copy$default, (ViewEvent.Connectivity) null, (ViewEvent.Synthetics) null, (ViewEvent.C2205Dd) null, copy, 463, (Object) null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String jsonObject = m2416a(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(jsonObject, "extractKnownAttributes(sanitizedModel.toJson().asJsonObject).toString()");
        return jsonObject;
    }

    /* renamed from: a */
    private final String m2418a(ErrorEvent errorEvent) {
        ErrorEvent.Usr usr = errorEvent.getUsr();
        ErrorEvent.Context context = null;
        ErrorEvent.Usr copy$default = usr == null ? null : ErrorEvent.Usr.copy$default(usr, (String) null, (String) null, (String) null, m2423b(errorEvent.getUsr().getAdditionalProperties()), 7, (Object) null);
        ErrorEvent.Context context2 = errorEvent.getContext();
        if (context2 != null) {
            context = context2.copy(m2422a((Map<String, ? extends Object>) errorEvent.getContext().getAdditionalProperties()));
        }
        JsonObject asJsonObject = ErrorEvent.copy$default(errorEvent, 0, (ErrorEvent.Application) null, (String) null, (ErrorEvent.ErrorEventSession) null, (ErrorEvent.View) null, copy$default, (ErrorEvent.Connectivity) null, (ErrorEvent.Synthetics) null, (ErrorEvent.C2202Dd) null, context, (ErrorEvent.Error) null, (ErrorEvent.Action) null, 3551, (Object) null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String jsonObject = m2416a(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(jsonObject, "extractKnownAttributes(sanitizedModel.toJson().asJsonObject).toString()");
        return jsonObject;
    }

    /* renamed from: a */
    private final String m2420a(ResourceEvent resourceEvent) {
        ResourceEvent.Usr usr = resourceEvent.getUsr();
        ResourceEvent.Context context = null;
        ResourceEvent.Usr copy$default = usr == null ? null : ResourceEvent.Usr.copy$default(usr, (String) null, (String) null, (String) null, m2423b(resourceEvent.getUsr().getAdditionalProperties()), 7, (Object) null);
        ResourceEvent.Context context2 = resourceEvent.getContext();
        if (context2 != null) {
            context = context2.copy(m2422a((Map<String, ? extends Object>) resourceEvent.getContext().getAdditionalProperties()));
        }
        JsonObject asJsonObject = ResourceEvent.copy$default(resourceEvent, 0, (ResourceEvent.Application) null, (String) null, (ResourceEvent.ResourceEventSession) null, (ResourceEvent.View) null, copy$default, (ResourceEvent.Connectivity) null, (ResourceEvent.Synthetics) null, (ResourceEvent.C2204Dd) null, context, (ResourceEvent.Resource) null, (ResourceEvent.Action) null, 3551, (Object) null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String jsonObject = m2416a(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(jsonObject, "extractKnownAttributes(sanitizedModel.toJson().asJsonObject).toString()");
        return jsonObject;
    }

    /* renamed from: a */
    private final String m2417a(ActionEvent actionEvent) {
        ActionEvent.Usr usr = actionEvent.getUsr();
        ActionEvent.Context context = null;
        ActionEvent.Usr copy$default = usr == null ? null : ActionEvent.Usr.copy$default(usr, (String) null, (String) null, (String) null, m2423b(actionEvent.getUsr().getAdditionalProperties()), 7, (Object) null);
        ActionEvent.Context context2 = actionEvent.getContext();
        if (context2 != null) {
            context = context2.copy(m2422a((Map<String, ? extends Object>) actionEvent.getContext().getAdditionalProperties()));
        }
        JsonObject asJsonObject = ActionEvent.copy$default(actionEvent, 0, (ActionEvent.Application) null, (String) null, (ActionEvent.ActionEventSession) null, (ActionEvent.View) null, copy$default, (ActionEvent.Connectivity) null, (ActionEvent.Synthetics) null, (ActionEvent.C2201Dd) null, context, (ActionEvent.Action) null, 1503, (Object) null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String jsonObject = m2416a(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(jsonObject, "extractKnownAttributes(sanitizedModel.toJson().asJsonObject).toString()");
        return jsonObject;
    }

    /* renamed from: a */
    private final String m2419a(LongTaskEvent longTaskEvent) {
        LongTaskEvent.Usr usr = longTaskEvent.getUsr();
        LongTaskEvent.Context context = null;
        LongTaskEvent.Usr copy$default = usr == null ? null : LongTaskEvent.Usr.copy$default(usr, (String) null, (String) null, (String) null, m2423b(longTaskEvent.getUsr().getAdditionalProperties()), 7, (Object) null);
        LongTaskEvent.Context context2 = longTaskEvent.getContext();
        if (context2 != null) {
            context = context2.copy(m2422a((Map<String, ? extends Object>) longTaskEvent.getContext().getAdditionalProperties()));
        }
        JsonObject asJsonObject = LongTaskEvent.copy$default(longTaskEvent, 0, (LongTaskEvent.Application) null, (String) null, (LongTaskEvent.LongTaskEventSession) null, (LongTaskEvent.View) null, copy$default, (LongTaskEvent.Connectivity) null, (LongTaskEvent.Synthetics) null, (LongTaskEvent.C2203Dd) null, context, (LongTaskEvent.LongTask) null, (LongTaskEvent.Action) null, 3551, (Object) null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String jsonObject = m2416a(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(jsonObject, "extractKnownAttributes(sanitizedModel.toJson().asJsonObject).toString()");
        return jsonObject;
    }

    /* renamed from: a */
    private final Map<String, Object> m2422a(Map<String, ? extends Object> map) {
        return DataConstraints.DefaultImpls.validateAttributes$default(this.f3714a, map, "context", (String) null, f3713c, 4, (Object) null);
    }

    /* renamed from: b */
    private final Map<String, Object> m2423b(Map<String, ? extends Object> map) {
        return this.f3714a.validateAttributes(map, "usr", "user extra information", f3713c);
    }

    /* renamed from: a */
    private final JsonObject m2416a(JsonObject jsonObject) {
        if (jsonObject.has("context")) {
            JsonObject asJsonObject = jsonObject.getAsJsonObject("context");
            Set<Map.Entry<String, JsonElement>> entrySet = asJsonObject.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "contextObject\n                .entrySet()");
            Collection arrayList = new ArrayList();
            for (Object next : entrySet) {
                if (f3712b.contains(((Map.Entry) next).getKey())) {
                    arrayList.add(next);
                }
            }
            for (Map.Entry entry : (List) arrayList) {
                asJsonObject.remove((String) entry.getKey());
                jsonObject.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }
        return jsonObject;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/event/RumEventSerializer$Companion;", "", "()V", "GLOBAL_ATTRIBUTE_PREFIX", "", "USER_ATTRIBUTE_PREFIX", "USER_EXTRA_GROUP_VERBOSE_NAME", "ignoredAttributes", "", "getIgnoredAttributes$dd_sdk_android_release", "()Ljava/util/Set;", "knownAttributes", "getKnownAttributes$dd_sdk_android_release", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RumEventSerializer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getKnownAttributes$dd_sdk_android_release() {
            return RumEventSerializer.f3712b;
        }

        public final Set<String> getIgnoredAttributes$dd_sdk_android_release() {
            return RumEventSerializer.f3713c;
        }
    }
}
