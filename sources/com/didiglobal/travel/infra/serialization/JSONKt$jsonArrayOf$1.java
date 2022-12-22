package com.didiglobal.travel.infra.serialization;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "T", "Lorg/json/JSONArray;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: JSON.kt */
public final class JSONKt$jsonArrayOf$1 extends Lambda implements Function1<JSONArray, Unit> {
    public static final JSONKt$jsonArrayOf$1 INSTANCE = new JSONKt$jsonArrayOf$1();

    public JSONKt$jsonArrayOf$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JSONArray) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(JSONArray jSONArray) {
        Intrinsics.checkParameterIsNotNull(jSONArray, "$receiver");
    }
}
