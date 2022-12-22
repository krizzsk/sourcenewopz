package com.didi.component.driverbar.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DriverBarBenefitModel extends BaseObject {
    public String benefitLink = "";
    public String colorEnd = "";
    public String colorStar = "";
    public String icon = "";
    public LEGORichInfo info;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.icon = jSONObject.optString("icon");
            if (jSONObject.has("info") && (optJSONObject = jSONObject.optJSONObject("info")) != null) {
                LEGORichInfo lEGORichInfo = new LEGORichInfo();
                this.info = lEGORichInfo;
                lEGORichInfo.setInfo(optJSONObject.toString());
            }
            this.colorStar = jSONObject.optString("color_start");
            this.colorEnd = jSONObject.optString("color_end");
            this.benefitLink = jSONObject.optString("link");
        }
    }
}
