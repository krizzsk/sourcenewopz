package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class AirportGuideInfo extends BaseObject {
    public String buttonText;
    public String iconUrl;
    public String title;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.iconUrl = jSONObject.optString("icon");
            this.buttonText = jSONObject.optString("button_text");
        }
    }
}
