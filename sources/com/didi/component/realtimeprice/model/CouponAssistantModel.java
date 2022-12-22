package com.didi.component.realtimeprice.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CouponAssistantModel extends BaseObject {
    public String color_bg_end;
    public String color_bg_start;
    public String color_text;
    public String icon_url;
    public String text;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.icon_url = jSONObject.optString("icon_url");
        this.color_bg_start = jSONObject.optString("color_bg_start");
        this.color_bg_end = jSONObject.optString("color_bg_end");
        this.color_text = jSONObject.optString("color_text");
        this.text = jSONObject.optString("text");
    }
}
