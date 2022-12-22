package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class OperationModel extends BaseObject {
    public String countDownMsg;
    public String countDownTime = "0";
    public String extMsg;
    public String extUrl;
    public OperationCancelModel operationCancelModel;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.countDownTime = jSONObject.optString("countdown_time", "0");
        this.countDownMsg = jSONObject.optString("countdown_msg");
        this.extMsg = jSONObject.optString("ext_msg");
        this.extUrl = jSONObject.optString("ext_url");
        if (jSONObject.has("cancel_pop")) {
            OperationCancelModel operationCancelModel2 = new OperationCancelModel();
            this.operationCancelModel = operationCancelModel2;
            operationCancelModel2.parse(jSONObject);
        }
    }
}
