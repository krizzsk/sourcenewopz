package com.didi.travel.psnger.model.response;

import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class WillWaitInfo extends BaseObject {
    public WillingCouponInfo couponInfo;
    public long leftTime;
    public int likeWait;
    public long waitCountTime;
    public String waitTitle;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.likeWait = jSONObject.optInt("like_wait");
        this.waitCountTime = jSONObject.optLong("count_time");
        this.leftTime = jSONObject.optLong("left_time");
        this.waitTitle = jSONObject.optString("wait_msg_title");
        JSONObject optJSONObject = jSONObject.optJSONObject(ParamConst.PARAM_COUPON_INFO);
        if (optJSONObject != null) {
            WillingCouponInfo willingCouponInfo = new WillingCouponInfo();
            this.couponInfo = willingCouponInfo;
            willingCouponInfo.parse(optJSONObject);
        }
    }

    public void parse(String str) {
        super.parse(str);
    }
}
