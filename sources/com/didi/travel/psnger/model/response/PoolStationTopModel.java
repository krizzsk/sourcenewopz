package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class PoolStationTopModel extends BaseObject {
    public FlierPoolStationModel stationModel;

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        if (jSONObject != null && jSONObject.has("station_info") && (optJSONObject = jSONObject.optJSONObject("station_info")) != null) {
            FlierPoolStationModel flierPoolStationModel = new FlierPoolStationModel();
            this.stationModel = flierPoolStationModel;
            flierPoolStationModel.parse(optJSONObject);
        }
    }
}
