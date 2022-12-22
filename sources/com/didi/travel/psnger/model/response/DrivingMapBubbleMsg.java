package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import org.json.JSONObject;

public class DrivingMapBubbleMsg extends BaseObject {
    public int bubbleType;
    public String carpooOid;
    public int carpool_index;
    public String msg;
    public int positionType;
    public int totalTime;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.positionType = jSONObject.optInt("position_type");
            this.bubbleType = jSONObject.optInt(ParamKeys.PARAM_BUBBLE_TYPE);
            if (jSONObject.has("bubble_data")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("bubble_data");
                this.msg = optJSONObject.optString("msg");
                this.carpool_index = optJSONObject.optInt("carpool_index");
                this.carpooOid = optJSONObject.optString("carpool_oid");
                this.totalTime = optJSONObject.optInt("total_countdown");
            }
        }
    }
}
