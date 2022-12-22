package com.didi.sdk.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSonUtil {

    /* renamed from: a */
    private static Gson f37592a;

    /* renamed from: a */
    private static Gson m26690a() {
        Gson gson;
        Gson gson2 = f37592a;
        if (gson2 != null) {
            return gson2;
        }
        synchronized (GSonUtil.class) {
            if (f37592a == null) {
                f37592a = new GsonBuilder().create();
            }
            gson = f37592a;
        }
        return gson;
    }

    public static String jsonFromObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return m26690a().toJson(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T objectFromJson(String str, Class<T> cls) {
        if (str == null) {
            return null;
        }
        try {
            return m26690a().fromJson(str, cls);
        } catch (Exception unused) {
            return null;
        }
    }
}
