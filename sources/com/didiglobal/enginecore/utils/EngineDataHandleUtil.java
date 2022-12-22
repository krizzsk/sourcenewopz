package com.didiglobal.enginecore.utils;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class EngineDataHandleUtil {
    public static JsonObject reconstructOriginData(List<String> list, JsonObject jsonObject) {
        JsonObject jsonObject2 = new JsonObject();
        if (list == null) {
            list = new ArrayList<>();
        }
        for (String next : list) {
            jsonObject2.add(next, jsonObject.get(next));
        }
        return jsonObject2;
    }
}
