package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarPostOrderModel extends BaseObject {
    public CarExtendInfo carExtendInfo;
    public CarUpdateAddress updateAddress;
    public CarUpdateFrontMsg updateFrontMsg;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject.has("start_front_push_msg")) {
            this.updateFrontMsg = new CarUpdateFrontMsg();
            JSONObject optJSONObject = jSONObject.optJSONObject("start_front_push_msg");
            if (optJSONObject != null) {
                this.updateFrontMsg.parse(optJSONObject);
            }
        }
        if (jSONObject.has("start_poi")) {
            this.updateAddress = new CarUpdateAddress();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("start_poi");
            if (optJSONObject2 != null) {
                this.updateAddress.parse(optJSONObject2);
            }
        }
        if (jSONObject.has("extend_info")) {
            this.carExtendInfo = new CarExtendInfo();
            JSONObject optJSONObject3 = jSONObject.optJSONObject("extend_info");
            if (optJSONObject3 != null) {
                this.carExtendInfo.parse(optJSONObject3);
            }
        }
    }
}
