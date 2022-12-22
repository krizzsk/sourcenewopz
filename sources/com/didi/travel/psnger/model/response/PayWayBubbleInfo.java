package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class PayWayBubbleInfo extends BaseObject {
    public static final int ACTION_TYPE_BIND_CARD = 3;
    public static final int ACTION_TYPE_PAYWAY_SELECT = 2;
    public static final int ACTION_TYPE_SWITCH_PAYWAY = 1;
    public static final int STYLE_NEW = 1;
    public int actionType;
    public String discount;
    public String discountMsg;
    public int payTag;
    public int style;
    public String text;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.discount = jSONObject.optString("discount");
            this.text = jSONObject.optString("text");
            this.actionType = jSONObject.optInt("action_type");
            this.payTag = jSONObject.optInt("pay_tag");
            this.discountMsg = jSONObject.optString("discount_msg");
            this.style = jSONObject.optInt("style");
        }
    }
}
