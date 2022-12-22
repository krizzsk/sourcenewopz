package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class OrderBanPopInfo extends BaseObject {
    public String content;
    public String detailButton;
    public String detailUrl;
    public String okButton;
    public String title;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.title = jSONObject.optString("ban_title");
        this.content = jSONObject.optString("ban_reason");
        this.detailUrl = jSONObject.optString("ban_detail_url");
        this.okButton = jSONObject.optString("sub_button");
        this.detailButton = jSONObject.optString("ban_button");
    }
}
