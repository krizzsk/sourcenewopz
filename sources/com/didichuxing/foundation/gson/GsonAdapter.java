package com.didichuxing.foundation.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GsonAdapter {

    /* renamed from: a */
    private final Gson f47557a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final JsonParser f47558b = new JsonParser();

    public GsonAdapter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(JSONObject.class, new JSONObjectAdapter());
        gsonBuilder.registerTypeAdapter(JSONArray.class, new JSONArrayAdapter());
        this.f47557a = gsonBuilder.create();
    }

    public Gson getGson() {
        return this.f47557a;
    }

    private final class JSONObjectAdapter implements JsonDeserializer<JSONObject>, JsonSerializer<JSONObject> {
        private JSONObjectAdapter() {
        }

        public JSONObject deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            try {
                return new JSONObject(jsonElement.toString());
            } catch (JSONException e) {
                throw new JsonParseException(e.getMessage(), e);
            }
        }

        public JsonElement serialize(JSONObject jSONObject, Type type, JsonSerializationContext jsonSerializationContext) {
            return GsonAdapter.this.f47558b.parse(jSONObject.toString());
        }
    }

    private final class JSONArrayAdapter implements JsonDeserializer<JSONArray>, JsonSerializer<JSONArray> {
        private JSONArrayAdapter() {
        }

        public JSONArray deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            try {
                return new JSONArray(jsonElement.toString());
            } catch (JSONException e) {
                throw new JsonParseException(e.getMessage(), e);
            }
        }

        public JsonElement serialize(JSONArray jSONArray, Type type, JsonSerializationContext jsonSerializationContext) {
            return GsonAdapter.this.f47558b.parse(jSONArray.toString());
        }
    }
}
