package com.didiglobal.travel.infra.serialization;

import com.didi.raven.config.RavenKey;
import global.didi.pay.newview.pix.IPixView;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J9\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f*\u00020\f2\u001d\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0013ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J6\u0010\u0016\u001a\u00020\u000e*\u00020\f2\u001d\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0012\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0013H\u0004ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0015J6\u0010\u0018\u001a\u00020\u000e*\u00020\f2\u001d\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0012\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0013H\u0004ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0015J\u001e\u0010\u001a\u001a\u00020\u000e*\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ6\u0010\u001e\u001a\u00020\u000e*\u00020\f2\u001d\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0012\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0013H\u0004ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0015J6\u0010 \u001a\u00020\u000e*\u00020\f2\u001d\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0012\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0013H\u0004ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0015J6\u0010#\u001a\u00020\u000e*\u00020\f2\u001d\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0013H\u0004ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0015J\u001f\u0010%\u001a\u00020\u000e*\u00020\f2\u0006\u0010&\u001a\u00020'H\u0004ø\u0001\u0000¢\u0006\u0004\b(\u0010)J*\u0010%\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f*\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010*H\u0004¢\u0006\u0004\b+\u0010,J\u001e\u0010%\u001a\u00020\u000e*\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0004¢\u0006\u0004\b+\u0010-J\u001e\u0010%\u001a\u00020\u000e*\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010.H\u0004¢\u0006\u0004\b+\u0010/J\u001e\u0010%\u001a\u00020\u000e*\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0004¢\u0006\u0004\b+\u0010\u001dJ*\u0010%\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f*\u00020\f2\u000e\u00100\u001a\n\u0012\u0004\u0012\u0002H\u000f\u0018\u000101H\u0004¢\u0006\u0004\b+\u00102J\u001c\u0010%\u001a\u00020\u000e*\u00020\f2\u0006\u0010\r\u001a\u000203H\u0004¢\u0006\u0004\b+\u00104J\u001e\u0010%\u001a\u00020\u000e*\u00020\f2\b\u00105\u001a\u0004\u0018\u00010\u0003H\u0004¢\u0006\u0004\b+\u00106R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u00067"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/serialization/JSONCreator;", "", "json", "Lorg/json/JSONObject;", "constructor-impl", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "equals", "", "other", "hashCode", "", "toString", "", "array", "", "T", "init", "Lkotlin/Function1;", "Lcom/didiglobal/travel/infra/serialization/JSONArrayCreator;", "Lkotlin/ExtensionFunctionType;", "array-impl", "(Lorg/json/JSONObject;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "boolArray", "boolArray-impl", "doubleArray", "doubleArray-impl", "indeed", "value", "indeed-impl", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V", "intArray", "intArray-impl", "longArray", "", "longArray-impl", "stringArray", "stringArray-impl", "to", "time", "Lcom/didiglobal/travel/infra/time/Timestamp;", "to-NRZ-4eQ", "(Lorg/json/JSONObject;Ljava/lang/String;J)V", "", "to-impl", "(Lorg/json/JSONObject;Ljava/lang/String;[Ljava/lang/Object;)V", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Boolean;)V", "", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Number;)V", "collection", "", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/Collection;)V", "Lorg/json/JSONArray;", "(Lorg/json/JSONObject;Ljava/lang/String;Lorg/json/JSONArray;)V", "jsonObj", "(Lorg/json/JSONObject;Ljava/lang/String;Lorg/json/JSONObject;)V", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
@JsonDslMarker
/* compiled from: JSON.kt */
public final class JSONCreator {

    /* renamed from: a */
    private final JSONObject f51439a;

    /* renamed from: constructor-impl  reason: not valid java name */
    public static JSONObject m47118constructorimpl(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "json");
        return jSONObject;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47120equalsimpl(JSONObject jSONObject, Object obj) {
        return (obj instanceof JSONCreator) && Intrinsics.areEqual((Object) jSONObject, (Object) ((JSONCreator) obj).m47136unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47121equalsimpl0(JSONObject jSONObject, JSONObject jSONObject2) {
        return Intrinsics.areEqual((Object) jSONObject, (Object) jSONObject2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47122hashCodeimpl(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47135toStringimpl(JSONObject jSONObject) {
        return "JSONCreator(json=" + jSONObject + ")";
    }

    public boolean equals(Object obj) {
        return m47120equalsimpl(this.f51439a, obj);
    }

    public int hashCode() {
        return m47122hashCodeimpl(this.f51439a);
    }

    public String toString() {
        return m47135toStringimpl(this.f51439a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ JSONObject m47136unboximpl() {
        return this.f51439a;
    }

    private /* synthetic */ JSONCreator(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "json");
        this.f51439a = jSONObject;
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final void m47128toimpl(JSONObject jSONObject, String str, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            jSONObject.putOpt((String) charSequence, bool);
        }
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final void m47129toimpl(JSONObject jSONObject, String str, Number number) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            jSONObject.putOpt((String) charSequence, number);
        }
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final void m47130toimpl(JSONObject jSONObject, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            jSONObject.putOpt((String) charSequence, str2);
        }
    }

    /* renamed from: to-NRZ-4eQ  reason: not valid java name */
    public static final void m47127toNRZ4eQ(JSONObject jSONObject, String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            jSONObject.put((String) charSequence, j);
        }
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final void m47133toimpl(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            jSONObject.putOpt((String) charSequence, jSONObject2);
        }
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final void m47132toimpl(JSONObject jSONObject, String str, JSONArray jSONArray) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        Intrinsics.checkParameterIsNotNull(jSONArray, "array");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            jSONObject.putOpt((String) charSequence, jSONArray);
        }
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final <T> void m47134toimpl(JSONObject jSONObject, String str, T[] tArr) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        CharSequence charSequence = str;
        JSONArray jSONArray = null;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            String str2 = (String) charSequence;
            if (tArr != null) {
                jSONArray = JSONKt.toJSON(tArr);
            }
            jSONObject.putOpt(str2, jSONArray);
        }
    }

    /* renamed from: to-impl  reason: not valid java name */
    public static final <T> void m47131toimpl(JSONObject jSONObject, String str, Collection<? extends T> collection) {
        Intrinsics.checkParameterIsNotNull(str, "$this$to");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            String str2 = (String) charSequence;
            if (collection != null) {
                if (!(!collection.isEmpty())) {
                    collection = null;
                }
                if (collection != null) {
                    jSONObject.putOpt(str2, JSONKt.toJSON(collection));
                }
            }
        }
    }

    /* renamed from: indeed-impl  reason: not valid java name */
    public static final void m47123indeedimpl(JSONObject jSONObject, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$indeed");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            String str3 = (String) charSequence;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put(str3, str2);
        }
    }

    /* renamed from: boolArray-impl  reason: not valid java name */
    public static final void m47116boolArrayimpl(JSONObject jSONObject, String str, Function1<? super JSONArrayCreator<Boolean>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "$this$boolArray");
        Intrinsics.checkParameterIsNotNull(function1, IPixView.PAGE_STATUS_INIT);
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            JSONArray jSONArray = new JSONArray();
            function1.invoke(Intrinsics.checkParameterIsNotNull(JSONArrayCreator.m47107constructorimpl(jSONArray), RavenKey.VERSION));
            jSONObject.putOpt((String) charSequence, jSONArray);
        }
    }

    /* renamed from: intArray-impl  reason: not valid java name */
    public static final void m47124intArrayimpl(JSONObject jSONObject, String str, Function1<? super JSONArrayCreator<Integer>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "$this$intArray");
        Intrinsics.checkParameterIsNotNull(function1, IPixView.PAGE_STATUS_INIT);
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            JSONArray jSONArray = new JSONArray();
            function1.invoke(Intrinsics.checkParameterIsNotNull(JSONArrayCreator.m47107constructorimpl(jSONArray), RavenKey.VERSION));
            jSONObject.putOpt((String) charSequence, jSONArray);
        }
    }

    /* renamed from: longArray-impl  reason: not valid java name */
    public static final void m47125longArrayimpl(JSONObject jSONObject, String str, Function1<? super JSONArrayCreator<Long>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "$this$longArray");
        Intrinsics.checkParameterIsNotNull(function1, IPixView.PAGE_STATUS_INIT);
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            JSONArray jSONArray = new JSONArray();
            function1.invoke(Intrinsics.checkParameterIsNotNull(JSONArrayCreator.m47107constructorimpl(jSONArray), RavenKey.VERSION));
            jSONObject.putOpt((String) charSequence, jSONArray);
        }
    }

    /* renamed from: doubleArray-impl  reason: not valid java name */
    public static final void m47119doubleArrayimpl(JSONObject jSONObject, String str, Function1<? super JSONArrayCreator<Integer>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "$this$doubleArray");
        Intrinsics.checkParameterIsNotNull(function1, IPixView.PAGE_STATUS_INIT);
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            JSONArray jSONArray = new JSONArray();
            function1.invoke(Intrinsics.checkParameterIsNotNull(JSONArrayCreator.m47107constructorimpl(jSONArray), RavenKey.VERSION));
            jSONObject.putOpt((String) charSequence, jSONArray);
        }
    }

    /* renamed from: stringArray-impl  reason: not valid java name */
    public static final void m47126stringArrayimpl(JSONObject jSONObject, String str, Function1<? super JSONArrayCreator<String>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "$this$stringArray");
        Intrinsics.checkParameterIsNotNull(function1, IPixView.PAGE_STATUS_INIT);
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            JSONArray jSONArray = new JSONArray();
            function1.invoke(Intrinsics.checkParameterIsNotNull(JSONArrayCreator.m47107constructorimpl(jSONArray), RavenKey.VERSION));
            jSONObject.putOpt((String) charSequence, jSONArray);
        }
    }

    /* renamed from: array-impl  reason: not valid java name */
    public static final <T> void m47115arrayimpl(JSONObject jSONObject, String str, Function1<? super JSONArrayCreator<T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "$this$array");
        Intrinsics.checkParameterIsNotNull(function1, IPixView.PAGE_STATUS_INIT);
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            JSONArray jSONArray = new JSONArray();
            function1.invoke(Intrinsics.checkParameterIsNotNull(JSONArrayCreator.m47107constructorimpl(jSONArray), RavenKey.VERSION));
            jSONObject.putOpt((String) charSequence, jSONArray);
        }
    }
}
