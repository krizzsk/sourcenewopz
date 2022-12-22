package com.didi.travel.psnger.model.response.anycar;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnyCarGroup implements BffGsonStruct {
    public AnyCarGroupConfig config;
    public List<AnyCarEstimateNetModel> group;
    @SerializedName("recommend_daily")
    public AnyCarRecommendDaily recommendDaily;

    public static class AnyCarRecommendDaily implements BffGsonStruct {
        @SerializedName("bg_icon")
        public String bgIcon;
        public LEGORichInfo content;
    }

    public static class AnyCarGroupConfig implements BffGsonStruct {
        @SerializedName("order_params")
        public JsonObject orderParamsObject;

        public void putOrderParams(Map<String, Object> map) {
            if (this.orderParamsObject != null) {
                try {
                    map.putAll((HashMap) new Gson().fromJson((JsonElement) this.orderParamsObject, new TypeToken<HashMap<String, Object>>() {
                    }.getType()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
