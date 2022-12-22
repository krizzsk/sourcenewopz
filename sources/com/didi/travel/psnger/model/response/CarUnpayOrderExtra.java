package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarUnpayOrderExtra extends BaseObject {
    public String role;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        this.role = jSONObject.optString("role");
    }
}
