package com.didi.component.common.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CPFBlockingModel extends BaseObject {
    public boolean is_allow;
    public String pid_group_name;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.is_allow = optJSONObject.optBoolean("is_allow");
            this.pid_group_name = optJSONObject.optString("pid_group_name");
        }
    }
}
