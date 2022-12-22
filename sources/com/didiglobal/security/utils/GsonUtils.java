package com.didiglobal.security.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\b¢\u0006\u0002\u0010\u0007J+\u0010\b\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\n¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\u0006\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\r\u001a\u0002H\u0004¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/security/utils/GsonUtils;", "", "()V", "deserialize", "T", "json", "", "(Ljava/lang/String;)Ljava/lang/Object;", "fromJson", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "serialize", "data", "(Ljava/lang/Object;)Ljava/lang/String;", "security_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: GsonUtils.kt */
public final class GsonUtils {
    public static final GsonUtils INSTANCE = new GsonUtils();

    private GsonUtils() {
    }

    public final /* synthetic */ <T> T deserialize(String str) throws JsonSyntaxException {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        Gson gson = new Gson();
        Intrinsics.needClassReification();
        return gson.fromJson(str, new GsonUtils$deserialize$1().getType());
    }

    public final <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        return new Gson().fromJson(str, cls);
    }

    public final <T> String serialize(T t) {
        Intrinsics.checkParameterIsNotNull(t, "data");
        String json = new Gson().toJson((Object) t);
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(data)");
        return json;
    }
}
