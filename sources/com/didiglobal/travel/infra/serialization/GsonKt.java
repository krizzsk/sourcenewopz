package com.didiglobal.travel.infra.serialization;

import com.didi.entrega.customer.app.constant.Const;
import com.didi.raven.config.RavenKey;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006ø\u0001\u0000\u001a.\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u001d\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\n\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006ø\u0001\u0000\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u001a\"\u0010\u0011\u001a\u0002H\t\"\u0006\b\u0000\u0010\t\u0018\u0001*\u00020\u00122\u0006\u0010\u0000\u001a\u00020\u0013H\b¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\r\u001a\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0019\u001a;\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u001c*\u00020\u001d*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0\u0003H\b\u001a\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\"\u0010 \u001a\u0002H\t\"\u0006\b\u0000\u0010\t\u0018\u0001*\u00020\r2\u0006\u0010\u0000\u001a\u00020\u0013H\b¢\u0006\u0002\u0010!\u001a \u0010\"\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\u00020\b2\u0006\u0010#\u001a\u0002H\tH\u0002¢\u0006\u0002\u0010$\u001a\u0014\u0010%\u001a\u0004\u0018\u00010&*\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\f\u0010'\u001a\u0004\u0018\u00010&*\u00020\u0016\u001a\u001e\u0010(\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\u000f\u001a%\u0010*\u001a\u00020\r*\u00020\u00162\b\b\u0002\u0010)\u001a\u00020\u000f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0,H\b\u001a\f\u0010-\u001a\u0004\u0018\u00010\r*\u00020\u0016\u001a\u0016\u0010-\u001a\u0004\u0018\u00010\r*\u00020&2\b\b\u0002\u0010)\u001a\u00020\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006."}, mo175978d2 = {"gson", "Lcom/google/gson/JsonObject;", "supplier", "Lkotlin/Function1;", "Lcom/didiglobal/travel/infra/serialization/JsonObjectAssembler;", "", "Lkotlin/ExtensionFunctionType;", "gsonArray", "Lcom/google/gson/JsonArray;", "T", "Lcom/didiglobal/travel/infra/serialization/JsonArrayAssembler;", "arrayOf", "name", "", "boolOf", "", "defaultValue", "convertWithGson", "Lorg/json/JSONObject;", "Lcom/google/gson/Gson;", "(Lorg/json/JSONObject;Lcom/google/gson/Gson;)Ljava/lang/Object;", "elementOf", "Lcom/google/gson/JsonElement;", "path", "intOf", "", "mapArrayOf", "", "R", "", "transform", "objectOf", "parseWithGson", "(Ljava/lang/String;Lcom/google/gson/Gson;)Ljava/lang/Object;", "plus", "value", "(Lcom/google/gson/JsonArray;Ljava/lang/Object;)Lcom/google/gson/JsonArray;", "primitiveOf", "Lcom/google/gson/JsonPrimitive;", "primitiveOrNull", "stringOf", "strict", "stringOr", "fallback", "Lkotlin/Function0;", "stringOrNull", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Gson.kt */
public final class GsonKt {
    public static final JsonObject gson(Function1<? super JsonObjectAssembler, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "supplier");
        JsonObject jsonObject = new JsonObject();
        function1.invoke(Intrinsics.checkParameterIsNotNull(JsonObjectAssembler.m47148constructorimpl(jsonObject), RavenKey.VERSION));
        return jsonObject;
    }

    public static final <T> JsonArray gsonArray(Function1<? super JsonArrayAssembler<T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "supplier");
        JsonArray jsonArray = new JsonArray();
        function1.invoke(Intrinsics.checkParameterIsNotNull(JsonArrayAssembler.m47138constructorimpl(jsonArray), RavenKey.VERSION));
        return jsonArray;
    }

    public static final JsonObject objectOf(JsonObject jsonObject, String str) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$this$objectOf");
        Intrinsics.checkParameterIsNotNull(str, "name");
        JsonElement elementOf = elementOf(jsonObject, str);
        if (elementOf == null) {
            return null;
        }
        if (!elementOf.isJsonObject()) {
            elementOf = null;
        }
        if (elementOf != null) {
            return elementOf.getAsJsonObject();
        }
        return null;
    }

    public static final JsonArray arrayOf(JsonObject jsonObject, String str) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$this$arrayOf");
        Intrinsics.checkParameterIsNotNull(str, "name");
        JsonElement elementOf = elementOf(jsonObject, str);
        if (elementOf == null) {
            return null;
        }
        if (!elementOf.isJsonArray()) {
            elementOf = null;
        }
        if (elementOf != null) {
            return elementOf.getAsJsonArray();
        }
        return null;
    }

    public static final JsonPrimitive primitiveOf(JsonObject jsonObject, String str) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$this$primitiveOf");
        Intrinsics.checkParameterIsNotNull(str, "name");
        JsonElement elementOf = elementOf(jsonObject, str);
        if (elementOf == null) {
            return null;
        }
        if (!elementOf.isJsonPrimitive()) {
            elementOf = null;
        }
        if (elementOf != null) {
            return elementOf.getAsJsonPrimitive();
        }
        return null;
    }

    public static /* synthetic */ int intOf$default(JsonObject jsonObject, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return intOf(jsonObject, str, i);
    }

    public static final int intOf(JsonObject jsonObject, String str, int i) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$this$intOf");
        Intrinsics.checkParameterIsNotNull(str, "name");
        JsonPrimitive primitiveOf = primitiveOf(jsonObject, str);
        if (primitiveOf == null) {
            return i;
        }
        if (!primitiveOf.isNumber()) {
            primitiveOf = null;
        }
        return primitiveOf != null ? primitiveOf.getAsInt() : i;
    }

    public static /* synthetic */ boolean boolOf$default(JsonObject jsonObject, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boolOf(jsonObject, str, z);
    }

    public static final boolean boolOf(JsonObject jsonObject, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$this$boolOf");
        Intrinsics.checkParameterIsNotNull(str, "name");
        JsonPrimitive primitiveOf = primitiveOf(jsonObject, str);
        if (primitiveOf == null) {
            return z;
        }
        if (!primitiveOf.isBoolean()) {
            primitiveOf = null;
        }
        return primitiveOf != null ? primitiveOf.getAsBoolean() : z;
    }

    public static final String stringOf(JsonObject jsonObject, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$this$stringOf");
        Intrinsics.checkParameterIsNotNull(str, "name");
        JsonPrimitive primitiveOf = primitiveOf(jsonObject, str);
        if (primitiveOf != null) {
            return stringOrNull(primitiveOf, z);
        }
        return null;
    }

    public static /* synthetic */ String stringOf$default(JsonObject jsonObject, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return stringOf(jsonObject, str, z);
    }

    public static final JsonElement elementOf(JsonObject jsonObject, String str) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$this$elementOf");
        Intrinsics.checkParameterIsNotNull(str, "path");
        CharSequence charSequence = str;
        int i = 0;
        if (!StringsKt.contains$default(charSequence, (CharSequence) ":", false, 2, (Object) null)) {
            return jsonObject.get(str);
        }
        List split$default = StringsKt.split$default(charSequence, new String[]{":"}, false, 0, 6, (Object) null);
        JsonElement jsonElement = jsonObject;
        do {
            if (!(jsonElement instanceof JsonObject)) {
                jsonElement = null;
            }
            JsonObject jsonObject2 = (JsonObject) jsonElement;
            if (jsonObject2 != null) {
                jsonElement = jsonObject2.get((String) split$default.get(i));
                i++;
            } else {
                jsonElement = null;
            }
        } while (i < split$default.size());
        return jsonElement;
    }

    public static final <R> List<R> mapArrayOf(JsonObject jsonObject, String str, Function1<? super JsonElement, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$this$mapArrayOf");
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(function1, Const.BillClickType.TRANSFORM);
        JsonArray<Object> arrayOf = arrayOf(jsonObject, str);
        if (arrayOf == null) {
            return CollectionsKt.emptyList();
        }
        Collection arrayList = new ArrayList();
        for (Object invoke : arrayOf) {
            Object invoke2 = function1.invoke(invoke);
            if (invoke2 != null) {
                arrayList.add(invoke2);
            }
        }
        return (List) arrayList;
    }

    public static final String stringOrNull(JsonPrimitive jsonPrimitive, boolean z) {
        Intrinsics.checkParameterIsNotNull(jsonPrimitive, "$this$stringOrNull");
        if (!(!z || jsonPrimitive.isString())) {
            jsonPrimitive = null;
        }
        if (jsonPrimitive != null) {
            return jsonPrimitive.getAsString();
        }
        return null;
    }

    public static /* synthetic */ String stringOrNull$default(JsonPrimitive jsonPrimitive, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return stringOrNull(jsonPrimitive, z);
    }

    public static final JsonPrimitive primitiveOrNull(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$this$primitiveOrNull");
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement != null) {
            return jsonElement.getAsJsonPrimitive();
        }
        return null;
    }

    public static final String stringOrNull(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$this$stringOrNull");
        JsonPrimitive primitiveOrNull = primitiveOrNull(jsonElement);
        if (primitiveOrNull != null) {
            return stringOrNull$default(primitiveOrNull, false, 1, (Object) null);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        r0 = stringOrNull(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.String stringOr$default(com.google.gson.JsonElement r0, boolean r1, kotlin.jvm.functions.Function0 r2, int r3, java.lang.Object r4) {
        /*
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0005
            r1 = 1
        L_0x0005:
            java.lang.String r3 = "$this$stringOr"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r3)
            java.lang.String r3 = "fallback"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r3)
            com.google.gson.JsonPrimitive r0 = primitiveOrNull(r0)
            if (r0 == 0) goto L_0x001c
            java.lang.String r0 = stringOrNull(r0, r1)
            if (r0 == 0) goto L_0x001c
            goto L_0x0022
        L_0x001c:
            java.lang.Object r0 = r2.invoke()
            java.lang.String r0 = (java.lang.String) r0
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.infra.serialization.GsonKt.stringOr$default(com.google.gson.JsonElement, boolean, kotlin.jvm.functions.Function0, int, java.lang.Object):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r1 = stringOrNull(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String stringOr(com.google.gson.JsonElement r1, boolean r2, kotlin.jvm.functions.Function0<java.lang.String> r3) {
        /*
            java.lang.String r0 = "$this$stringOr"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "fallback"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            com.google.gson.JsonPrimitive r1 = primitiveOrNull(r1)
            if (r1 == 0) goto L_0x0017
            java.lang.String r1 = stringOrNull(r1, r2)
            if (r1 == 0) goto L_0x0017
            goto L_0x001d
        L_0x0017:
            java.lang.Object r1 = r3.invoke()
            java.lang.String r1 = (java.lang.String) r1
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.infra.serialization.GsonKt.stringOr(com.google.gson.JsonElement, boolean, kotlin.jvm.functions.Function0):java.lang.String");
    }

    public static final <T> JsonArray plus(JsonArray jsonArray, T t) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$this$plus");
        if (t instanceof Boolean) {
            jsonArray.add((JsonElement) new JsonPrimitive((Boolean) t));
        } else if (t instanceof Number) {
            jsonArray.add((JsonElement) new JsonPrimitive((Number) t));
        } else if (t instanceof Character) {
            jsonArray.add((JsonElement) new JsonPrimitive((Character) t));
        } else if (t instanceof String) {
            jsonArray.add((JsonElement) new JsonPrimitive((String) t));
        } else if (t instanceof JsonElement) {
            jsonArray.add((JsonElement) t);
        } else {
            throw new IllegalArgumentException("unsupported type");
        }
        return jsonArray;
    }

    public static final /* synthetic */ <T> T parseWithGson(String str, Gson gson) {
        Intrinsics.checkParameterIsNotNull(str, "$this$parseWithGson");
        Intrinsics.checkParameterIsNotNull(gson, "gson");
        Intrinsics.reifiedOperationMarker(4, "T");
        return gson.fromJson(str, Object.class);
    }

    public static final /* synthetic */ <T> T convertWithGson(JSONObject jSONObject, Gson gson) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "$this$convertWithGson");
        Intrinsics.checkParameterIsNotNull(gson, "gson");
        String jSONObject2 = jSONObject.toString();
        Intrinsics.reifiedOperationMarker(4, "T");
        return gson.fromJson(jSONObject2, Object.class);
    }
}
