package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarQuestionNaire extends BaseObject {
    private static final long serialVersionUID = 1;
    public String url;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.url = jSONObject.optString("url");
    }

    public String toString() {
        return "CarQuestionNaire{url='" + this.url + '\'' + '}';
    }
}
