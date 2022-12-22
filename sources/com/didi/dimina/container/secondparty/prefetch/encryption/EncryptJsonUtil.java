package com.didi.dimina.container.secondparty.prefetch.encryption;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EncryptJsonUtil {

    /* renamed from: a */
    private static final Gson f17433a = new GsonBuilder().create();

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return f17433a.toJson(obj);
    }
}
