package com.didi.component.cancelbar;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CancelTextModel extends BaseObject {
    public LEGORichInfo btnInfo = new LEGORichInfo();
    public String url;

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.btnInfo.setInfo(optJSONObject.optString("title"));
            this.url = optJSONObject.optString("url");
        }
    }
}
