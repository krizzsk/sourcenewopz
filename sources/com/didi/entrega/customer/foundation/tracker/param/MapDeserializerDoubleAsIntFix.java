package com.didi.entrega.customer.foundation.tracker.param;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {
    public Map<String, Object> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (Map) read(jsonElement);
    }

    public Object read(JsonElement jsonElement) {
        if (jsonElement.isJsonArray()) {
            ArrayList arrayList = new ArrayList();
            Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
            while (it.hasNext()) {
                arrayList.add(read(it.next()));
            }
            return arrayList;
        } else if (jsonElement.isJsonObject()) {
            LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
            for (Map.Entry next : jsonElement.getAsJsonObject().entrySet()) {
                linkedTreeMap.put((String) next.getKey(), read((JsonElement) next.getValue()));
            }
            return linkedTreeMap;
        } else if (!jsonElement.isJsonPrimitive()) {
            return null;
        } else {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isBoolean()) {
                return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
            }
            if (asJsonPrimitive.isString()) {
                return asJsonPrimitive.getAsString();
            }
            if (!asJsonPrimitive.isNumber()) {
                return null;
            }
            Number asNumber = asJsonPrimitive.getAsNumber();
            if (Math.ceil(asNumber.doubleValue()) == ((double) asNumber.longValue())) {
                return Long.valueOf(asNumber.longValue());
            }
            return Double.valueOf(asNumber.doubleValue());
        }
    }
}
