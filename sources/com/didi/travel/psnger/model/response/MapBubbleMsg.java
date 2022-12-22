package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class MapBubbleMsg extends BaseObject {
    public String msg;
    public String orderId;
    public int type;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.orderId = jSONObject.optString("order_id");
            this.msg = jSONObject.optString("msg");
            this.type = jSONObject.optInt("type");
        }
    }

    public MapBubbleMsg() {
    }

    public MapBubbleMsg(String str, int i, String str2) {
        this.msg = str;
        this.type = i;
        this.orderId = str2;
    }

    public String toString() {
        return "-- orderId = " + this.orderId + "-- msg = " + this.msg + "-- type = " + this.type;
    }
}
