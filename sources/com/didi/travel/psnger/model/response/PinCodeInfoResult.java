package com.didi.travel.psnger.model.response;

import com.didi.component.common.net.CarServerParam;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONObject;

public class PinCodeInfoResult extends BaseObject {
    public String avatar;
    public String carLevel;
    public String carTitle;
    public String driverId;
    public String driverLat;
    public String driverLng;
    public String driverName;
    public String driverProductId;
    public String licenseNum;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != JSONObject.NULL && optJSONObject != null) {
            this.driverName = optJSONObject.optString("name");
            this.licenseNum = optJSONObject.optString("license_num");
            this.carTitle = optJSONObject.optString("car_title");
            this.carLevel = optJSONObject.optString("car_level");
            this.avatar = optJSONObject.optString("avatar");
            this.driverId = optJSONObject.optString(CarServerParam.PARAM_DRIVER_ID);
            this.driverProductId = optJSONObject.optString("driver_product_id");
            this.driverLat = optJSONObject.optString("lat");
            this.driverLng = optJSONObject.optString("lng");
        }
    }

    public String toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", this.driverName);
        jsonObject.addProperty("license_num", this.licenseNum);
        jsonObject.addProperty("car_title", this.carTitle);
        jsonObject.addProperty("car_level", this.carLevel);
        jsonObject.addProperty("avatar", this.avatar);
        jsonObject.addProperty(CarServerParam.PARAM_DRIVER_ID, this.driverId);
        jsonObject.addProperty("driver_product_id", this.driverProductId);
        jsonObject.addProperty("lng", this.driverLng);
        jsonObject.addProperty("lat", this.driverLat);
        return new Gson().toJson((JsonElement) jsonObject);
    }
}
