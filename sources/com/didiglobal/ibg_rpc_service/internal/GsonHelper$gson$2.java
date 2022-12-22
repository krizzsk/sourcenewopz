package com.didiglobal.ibg_rpc_service.internal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GsonHelper.kt */
final class GsonHelper$gson$2 extends Lambda implements Function0<Gson> {
    public static final GsonHelper$gson$2 INSTANCE = new GsonHelper$gson$2();

    GsonHelper$gson$2() {
        super(0);
    }

    public final Gson invoke() {
        return new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, ? extends Object>>() {
        }.getType(), new ObjectTypeAdapter()).create();
    }
}
