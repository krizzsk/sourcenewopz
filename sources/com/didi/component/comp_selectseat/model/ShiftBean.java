package com.didi.component.comp_selectseat.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

public class ShiftBean {
    @SerializedName("dropoff")
    public LEGORichInfo dropoff;
    @SerializedName("extension")
    public Extension mExtension;
    @SerializedName("operation_area")
    public JsonObject operationArea;
    @SerializedName("pickup")
    public LEGORichInfo pickup;
    @SerializedName("route_id")
    public String routeId;
    @SerializedName("select_value_params")
    public JsonObject selectValueParam;
    @SerializedName("show_travel_mark")
    public int show_travel_mark;
    @SerializedName("travel_id")
    public String travel_id;

    public static class Extension {
        @SerializedName("log_data")
        public JsonObject mLogData;
    }

    public Map<String, Object> getExtraLog(Map<String, Object> map) {
        Extension extension = this.mExtension;
        if (!(extension == null || extension.mLogData == null)) {
            try {
                map.putAll((HashMap) new Gson().fromJson((JsonElement) this.mExtension.mLogData, new TypeToken<HashMap<String, String>>() {
                }.getType()));
                return map;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
