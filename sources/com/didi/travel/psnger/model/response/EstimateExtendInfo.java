package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class EstimateExtendInfo extends BaseObject {
    public static final int TYPE_REPLACE = 1;
    public String desc;
    public int type;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.desc = jSONObject.optString("desc");
            this.type = jSONObject.optInt("extend_type");
        }
    }
}
