package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import org.json.JSONObject;

public class DonateInfo extends BaseObject {
    public String clickUrl;
    public String imageUrl;
    public String title;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.title = jSONObject.optString("text");
                this.imageUrl = jSONObject.optString(Constants.BACKGROUND);
                this.clickUrl = jSONObject.optString("url");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
