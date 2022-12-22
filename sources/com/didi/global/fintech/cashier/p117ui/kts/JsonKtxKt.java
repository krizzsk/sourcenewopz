package com.didi.global.fintech.cashier.p117ui.kts;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"gson", "Lcom/google/gson/Gson;", "setGsonImpl", "", "impl", "toJson", "", "", "type", "Ljava/lang/reflect/Type;", "cashier_ui_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.kts.JsonKtxKt */
/* compiled from: JsonKtx.kt */
public final class JsonKtxKt {

    /* renamed from: a */
    private static volatile Gson f21751a = new Gson();

    public static final void setGsonImpl(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "impl");
        f21751a = gson;
    }

    public static final String toJson(Object obj, Type type) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        String json = f21751a.toJson(obj, type);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(this, type)");
        return json;
    }

    public static /* synthetic */ String toJson$default(Object obj, Type type, int i, Object obj2) {
        if ((i & 1) != 0) {
            type = obj.getClass();
        }
        return toJson(obj, type);
    }
}
