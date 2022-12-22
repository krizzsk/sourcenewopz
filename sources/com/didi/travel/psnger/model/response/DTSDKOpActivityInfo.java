package com.didi.travel.psnger.model.response;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DTSDKOpActivityInfo extends BaseObject {
    public String iconUrl;
    public String subTitle;
    public String title;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.title = jSONObject.optString("title");
        this.subTitle = jSONObject.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
        this.iconUrl = jSONObject.optString("img");
    }
}
