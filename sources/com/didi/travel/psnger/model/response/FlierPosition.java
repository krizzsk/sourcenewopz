package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class FlierPosition extends BaseObject {
    public String lat;
    public String lng;
    public String msg;
    public int status;
    public int type;
    public String uid;

    public String toString() {
        return "-- passenger_id = " + this.uid + "-- status = " + this.msg + "-- type = " + this.type + "-- lng = " + this.lng + "-- lat = " + this.lat + "-- msg = " + this.msg;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.lng = jSONObject.optString("lng");
                this.lat = jSONObject.optString("lat");
                this.msg = jSONObject.optString("msg");
                this.type = jSONObject.optInt("type");
                this.uid = jSONObject.optString("uid");
                this.status = jSONObject.optInt("status");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
