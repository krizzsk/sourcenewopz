package com.didi.beatles.p099im.utils;

import android.text.TextUtils;
import com.didi.beatles.p099im.api.entity.IMDetailBody;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.raven.config.RavenKey;
import com.didi.remotereslibrary.Config;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;

/* renamed from: com.didi.beatles.im.utils.IMJsonUtil */
public class IMJsonUtil {

    /* renamed from: a */
    private static final Gson f9769a;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(IMDetailBody.class, new TypeResultDeserializer());
        gsonBuilder.registerTypeAdapter(IMDetailBody.class, new TypeResultSerializer());
        gsonBuilder.disableHtmlEscaping();
        f9769a = gsonBuilder.create();
    }

    public static String jsonFromObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return f9769a.toJson(obj);
        } catch (Exception e) {
            IMLog.m6632e("IMJsonUtil", "jsonFromObject wrong ,errMsg :" + e.getMessage());
            IMTraceError.trackError("IMJsonUtil", new IllegalStateException("IMJsonUtil#jsonFromObject(Object object)#", e));
            return null;
        }
    }

    public static <T> T objectFromJson(String str, Class<T> cls) {
        return objectFromJson(str, cls, false);
    }

    public static <T> T objectFromJson(String str, Class<T> cls, boolean z) {
        if (str == null) {
            return null;
        }
        try {
            return f9769a.fromJson(str, cls);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append("IMJsonUtil#objectFromJson(String json, Class<T> klass)#");
                sb.append(cls != null ? cls.getName() : "NULL");
                IMTraceError.trackError("IMJsonUtil", new IllegalStateException(sb.toString(), e));
            }
            return null;
        } catch (IncompatibleClassChangeError e2) {
            e2.printStackTrace();
            if (!z) {
                IMTraceError.trackError("IMJsonUtil", new IllegalStateException("IMJsonUtil#objectFromJson(String json, Class<T> klass)#" + cls.getName(), e2));
            }
            return null;
        }
    }

    public static <T> T objectFromJson(String str, Type type) {
        if (str == null) {
            return null;
        }
        try {
            return f9769a.fromJson(str, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            IMTraceError.trackError("IMJsonUtil", new IllegalStateException("IMJsonUtil#objectFromJson(String json, Type type)#", e));
            return null;
        }
    }

    public static <T> T objectFromJson(JsonObject jsonObject, Class<T> cls) {
        if (jsonObject == null) {
            return null;
        }
        try {
            return f9769a.fromJson((JsonElement) jsonObject, cls);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append("IMJsonUtil#objectFromJson(JsonObject json, Class<T> klass)#");
            sb.append(cls != null ? cls.getName() : "NULL");
            IMTraceError.trackError("IMJsonUtil", new IllegalStateException(sb.toString(), e));
            return null;
        }
    }

    public static <T> T objectFromJson(JsonElement jsonElement, Class<T> cls) {
        if (jsonElement == null) {
            return null;
        }
        try {
            return f9769a.fromJson(jsonElement, cls);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append("IMJsonUtil#objectFromJson(JsonElement json, Class<T> klass)#");
            sb.append(cls != null ? cls.getName() : "NULL");
            IMTraceError.trackError("IMJsonUtil", new IllegalStateException(sb.toString(), e));
            return null;
        }
    }

    /* renamed from: com.didi.beatles.im.utils.IMJsonUtil$TypeResultDeserializer */
    public static class TypeResultDeserializer implements JsonDeserializer<IMDetailBody> {
        public IMDetailBody deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            String str;
            String str2;
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            String str3 = null;
            if (asJsonObject == null) {
                return null;
            }
            String str4 = "";
            if (asJsonObject.has("cont")) {
                JsonElement jsonElement2 = asJsonObject.get("cont");
                if (jsonElement2.isJsonObject()) {
                    str2 = jsonElement2.toString();
                } else {
                    str2 = jsonElement2.getAsString();
                }
                str = str2;
            } else {
                str = str4;
            }
            String asString = asJsonObject.has(ParamKeys.PARAM_EVENT_ID) ? asJsonObject.get(ParamKeys.PARAM_EVENT_ID).getAsString() : str4;
            String asString2 = asJsonObject.has(Config.KEY_NS) ? asJsonObject.get(Config.KEY_NS).getAsString() : str4;
            String asString3 = asJsonObject.has("ftoken") ? asJsonObject.get("ftoken").getAsString() : str4;
            String asString4 = asJsonObject.has("fid") ? asJsonObject.get("fid").getAsString() : str4;
            int asInt = asJsonObject.has("size") ? asJsonObject.get("size").getAsInt() : 0;
            int asInt2 = asJsonObject.has("sec") ? asJsonObject.get("sec").getAsInt() : 0;
            int asInt3 = asJsonObject.has("width") ? asJsonObject.get("width").getAsInt() : 0;
            int asInt4 = asJsonObject.has("height") ? asJsonObject.get("height").getAsInt() : 0;
            String asString5 = asJsonObject.has("list_text") ? asJsonObject.get("list_text").getAsString() : str4;
            String asString6 = asJsonObject.has("top_text") ? asJsonObject.get("top_text").getAsString() : str4;
            String asString7 = asJsonObject.has("top_content") ? asJsonObject.get("top_content").getAsString() : str4;
            long asLong = asJsonObject.has("activity_id") ? asJsonObject.get("activity_id").getAsLong() : 0;
            JsonObject asJsonObject2 = asJsonObject.has("extend") ? asJsonObject.get("extend").getAsJsonObject() : null;
            String asString8 = asJsonObject.has("batcheid") ? asJsonObject.get("batcheid").getAsString() : str4;
            JsonArray asJsonArray = asJsonObject.has("btns") ? asJsonObject.get("btns").getAsJsonArray() : null;
            JsonObject asJsonObject3 = asJsonObject.has("trans") ? asJsonObject.get("trans").getAsJsonObject() : null;
            String asString9 = asJsonObject.has("msg_unique_id") ? asJsonObject.get("msg_unique_id").getAsString() : str4;
            int asInt5 = asJsonObject.has(RavenKey.EVENT_ID) ? asJsonObject.get(RavenKey.EVENT_ID).getAsInt() : 0;
            int asInt6 = asJsonObject.has("plugin_id") ? asJsonObject.get("plugin_id").getAsInt() : 0;
            if (asJsonObject.has("voice")) {
                str4 = asJsonObject.get("voice").getAsString();
            }
            String str5 = str4;
            if (asJsonObject.has("ext")) {
                JsonElement jsonElement3 = asJsonObject.get("ext");
                if (jsonElement3.isJsonObject()) {
                    str3 = jsonElement3.toString();
                } else {
                    str3 = jsonElement3.getAsString();
                }
            }
            return new IMDetailBody(asString, str, asString2, asString3, asString4, asInt, asInt2, asInt3, asInt4, asString5, asString6, asString7, asLong, asJsonObject2, asJsonArray, asString8, asJsonObject3, asString9, asInt5, asInt6, str5, str3);
        }
    }

    /* renamed from: com.didi.beatles.im.utils.IMJsonUtil$TypeResultSerializer */
    public static class TypeResultSerializer implements JsonSerializer<IMDetailBody> {
        public JsonElement serialize(IMDetailBody iMDetailBody, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            if (iMDetailBody != null) {
                String str = iMDetailBody.cont != null ? iMDetailBody.cont : "";
                if (TextUtils.isEmpty(str) || !str.startsWith(Const.joLeft) || !str.contains(":") || !str.endsWith("}")) {
                    jsonObject.addProperty("cont", str);
                } else {
                    try {
                        jsonObject.add("cont", new JsonParser().parse(str));
                    } catch (Exception unused) {
                        jsonObject.addProperty("cont", "消息构造失败,请重试");
                        IMLog.m6631d("json", "not jsonObject Exception");
                    }
                }
                jsonObject.addProperty(ParamKeys.PARAM_EVENT_ID, iMDetailBody.event_id);
                jsonObject.addProperty(Config.KEY_NS, iMDetailBody.f9126ns);
                jsonObject.addProperty("ftoken", iMDetailBody.ftoken);
                jsonObject.addProperty("fid", iMDetailBody.fid);
                jsonObject.addProperty("size", (Number) Integer.valueOf(iMDetailBody.size));
                jsonObject.addProperty("sec", (Number) Integer.valueOf(iMDetailBody.sec));
                jsonObject.addProperty("width", (Number) Integer.valueOf(iMDetailBody.width));
                jsonObject.addProperty("height", (Number) Integer.valueOf(iMDetailBody.height));
                jsonObject.addProperty("list_text", iMDetailBody.list_text);
                jsonObject.addProperty("top_text", iMDetailBody.top_text);
                jsonObject.addProperty("top_content", iMDetailBody.top_content);
                jsonObject.addProperty("activity", (Number) Long.valueOf(iMDetailBody.activity_id));
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("light_str", iMDetailBody.light_str);
                jsonObject2.addProperty("light_link", iMDetailBody.light_link);
                jsonObject.add("extend", jsonObject2);
                jsonObject.add("ext", new JsonParser().parse(new Gson().toJson(iMDetailBody.ext)));
                jsonObject.addProperty("msg_unique_id", iMDetailBody.msg_unique_id);
                jsonObject.addProperty(RavenKey.EVENT_ID, (Number) Integer.valueOf(iMDetailBody.eid));
                jsonObject.addProperty("plugin_id", (Number) Integer.valueOf(iMDetailBody.pluginId));
                jsonObject.addProperty("voice", iMDetailBody.voice);
                jsonObject.addProperty("emoji_id", iMDetailBody.emojiId);
            }
            return jsonObject;
        }
    }
}
