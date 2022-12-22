package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class OrderDetailUpdateWayPoint extends BaseObject {
    public int updateIsOk = 1;
    public String updateText;
    public String updateTitle;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.updateText = jSONObject.optString("text");
            this.updateTitle = jSONObject.optString("title");
            this.updateIsOk = jSONObject.optInt("is_disable", 1);
        }
    }
}
