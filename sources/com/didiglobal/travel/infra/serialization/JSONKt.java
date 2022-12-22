package com.didiglobal.travel.infra.serialization;

import com.didi.entrega.customer.app.constant.Const;
import com.didi.raven.config.RavenKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006ø\u0001\u0000\u001a.\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u001d\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\n\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006ø\u0001\u0000\u001aC\u0010\u000b\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\t0\r\"\u0002H\t2\u0019\b\u0002\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\b¢\u0006\u0002\u0010\u000f\u001a\f\u0010\u0010\u001a\u00020\u0011*\u0004\u0018\u00010\b\u001a\f\u0010\u0012\u001a\u00020\u0011*\u0004\u0018\u00010\b\u001a@\u0010\u0013\u001a\u00020\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\t0\r2\u0006\u0010\u0015\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00140\u0003H\b¢\u0006\u0002\u0010\u0017\u001a;\u0010\u0013\u001a\u00020\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\t0\u00182\u0006\u0010\u0015\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00140\u0003H\b\u001a \u0010\u0019\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\u00020\b2\u0006\u0010\u001a\u001a\u0002H\tH\u0002¢\u0006\u0002\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\r¢\u0006\u0002\u0010\u001d\u001a\u0016\u0010\u001c\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, mo175978d2 = {"json", "Lorg/json/JSONObject;", "supplier", "Lkotlin/Function1;", "Lcom/didiglobal/travel/infra/serialization/JSONCreator;", "", "Lkotlin/ExtensionFunctionType;", "jsonArray", "Lorg/json/JSONArray;", "T", "Lcom/didiglobal/travel/infra/serialization/JSONArrayCreator;", "jsonArrayOf", "element", "", "action", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lorg/json/JSONArray;", "isNotEmpty", "", "isNullOrEmpty", "mapTo", "R", "destination", "transform", "([Ljava/lang/Object;Lorg/json/JSONArray;Lkotlin/jvm/functions/Function1;)Lorg/json/JSONArray;", "", "plus", "value", "(Lorg/json/JSONArray;Ljava/lang/Object;)Lorg/json/JSONArray;", "toJSON", "([Ljava/lang/Object;)Lorg/json/JSONArray;", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: JSON.kt */
public final class JSONKt {
    public static final JSONObject json(Function1<? super JSONCreator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "supplier");
        JSONObject jSONObject = new JSONObject();
        function1.invoke(Intrinsics.checkParameterIsNotNull(JSONCreator.m47118constructorimpl(jSONObject), RavenKey.VERSION));
        return jSONObject;
    }

    public static final <T> JSONArray jsonArray(Function1<? super JSONArrayCreator<T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "supplier");
        JSONArray jSONArray = new JSONArray();
        function1.invoke(Intrinsics.checkParameterIsNotNull(JSONArrayCreator.m47107constructorimpl(jSONArray), RavenKey.VERSION));
        return jSONArray;
    }

    public static final boolean isNullOrEmpty(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static final boolean isNotEmpty(JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        return jSONArray.length() > 0;
    }

    public static /* synthetic */ JSONArray jsonArrayOf$default(Object[] objArr, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = JSONKt$jsonArrayOf$1.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull(objArr, "element");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        JSONArray jSONArray = new JSONArray();
        for (Object put : objArr) {
            jSONArray.put(put);
        }
        function1.invoke(jSONArray);
        return jSONArray;
    }

    public static final <T> JSONArray jsonArrayOf(T[] tArr, Function1<? super JSONArray, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "element");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        JSONArray jSONArray = new JSONArray();
        for (T put : tArr) {
            jSONArray.put(put);
        }
        function1.invoke(jSONArray);
        return jSONArray;
    }

    public static final <T> JSONArray toJSON(T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "$this$toJSON");
        JSONArray jSONArray = new JSONArray();
        for (T put : tArr) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static final <T> JSONArray toJSON(Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$toJSON");
        JSONArray jSONArray = new JSONArray();
        for (Object put : iterable) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static final <T, R> JSONArray mapTo(T[] tArr, JSONArray jSONArray, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "$this$mapTo");
        Intrinsics.checkParameterIsNotNull(jSONArray, "destination");
        Intrinsics.checkParameterIsNotNull(function1, Const.BillClickType.TRANSFORM);
        for (T invoke : tArr) {
            jSONArray.put(function1.invoke(invoke));
        }
        return jSONArray;
    }

    public static final <T, R> JSONArray mapTo(Iterable<? extends T> iterable, JSONArray jSONArray, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$mapTo");
        Intrinsics.checkParameterIsNotNull(jSONArray, "destination");
        Intrinsics.checkParameterIsNotNull(function1, Const.BillClickType.TRANSFORM);
        for (Object invoke : iterable) {
            jSONArray.put(function1.invoke(invoke));
        }
        return jSONArray;
    }

    public static final <T> JSONArray plus(JSONArray jSONArray, T t) {
        Intrinsics.checkParameterIsNotNull(jSONArray, "$this$plus");
        if (t instanceof Boolean) {
            jSONArray.put(((Boolean) t).booleanValue());
        } else if (t instanceof Integer) {
            jSONArray.put(((Number) t).intValue());
        } else if (t instanceof Long) {
            jSONArray.put(((Number) t).longValue());
        } else if (t instanceof Float) {
            jSONArray.put((double) ((Number) t).floatValue());
        } else if (t instanceof Double) {
            jSONArray.put(((Number) t).doubleValue());
        } else {
            jSONArray.put(t);
        }
        return jSONArray;
    }
}
