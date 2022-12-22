package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarUnderServiceBannerTopInfo extends BaseObject {
    public String content;
    public String icon;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.icon = jSONObject.optString("icon");
        this.content = jSONObject.optString("content");
    }
}
