package com.didi.travel.psnger.core.model.response;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DTSDKLabelInfo extends BaseObject {
    public String bgColor;
    public String requireTitle;
    public String textColor;
    public String title;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.textColor = jSONObject.optString("color");
            this.bgColor = jSONObject.optString(BlocksConst.WIDGET_PARAMS_BG_COLOR);
            this.requireTitle = jSONObject.optString("require_title");
        }
    }
}
