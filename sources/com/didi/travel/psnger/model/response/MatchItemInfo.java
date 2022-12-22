package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class MatchItemInfo extends BaseObject {
    public int degree;
    public String degreeDes;
    public String headUrl;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.headUrl = jSONObject.optString("head_url");
            this.degreeDes = jSONObject.optString("degree_des");
            this.degree = jSONObject.optInt("degree");
        }
    }
}
