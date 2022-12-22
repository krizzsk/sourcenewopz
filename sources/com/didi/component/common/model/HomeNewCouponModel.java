package com.didi.component.common.model;

import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class HomeNewCouponModel extends BaseObject {
    public String buttonText;
    public List<CouponInfo> couponInfos;
    public String topText;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("cover_coupon")) != null) {
            this.topText = optJSONObject.optString("top_text");
            this.buttonText = optJSONObject.optString("button_text");
            JSONArray optJSONArray = optJSONObject.optJSONArray(ParamConst.PARAM_COUPON_INFO);
            if (optJSONArray != null && optJSONArray.length() != 0) {
                this.couponInfos = new JsonUtil().parseJSONArray(optJSONArray, new CouponInfo());
            }
        }
    }

    public static class CouponInfo extends BaseObject {
        public String couponText;
        public String tipText;
        public String titleText;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.titleText = jSONObject.optString("title_text");
                this.couponText = jSONObject.optString("coupon_text");
                this.tipText = jSONObject.optString("tip_text");
            }
        }
    }
}
