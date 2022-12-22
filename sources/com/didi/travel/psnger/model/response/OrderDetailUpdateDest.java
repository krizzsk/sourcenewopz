package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class OrderDetailUpdateDest extends BaseObject {
    public int updateDestIsOk = 1;
    public String updateDestText;
    public String updateDestTitle;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.updateDestText = jSONObject.optString("text");
            this.updateDestTitle = jSONObject.optString("title");
            this.updateDestIsOk = jSONObject.optInt("is_disable", 1);
        }
    }
}
