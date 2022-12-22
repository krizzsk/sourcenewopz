package com.didi.component.homedestination.model;

import com.didi.global.globalgenerickit.GGKData;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class HomeCouponAssistantModel extends BaseObject {
    public GGKData ggkData;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        GGKData gGKData = new GGKData();
        this.ggkData = gGKData;
        gGKData.parse(optJSONObject);
    }
}
