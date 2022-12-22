package com.didi.travel.psnger.model.response.estimate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

public class EstimateAbnormalModel {
    @SerializedName("cdn")
    public String abmormalCdn;
    @SerializedName("content")
    public String abnormalContent;
    @SerializedName("icon")
    public String abnormalIcon;
    @SerializedName("title")
    public String abnormalTitle;
    @SerializedName("type")
    public String abnormalType;
    @SerializedName("extension")
    public Extension mExtension;

    public static class Extension {
        @SerializedName("log_data")
        public JsonObject mLogData;
    }

    public Map<String, Object> getExtraLog() {
        Extension extension = this.mExtension;
        if (extension == null || extension.mLogData == null) {
            return null;
        }
        try {
            return (Map) new Gson().fromJson((JsonElement) this.mExtension.mLogData, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
