package com.didiglobal.travel.infra.serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import global.didi.pay.newview.pix.IPixView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J<\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f*\u00020\f2\u001d\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0013H\u0004ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\u000e*\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u0016\u001a\u00020\u000e*\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0004¢\u0006\u0004\b\u0019\u0010\u001cJ\u001c\u0010\u0016\u001a\u00020\u000e*\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001dH\u0004¢\u0006\u0004\b\u0019\u0010\u001eJ\u001c\u0010\u0016\u001a\u00020\u000e*\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001fH\u0004¢\u0006\u0004\b\u0019\u0010 J\u001c\u0010\u0016\u001a\u00020\u000e*\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0004¢\u0006\u0004\b\u0019\u0010!J\u001e\u0010\"\u001a\u00020\u000e*\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0004¢\u0006\u0004\b#\u0010\u001aJ\u001e\u0010\"\u001a\u00020\u000e*\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0004¢\u0006\u0004\b#\u0010\u001cJ\u001e\u0010\"\u001a\u00020\u000e*\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001dH\u0004¢\u0006\u0004\b#\u0010$J\u001e\u0010\"\u001a\u00020\u000e*\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001fH\u0004¢\u0006\u0004\b#\u0010 J\u001e\u0010\"\u001a\u00020\u000e*\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0004¢\u0006\u0004\b#\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/serialization/JsonObjectAssembler;", "", "json", "Lcom/google/gson/JsonObject;", "constructor-impl", "(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", "equals", "", "other", "hashCode", "", "toString", "", "array", "", "T", "init", "Lkotlin/Function1;", "Lcom/didiglobal/travel/infra/serialization/JsonArrayAssembler;", "Lkotlin/ExtensionFunctionType;", "array-impl", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "to", "obj", "Lcom/google/gson/JsonElement;", "to-impl", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Lcom/google/gson/JsonElement;)V", "value", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Boolean;)V", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;C)V", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Number;)V", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)V", "toNonNull", "toNonNull-impl", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Character;)V", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
@JsonDslMarker
/* compiled from: Gson.kt */
public final class JsonObjectAssembler {

    /* renamed from: a */
    private final JsonObject f51441a;

    /* renamed from: array-impl  reason: not valid java name */
    public static final <T> void m47146arrayimpl(JsonObject jsonObject, String str, Function1<? super JsonArrayAssembler<T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "$this$array");
        Intrinsics.checkParameterIsNotNull(function1, IPixView.PAGE_STATUS_INIT);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static JsonObject m47148constructorimpl(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "json");
        return jsonObject;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47149equalsimpl(JsonObject jsonObject, Object obj) {
        return (obj instanceof JsonObjectAssembler) && Intrinsics.areEqual((Object) jsonObject, (Object) ((JsonObjectAssembler) obj).m47163unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47150equalsimpl0(JsonObject jsonObject, JsonObject jsonObject2) {
        return Intrinsics.areEqual((Object) jsonObject, (Object) jsonObject2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47151hashCodeimpl(JsonObject jsonObject) {
        if (jsonObject != null) {
            return jsonObject.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47162toStringimpl(JsonObject jsonObject) {
        return "JsonObjectAssembler(json=" + jsonObject + ")";
    }

    public boolean equals(Object obj) {
        return m47149equalsimpl(this.f51441a, obj);
    }

    public int hashCode() {
        return m47151hashCodeimpl(this.f51441a);
    }

    public String toString() {
        return m47162toStringimpl(this.f51441a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ JsonObject m47163unboximpl() {
        return this.f51441a;
    }

    private /* synthetic */ JsonObjectAssembler(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "json");
        this.f51441a = jsonObject;
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final void m47154toimpl(JsonObject jsonObject, String str, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            jsonObject.addProperty((String) charSequence, Boolean.valueOf(Intrinsics.areEqual((Object) bool, (Object) true)));
        }
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final void m47152toimpl(JsonObject jsonObject, String str, char c) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            jsonObject.addProperty((String) charSequence, Character.valueOf(c));
        }
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final void m47155toimpl(JsonObject jsonObject, String str, Number number) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        Intrinsics.checkParameterIsNotNull(number, "value");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            jsonObject.addProperty((String) charSequence, number);
        }
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final void m47156toimpl(JsonObject jsonObject, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            jsonObject.addProperty((String) charSequence, str2);
        }
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final void m47153toimpl(JsonObject jsonObject, String str, JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        Intrinsics.checkParameterIsNotNull(jsonElement, "obj");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            jsonObject.add((String) charSequence, jsonElement);
        }
    }

    /* renamed from: toNonNull-impl  reason: not valid java name */
    public static final void m47158toNonNullimpl(JsonObject jsonObject, String str, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toNonNull");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            String str2 = (String) charSequence;
            if (bool != null) {
                jsonObject.addProperty(str, Boolean.valueOf(bool.booleanValue()));
            }
        }
    }

    /* renamed from: toNonNull-impl  reason: not valid java name */
    public static final void m47159toNonNullimpl(JsonObject jsonObject, String str, Character ch) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toNonNull");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            String str2 = (String) charSequence;
            if (ch != null) {
                jsonObject.addProperty(str2, Character.valueOf(ch.charValue()));
            }
        }
    }

    /* renamed from: toNonNull-impl  reason: not valid java name */
    public static final void m47160toNonNullimpl(JsonObject jsonObject, String str, Number number) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toNonNull");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            String str2 = (String) charSequence;
            if (number != null) {
                jsonObject.addProperty(str2, number);
            }
        }
    }

    /* renamed from: toNonNull-impl  reason: not valid java name */
    public static final void m47161toNonNullimpl(JsonObject jsonObject, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toNonNull");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            String str3 = (String) charSequence;
            if (str2 != null) {
                jsonObject.addProperty(str3, str2);
            }
        }
    }

    /* renamed from: toNonNull-impl  reason: not valid java name */
    public static final void m47157toNonNullimpl(JsonObject jsonObject, String str, JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toNonNull");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            String str2 = (String) charSequence;
            if (jsonElement != null) {
                jsonObject.add(str, jsonElement);
            }
        }
    }
}
