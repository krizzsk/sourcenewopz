package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class PayMethodInfoResult extends BaseObject {
    public boolean checkResult;
    public String openRideBrand;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject != JSONObject.NULL) {
            this.checkResult = optJSONObject.optBoolean("pay_method_check_result");
            this.openRideBrand = optJSONObject.optString("open_ride_brand");
        }
    }
}
