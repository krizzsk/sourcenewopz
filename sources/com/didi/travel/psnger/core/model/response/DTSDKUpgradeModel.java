package com.didi.travel.psnger.core.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DTSDKUpgradeModel extends BaseObject {
    public String bgColorFrom = "";
    public String bgColorTo = "";
    public String icon = "";
    public String text = "";

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.icon = jSONObject.optString("icon");
            this.text = jSONObject.optString("text");
            this.bgColorFrom = jSONObject.optString("bg_color_from");
            this.bgColorTo = jSONObject.optString("bg_color_to");
        }
    }

    public String toString() {
        return "DTSDKUpgradeModel{icon='" + this.icon + '\'' + ", text='" + this.text + '\'' + ", bgColorFrom='" + this.bgColorFrom + '\'' + ", bgColorTo='" + this.bgColorTo + '\'' + '}';
    }
}
