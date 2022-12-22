package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class UpdateDestModel extends BaseObject {
    public boolean isHasErrMsg;
    public String text;
    public String title;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        super.parse(jSONObject);
        this.isHasErrMsg = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (optJSONObject2 = optJSONObject.optJSONObject("passenger_alert")) != null) {
            this.isHasErrMsg = true;
            this.title = optJSONObject2.optString("title");
            this.text = optJSONObject2.optString("text");
        }
    }
}
