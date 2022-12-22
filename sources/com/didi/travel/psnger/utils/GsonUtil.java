package com.didi.travel.psnger.utils;

import com.didi.travel.psnger.gson.PostProcessableFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
    public static Gson getPostProcessableGson() {
        return new GsonBuilder().registerTypeAdapterFactory(new PostProcessableFactory()).create();
    }

    public static String jsonFromObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return new Gson().toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T objectFromJson(String str, Class<T> cls) {
        if (str == null) {
            return null;
        }
        try {
            return getPostProcessableGson().fromJson(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
