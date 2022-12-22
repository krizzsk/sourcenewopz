package com.didi.bike.utils;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {

    /* renamed from: a */
    private static final String f10665a = "JsonUtil";

    /* renamed from: b */
    private static final Gson f10666b;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(JSONObject.class, new TypeAdapter<JSONObject>() {
            public void write(JsonWriter jsonWriter, JSONObject jSONObject) throws IOException {
                jsonWriter.value(jSONObject == null ? null : jSONObject.toString());
            }

            public JSONObject read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return new JSONObject(new JsonParser().parse(jsonReader).getAsJsonObject().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
        f10666b = gsonBuilder.create();
    }

    public static String jsonFromObject(Object obj) {
        if (obj == null) {
            return "{}";
        }
        try {
            return f10666b.toJson(obj);
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
            return f10666b.fromJson(str, cls);
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
                    Iterator it = ((ArrayList) f10666b.fromJson(str, new TypeToken<ArrayList<JsonObject>>() {
                    }.getType())).iterator();
                    while (it.hasNext()) {
                        arrayList.add(f10666b.fromJson((JsonElement) (JsonObject) it.next(), cls));
                    }
                    return arrayList;
                }
            }
            Iterator it2 = ((ArrayList) f10666b.fromJson(str, new TypeToken<ArrayList<JsonPrimitive>>() {
            }.getType())).iterator();
            while (it2.hasNext()) {
                arrayList.add(f10666b.fromJson((JsonElement) (JsonPrimitive) it2.next(), cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static <T> ArrayList<T> jsonToListOrNull(String str, Class<T> cls) {
        ArrayList<T> arrayList = null;
        try {
            if (!cls.isPrimitive()) {
                if (cls != String.class) {
                    Iterator it = ((ArrayList) f10666b.fromJson(str, new TypeToken<ArrayList<JsonObject>>() {
                    }.getType())).iterator();
                    while (it.hasNext()) {
                        JsonObject jsonObject = (JsonObject) it.next();
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(f10666b.fromJson((JsonElement) jsonObject, cls));
                    }
                    return arrayList;
                }
            }
            Iterator it2 = ((ArrayList) f10666b.fromJson(str, new TypeToken<ArrayList<JsonPrimitive>>() {
            }.getType())).iterator();
            while (it2.hasNext()) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) it2.next();
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(f10666b.fromJson((JsonElement) jsonPrimitive, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static boolean isEmpty(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "{}")) {
            return false;
        }
        return true;
    }
}
