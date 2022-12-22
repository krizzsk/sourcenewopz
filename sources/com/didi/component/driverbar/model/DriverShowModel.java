package com.didi.component.driverbar.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DriverShowModel extends BaseObject {
    public DriverCarData carData;
    public DriverPersonData personData;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        super.parse(jSONObject);
        if (jSONObject != null) {
            if (jSONObject.has("car_info") && (optJSONObject2 = jSONObject.optJSONObject("car_info")) != null) {
                DriverCarData driverCarData = new DriverCarData();
                this.carData = driverCarData;
                driverCarData.parse(optJSONObject2);
            }
            if (jSONObject.has("driver_info") && (optJSONObject = jSONObject.optJSONObject("driver_info")) != null) {
                DriverPersonData driverPersonData = new DriverPersonData();
                this.personData = driverPersonData;
                driverPersonData.parse(optJSONObject);
            }
        }
    }
}
