package com.didi.travel.psnger.utils;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.response.PrePayTipsModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil<T extends BaseObject> {

    /* renamed from: a */
    private static final String f44232a = "JsonUtil";

    /* renamed from: b */
    private static final Gson f44233b = new GsonBuilder().create();

    public static ArrayList<String> parseJSONArrayString(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }

    public static ArrayList<Integer> parseJSONArrayInteger(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arrayList.add(Integer.valueOf(jSONArray.optInt(i)));
        }
        return arrayList;
    }

    public ArrayList<T> parseJSONArray(JSONArray jSONArray, T t) {
        ArrayList<T> arrayList = new ArrayList<>();
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            int length = jSONArray.length();
            T t2 = t;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    t2.parse(optJSONObject.toString());
                }
                if (t2 != null) {
                    arrayList.add(t2);
                }
                t2 = t.newBaseObject();
            }
        }
        return arrayList;
    }

    public static ArrayList<? extends Object> parseArray(JSONObject jSONObject, String str) {
        ArrayList<? extends Object> arrayList = new ArrayList<>();
        if (!jSONObject.has(str)) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        int i = 0;
        while (i < optJSONArray.length()) {
            try {
                arrayList.add(optJSONArray.get(i));
                i++;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static String jsonFromObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return f44233b.toJson(obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static <T> T objectFromJson(String str, String str2, Class<T> cls) {
        if (!TextUtils.isEmpty(str)) {
            SystemUtils.log(3, f44232a, str, (Throwable) null, "com.didi.travel.psnger.utils.JsonUtil", 136);
        }
        if (TextUtils.isEmpty(str2) || cls == null) {
            return null;
        }
        try {
            return f44233b.fromJson(str2, cls);
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
            Iterator it = ((ArrayList) f44233b.fromJson(str, new TypeToken<ArrayList<JsonPrimitive>>() {
            }.getType())).iterator();
            while (it.hasNext()) {
                arrayList.add(f44233b.fromJson((JsonElement) (JsonPrimitive) it.next(), cls));
            }
        } else {
            Iterator it2 = ((ArrayList) f44233b.fromJson(str, new TypeToken<ArrayList<JsonObject>>() {
            }.getType())).iterator();
            while (it2.hasNext()) {
                arrayList.add(f44233b.fromJson((JsonElement) (JsonObject) it2.next(), cls));
            }
        }
        return arrayList;
    }

    public static <T> T objectFromJson(String str, Class<T> cls, final T t) {
        try {
            new GsonBuilder().registerTypeAdapter(cls, new InstanceCreator<T>() {
                public T createInstance(Type type) {
                    return t;
                }
            }).create().fromJson(str, PrePayTipsModel.class);
        } catch (Exception e) {
            e.printStackTrace();
            SystemUtils.log(3, f44232a, "exception : " + e.getMessage(), (Throwable) null, "com.didi.travel.psnger.utils.JsonUtil", 194);
        }
        return t;
    }

    public static String optString(JSONObject jSONObject, String str) {
        if (jSONObject == null || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, (String) null);
    }
}
