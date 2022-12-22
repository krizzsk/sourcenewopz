package com.didi.travel.psnger.core.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DTSDKStriveInfo extends BaseObject {
    public int priority_strive;
    public String strive_msg;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.priority_strive = jSONObject.optInt("priority_strive", 0);
            this.strive_msg = jSONObject.optString("strive_msg");
        }
    }
}
