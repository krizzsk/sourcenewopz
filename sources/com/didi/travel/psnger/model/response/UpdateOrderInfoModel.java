package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class UpdateOrderInfoModel extends BaseObject {
    public String comeWithChargeTip;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.comeWithChargeTip = jSONObject.optString("remote_dispatch_wait_message");
        }
    }
}
