package com.didi.travel.psnger.model.response.anycar;

import com.didi.travel.psnger.model.response.estimate.CarExtraLogModel;
import com.didi.travel.psnger.model.response.estimate.OrderParams;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

public class AnyCarExtraData {
    @SerializedName("log")
    public JsonObject extraLogObject;
    @SerializedName("order_params")
    public JsonObject orderParamsObject;

    public OrderParams getOrderParams() {
        if (this.orderParamsObject != null) {
            return (OrderParams) new Gson().fromJson(this.orderParamsObject.toString(), OrderParams.class);
        }
        return null;
    }

    public CarExtraLogModel getExtraLog() {
        if (this.extraLogObject != null) {
            return (CarExtraLogModel) new Gson().fromJson(this.extraLogObject.toString(), CarExtraLogModel.class);
        }
        return null;
    }

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

    public void putAllExtraLog(Map<String, Object> map) {
        if (this.extraLogObject != null) {
            try {
                map.putAll((HashMap) new Gson().fromJson((JsonElement) this.extraLogObject, new TypeToken<HashMap<String, Object>>() {
                }.getType()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
