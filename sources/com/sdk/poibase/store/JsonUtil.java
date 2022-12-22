package com.sdk.poibase.store;

import android.text.TextUtils;
import com.didi.sdk.log.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonUtil {

    /* renamed from: a */
    private static final String f56004a = "JsonUtil";

    /* renamed from: b */
    private static final Gson f56005b = new GsonBuilder().create();

    public static String jsonFromObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return f56005b.toJson(obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static <T> T objectFromJson(String str, String str2, Class<T> cls) {
        if (!TextUtils.isEmpty(str)) {
            Logger.m25808d(f56004a, str);
        }
        if (TextUtils.isEmpty(str2) || cls == null) {
            return null;
        }
        try {
            return f56005b.fromJson(str2, cls);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static <T> T objectFromJson(String str, Class<T> cls) {
        return objectFromJson((String) null, str, cls);
    }

    public static <T> ArrayList<T> jsonToList(String str, Class<T> cls) {
        ArrayList<T> arrayList = new ArrayList<>();
        if (cls.isPrimitive()) {
            Iterator it = ((ArrayList) f56005b.fromJson(str, new TypeToken<ArrayList<JsonPrimitive>>() {
            }.getType())).iterator();
            while (it.hasNext()) {
                arrayList.add(f56005b.fromJson((JsonElement) (JsonPrimitive) it.next(), cls));
            }
        } else {
            Iterator it2 = ((ArrayList) f56005b.fromJson(str, new TypeToken<ArrayList<JsonObject>>() {
            }.getType())).iterator();
            while (it2.hasNext()) {
                arrayList.add(f56005b.fromJson((JsonElement) (JsonObject) it2.next(), cls));
            }
        }
        return arrayList;
    }
}
