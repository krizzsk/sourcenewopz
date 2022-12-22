package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class WillingCouponInfo extends BaseObject {
    public String couponValue;
    public String tips;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.couponValue = jSONObject.optString("coupon_value");
        this.tips = jSONObject.optString("tips");
    }
}
