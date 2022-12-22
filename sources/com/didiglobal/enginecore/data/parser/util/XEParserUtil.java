package com.didiglobal.enginecore.data.parser.util;

import com.didiglobal.enginecore.data.parser.XEParseConst;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

public class XEParserUtil {
    public static String optString(JSONObject jSONObject, String str, String str2) {
        return (jSONObject == null || jSONObject.isNull(str)) ? str2 : jSONObject.optString(str, str2);
    }

    public static int getAsInt(String str, JsonObject jsonObject, int i) {
        if (!jsonObject.has(str)) {
            return i;
        }
        try {
            return jsonObject.get(str).getAsInt();
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static boolean getAsBoolean(String str, JsonObject jsonObject, boolean z) {
        if (!jsonObject.has(str)) {
            return z;
        }
        try {
            return jsonObject.get(str).getAsBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static String getAsString(String str, JsonObject jsonObject, String str2) {
        if (!jsonObject.has(str)) {
            return str2;
        }
        try {
            return jsonObject.get(str).getAsString();
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static JSONObject parseJSONObject(JsonObject jsonObject) {
        try {
            return new JSONObject((jsonObject == null || jsonObject.getAsJsonObject() == null) ? "" : jsonObject.getAsJsonObject().toString());
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JsonArray getAsArray(String str, JsonObject jsonObject) {
        if (jsonObject == null || !jsonObject.has(str)) {
            return null;
        }
        try {
            return jsonObject.get(str).getAsJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JsonObject getAsObject(String str, JsonObject jsonObject) {
        if (!jsonObject.has(str)) {
            return null;
        }
        try {
            return jsonObject.get(str).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isDeferDispatch(JsonObject jsonObject) {
        if (!jsonObject.has("normal") || !jsonObject.getAsJsonObject("normal").has(XEParseConst.XE_JSON_KEY_UI_CONFIG) || getAsInt(XEParseConst.XE_JSON_KEY_DEFER_DISPATCH, jsonObject.getAsJsonObject("normal").getAsJsonObject(XEParseConst.XE_JSON_KEY_UI_CONFIG), 0) != 1) {
            return false;
        }
        return true;
    }

    public static void removeDeferSign(JsonObject jsonObject) {
        if (jsonObject.has("normal") && jsonObject.getAsJsonObject("normal").has(XEParseConst.XE_JSON_KEY_UI_CONFIG)) {
            jsonObject.getAsJsonObject("normal").getAsJsonObject(XEParseConst.XE_JSON_KEY_UI_CONFIG).remove(XEParseConst.XE_JSON_KEY_DEFER_DISPATCH);
        }
    }

    public static void addChildModifySign(JsonObject jsonObject) {
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(XEParseConst.UPDATE_TYPE_TAG, (Number) 0);
        jsonObject2.addProperty(XEParseConst.PRE_NODE_TAG, "");
        jsonObject.add(XEParseConst.CHILD_UPDATE_MODE_TAG, jsonObject2);
    }

    public static void addUpdateSign(JsonObject jsonObject, int i) {
        if (jsonObject.has(XEParseConst.COMPONENT_ATTRIBUTE)) {
            jsonObject.remove(XEParseConst.COMPONENT_ATTRIBUTE);
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(XEParseConst.UPDATE_MODE, (Number) Integer.valueOf(i));
        jsonObject.add(XEParseConst.COMPONENT_ATTRIBUTE, jsonObject2);
    }

    public static boolean isUpdateChildMode(JsonObject jsonObject) {
        JsonObject asJsonObject;
        if (jsonObject == null || (asJsonObject = jsonObject.getAsJsonObject(XEParseConst.COMPONENT_ATTRIBUTE)) == null || getAsInt(XEParseConst.UPDATE_MODE, asJsonObject, 0) != 1) {
            return false;
        }
        return true;
    }

    public static JsonObject getChildCompUpdateType(JsonObject jsonObject) {
        if (jsonObject == null || !jsonObject.has(XEParseConst.CHILD_UPDATE_MODE_TAG)) {
            return null;
        }
        return jsonObject.getAsJsonObject(XEParseConst.CHILD_UPDATE_MODE_TAG);
    }
}
