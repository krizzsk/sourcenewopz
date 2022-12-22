package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class ActivityResInfo extends BaseObject {
    public int activityId;
    public String content;
    public String json;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject.has("data")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.activityId = optJSONObject.optInt("activity_id");
                this.content = optJSONObject.optString("content");
            } else {
                return;
            }
        }
        this.json = jSONObject.toString();
    }
}
