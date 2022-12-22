package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONException;
import org.json.JSONObject;

public class BookingOrderModel extends BaseObject {
    private String mDistanceInfo;
    private String mMoreInfo;

    public void parse(String str) {
        super.parse(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mDistanceInfo = jSONObject.optString("distance_info");
            this.mMoreInfo = jSONObject.optString("more_info");
            setDistanceInfo(this.mDistanceInfo);
            setMoreInfo(this.mMoreInfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getDistanceInfo() {
        return this.mDistanceInfo;
    }

    public void setDistanceInfo(String str) {
        this.mDistanceInfo = str;
    }

    public String getMoreInfo() {
        return this.mMoreInfo;
    }

    public void setMoreInfo(String str) {
        this.mMoreInfo = str;
    }
}
