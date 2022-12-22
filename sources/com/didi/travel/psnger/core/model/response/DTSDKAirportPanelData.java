package com.didi.travel.psnger.core.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import org.json.JSONObject;

public class DTSDKAirportPanelData extends BaseObject {
    public String fromArea;
    public String guideUrl;
    public String subText;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.fromArea = jSONObject.optString(ParamKeys.PARAM_FROM_AREA);
            this.guideUrl = jSONObject.optString("guide_url");
            this.subText = jSONObject.optString("sub_text");
        }
    }
}
