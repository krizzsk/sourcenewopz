package com.didi.entrega.customer.foundation.tracker.param;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

public final class ParamCompat {

    /* renamed from: a */
    static volatile Gson f20053a;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new TypeToken<Map<String, Object>>() {
        }.getType(), new MapDeserializerDoubleAsIntFix());
        f20053a = gsonBuilder.create();
    }

    public static <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        return f20053a.fromJson(str, type);
    }
}
