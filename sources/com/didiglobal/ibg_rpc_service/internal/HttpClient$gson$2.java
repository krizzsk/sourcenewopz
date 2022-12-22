package com.didiglobal.ibg_rpc_service.internal;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/google/gson/Gson;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HttpClient.kt */
final class HttpClient$gson$2 extends Lambda implements Function0<Gson> {
    public static final HttpClient$gson$2 INSTANCE = new HttpClient$gson$2();

    HttpClient$gson$2() {
        super(0);
    }

    public final Gson invoke() {
        return GsonHelper.INSTANCE.getGson();
    }
}
