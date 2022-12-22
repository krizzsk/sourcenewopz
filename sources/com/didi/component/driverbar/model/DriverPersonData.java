package com.didi.component.driverbar.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DriverPersonData extends BaseObject {
    public String avatar = "";
    public LEGORichInfo nameInfo;
    public LEGORichInfo orderCount;
    public LEGORichInfo score;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        super.parse(jSONObject);
        if (jSONObject != null) {
            if (jSONObject.has("name") && (optJSONObject3 = jSONObject.optJSONObject("name")) != null) {
                LEGORichInfo lEGORichInfo = new LEGORichInfo();
                this.nameInfo = lEGORichInfo;
                lEGORichInfo.setInfo(optJSONObject3.toString());
            }
            this.avatar = jSONObject.optString("avatar");
            if (jSONObject.has("score") && (optJSONObject2 = jSONObject.optJSONObject("score")) != null) {
                LEGORichInfo lEGORichInfo2 = new LEGORichInfo();
                this.score = lEGORichInfo2;
                lEGORichInfo2.setInfo(optJSONObject2.toString());
            }
            if (jSONObject.has("order_count") && (optJSONObject = jSONObject.optJSONObject("order_count")) != null) {
                LEGORichInfo lEGORichInfo3 = new LEGORichInfo();
                this.orderCount = lEGORichInfo3;
                lEGORichInfo3.setInfo(optJSONObject.toString());
            }
        }
    }
}
