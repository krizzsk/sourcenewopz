package com.didiglobal.ibg_rpc_service.internal;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/internal/GsonHelper;", "", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GsonHelper.kt */
public final class GsonHelper {
    public static final GsonHelper INSTANCE = new GsonHelper();

    /* renamed from: a */
    private static final String f50243a = "GsonHelper";

    /* renamed from: b */
    private static final Lazy f50244b = LazyKt.lazy(GsonHelper$gson$2.INSTANCE);

    private GsonHelper() {
    }

    public final Gson getGson() {
        Object value = f50244b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gson>(...)");
        return (Gson) value;
    }
}
