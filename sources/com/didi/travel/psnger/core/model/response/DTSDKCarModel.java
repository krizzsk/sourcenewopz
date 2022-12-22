package com.didi.travel.psnger.core.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import org.json.JSONObject;

public class DTSDKCarModel extends BaseObject {
    public String car3DImageZip;
    public String carBrand;
    public String carBrandSubType;
    public String carColor;
    public String carImage;
    public String carLabel;
    public String carMapImage;
    public int passengerCount;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.carMapImage = jSONObject.optString("car_map_image_v2");
            this.carBrand = jSONObject.optString("car_brand");
            this.carColor = jSONObject.optString("car_color");
            this.carLabel = jSONObject.optString("car_label");
            this.carImage = jSONObject.optString("car_image");
            this.carBrandSubType = jSONObject.optString("car_series");
            this.passengerCount = jSONObject.optInt(ParamKeys.PARAM_PASSENGER_COUNT);
            this.car3DImageZip = jSONObject.optString("car_map_zip");
        }
    }
}
