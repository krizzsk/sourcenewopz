package com.global.didi.elvish.util;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0002H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/global/didi/elvish/util/JsonUtils;", "", "()V", "analystJson", "T", "json", "", "(Ljava/lang/String;)Ljava/lang/Object;", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: JsonUtils.kt */
public final class JsonUtils {
    public static final JsonUtils INSTANCE = new JsonUtils();

    private JsonUtils() {
    }

    public final /* synthetic */ <T> T analystJson(String str) {
        Intrinsics.checkParameterIsNotNull(str, "json");
        Gson gson = new Gson();
        Intrinsics.reifiedOperationMarker(4, "T");
        return gson.fromJson(str, Object.class);
    }
}
