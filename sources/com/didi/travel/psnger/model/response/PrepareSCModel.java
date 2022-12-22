package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONException;
import org.json.JSONObject;

public class PrepareSCModel extends BaseObject {
    public static final int TAG_DRIVER_ARRIVED_EARLY = 1;
    public int appVibrate;
    public int isArrivedEarly;
    public int isServiceControl;
    public String pushTipsBubble;
    public String pushTipsPassengerLate;
    public String pushTipsPassengerLateBubble;
    public int serviceControlWaitTime;

    public void parse(String str) {
        super.parse(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.pushTipsBubble = jSONObject.optString("pushTips_bubble");
            this.isServiceControl = jSONObject.optInt("is_service_control");
            this.serviceControlWaitTime = jSONObject.optInt("service_control_wait_time");
            this.pushTipsPassengerLate = jSONObject.optString("pushTips_passenger_late");
            this.pushTipsPassengerLateBubble = jSONObject.optString("pushTips_passenger_late_bubble");
            this.isArrivedEarly = jSONObject.optInt("not_arrived_right_pos");
            this.appVibrate = jSONObject.optInt("vibrate_tag");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject buildOnRecommonMsg(JSONObject jSONObject, PrepareSCModel prepareSCModel) {
        try {
            jSONObject.put("pushTips_bubble", prepareSCModel.pushTipsBubble);
            jSONObject.put("is_service_control", prepareSCModel.isServiceControl);
            jSONObject.put("service_control_wait_time", prepareSCModel.serviceControlWaitTime);
            jSONObject.put("pushTips_passenger_late", prepareSCModel.pushTipsPassengerLate);
            jSONObject.put("pushTips_passenger_late_bubble", prepareSCModel.pushTipsPassengerLateBubble);
            jSONObject.put("not_arrived_right_pos", prepareSCModel.isArrivedEarly);
            jSONObject.put("vibrate_tag", prepareSCModel.appVibrate);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "PrepareSCModel{pushTipsBubble='" + this.pushTipsBubble + '\'' + ", isServiceControl=" + this.isServiceControl + ", serviceControlWaitTime=" + this.serviceControlWaitTime + ", pushTipsPassengerLate='" + this.pushTipsPassengerLate + '\'' + ", pushTipsPassengerLateBubble='" + this.pushTipsPassengerLateBubble + '\'' + ", isArrivedEarly='" + this.isArrivedEarly + '\'' + '}';
    }
}
