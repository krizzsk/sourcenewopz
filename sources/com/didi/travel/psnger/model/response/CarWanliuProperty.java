package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarWanliuProperty extends BaseObject {
    public int userType;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        if (jSONObject.has("user_info") && (optJSONObject = jSONObject.optJSONObject("user_info")) != null) {
            this.userType = optJSONObject.optInt("user_type", 1);
        }
    }
}
