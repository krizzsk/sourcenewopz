package com.didi.unifiedPay.sdk.net;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.didi.unifiedPay.sdk.net.Util */
public class C14489Util {

    /* renamed from: a */
    private static final String f44569a = "JsonUtil";

    /* renamed from: b */
    private static final Gson f44570b = new GsonBuilder().create();

    public static String jsonFromObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return f44570b.toJson(obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static <T> T objectFromJson(String str, String str2, Class<T> cls) {
        if (TextUtils.isEmpty(str2) || cls == null) {
            return null;
        }
        try {
            return f44570b.fromJson(str2, cls);
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
            Iterator it = ((ArrayList) f44570b.fromJson(str, new TypeToken<ArrayList<JsonPrimitive>>() {
            }.getType())).iterator();
            while (it.hasNext()) {
                arrayList.add(f44570b.fromJson((JsonElement) (JsonPrimitive) it.next(), cls));
            }
        } else {
            Iterator it2 = ((ArrayList) f44570b.fromJson(str, new TypeToken<ArrayList<JsonObject>>() {
            }.getType())).iterator();
            while (it2.hasNext()) {
                arrayList.add(f44570b.fromJson((JsonElement) (JsonObject) it2.next(), cls));
            }
        }
        return arrayList;
    }
}
