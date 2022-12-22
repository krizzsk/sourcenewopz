package com.didiglobal.travel.infra.serialization;

import com.google.gson.JsonArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\r2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u000f*\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/serialization/JsonArrayAssembler;", "T", "", "json", "Lcom/google/gson/JsonArray;", "constructor-impl", "(Lcom/google/gson/JsonArray;)Lcom/google/gson/JsonArray;", "equals", "", "other", "hashCode", "", "toString", "", "element", "", "value", "element-impl", "(Lcom/google/gson/JsonArray;Ljava/lang/String;Ljava/lang/Object;)V", "elementNotNull", "elementNotNull-impl", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
@JsonDslMarker
/* compiled from: Gson.kt */
public final class JsonArrayAssembler<T> {

    /* renamed from: a */
    private final JsonArray f51440a;

    /* renamed from: constructor-impl  reason: not valid java name */
    public static JsonArray m47138constructorimpl(JsonArray jsonArray) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "json");
        return jsonArray;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47141equalsimpl(JsonArray jsonArray, Object obj) {
        return (obj instanceof JsonArrayAssembler) && Intrinsics.areEqual((Object) jsonArray, (Object) ((JsonArrayAssembler) obj).m47145unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47142equalsimpl0(JsonArray jsonArray, JsonArray jsonArray2) {
        return Intrinsics.areEqual((Object) jsonArray, (Object) jsonArray2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47143hashCodeimpl(JsonArray jsonArray) {
        if (jsonArray != null) {
            return jsonArray.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47144toStringimpl(JsonArray jsonArray) {
        return "JsonArrayAssembler(json=" + jsonArray + ")";
    }

    public boolean equals(Object obj) {
        return m47141equalsimpl(this.f51440a, obj);
    }

    public int hashCode() {
        return m47143hashCodeimpl(this.f51440a);
    }

    public String toString() {
        return m47144toStringimpl(this.f51440a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ JsonArray m47145unboximpl() {
        return this.f51440a;
    }

    private /* synthetic */ JsonArrayAssembler(JsonArray jsonArray) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "json");
        this.f51440a = jsonArray;
    }

    /* renamed from: element-impl  reason: not valid java name */
    public static final void m47139elementimpl(JsonArray jsonArray, String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "$this$element");
        GsonKt.plus(jsonArray, t);
    }

    /* renamed from: elementNotNull-impl  reason: not valid java name */
    public static final void m47140elementNotNullimpl(JsonArray jsonArray, String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "$this$elementNotNull");
        if (t != null) {
            GsonKt.plus(jsonArray, t);
        }
    }
}
