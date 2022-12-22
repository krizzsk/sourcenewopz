package com.didi.travel.psnger.model.response.estimate;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class BubbleSelectResponse extends BaseObject {
    public String bubbleId = "";

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.bubbleId = optJSONObject.optString("bubble_id", "");
        }
    }
}
