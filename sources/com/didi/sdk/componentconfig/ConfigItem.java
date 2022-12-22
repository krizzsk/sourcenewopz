package com.didi.sdk.componentconfig;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ConfigItem implements Serializable {
    @SerializedName("car_level")
    public int carLevel;
    @SerializedName("data")
    private C12149a data;
    @SerializedName("order_type")
    public int orderType;
    @SerializedName("scence")
    public String scene;

    public <T> T getData(Class<T> cls) {
        return new Gson().fromJson(this.data.f35693a, cls);
    }
}
