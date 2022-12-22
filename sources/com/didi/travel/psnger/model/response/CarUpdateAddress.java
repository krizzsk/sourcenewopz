package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarUpdateAddress extends BaseObject {
    public String address;
    public double lat;
    public double lng;
    public String name;
    public String poiId;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.address = jSONObject.optString("address");
        this.name = jSONObject.optString("name");
        this.lat = jSONObject.optDouble("lat");
        this.lng = jSONObject.optDouble("lng");
        this.poiId = jSONObject.optString("poi_id");
    }
}
