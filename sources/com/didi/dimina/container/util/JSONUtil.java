package com.didi.dimina.container.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtil {

    /* renamed from: a */
    private static final Gson f17942a = new GsonBuilder().create();

    public static void put(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void put(JSONObject jSONObject, String str, double d) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, d);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void put(JSONObject jSONObject, String str, int i) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void put(JSONObject jSONObject, String str, long j) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void put(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void put(JSONArray jSONArray, Object obj) {
        if (jSONArray != null) {
            try {
                jSONArray.put(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T jsonToObject(String str, Type type) {
        if (TextUtils.isEmpty(str) || type == null) {
            return null;
        }
        try {
            return f17942a.fromJson(str, type);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String toJson(Object obj) {
        try {
            if (obj instanceof JSONObject) {
                return obj.toString();
            }
            if (obj instanceof JSONArray) {
                return obj.toString();
            }
            return f17942a.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject toJSONObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONArray toJSONArray(String str) {
        try {
            return new JSONArray(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String jsonFromObject(Object obj) {
        if (obj == null) {
            return "{}";
        }
        try {
            return f17942a.toJson(obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return "{}";
        }
    }

    public static <T> T objectFromJson(String str, Class<T> cls) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return null;
        }
        try {
            return f17942a.fromJson(str, cls);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static <T> ArrayList<T> jsonToList(String str, Class<T> cls) {
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            if (!cls.isPrimitive()) {
                if (cls != String.class) {
                    Iterator it = ((ArrayList) f17942a.fromJson(str, new TypeToken<ArrayList<JsonObject>>() {
                    }.getType())).iterator();
                    while (it.hasNext()) {
                        arrayList.add(f17942a.fromJson((JsonElement) (JsonObject) it.next(), cls));
                    }
                    return arrayList;
                }
            }
            Iterator it2 = ((ArrayList) f17942a.fromJson(str, new TypeToken<ArrayList<JsonPrimitive>>() {
            }.getType())).iterator();
            while (it2.hasNext()) {
                arrayList.add(f17942a.fromJson((JsonElement) (JsonPrimitive) it2.next(), cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static <T, V> HashMap<T, V> jsonToMapSimple(String str, Class<T> cls, Class<V> cls2) {
        HashMap<T, V> hashMap = new HashMap<>();
        try {
            return (HashMap) f17942a.fromJson(str, new TypeToken<HashMap<T, V>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return hashMap;
        }
    }

    public static <T, V> HashMap<T, V> jsonToMapSimple(String str, Type type) {
        HashMap<T, V> hashMap = new HashMap<>();
        try {
            return (HashMap) f17942a.fromJson(str, type);
        } catch (Exception e) {
            e.printStackTrace();
            return hashMap;
        }
    }

    public static <T> ArrayList<T> jsonToListSimple(String str, Class<T> cls) {
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            return (ArrayList) f17942a.fromJson(str, TypeToken.getParameterized(ArrayList.class, cls).getType());
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static JSONObject combineJson(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                put(jSONObject3, next, jSONObject.opt(next));
            }
        }
        if (jSONObject2 != null) {
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                put(jSONObject3, next2, jSONObject2.opt(next2));
            }
        }
        return jSONObject3;
    }

    public static String getJsonString(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
