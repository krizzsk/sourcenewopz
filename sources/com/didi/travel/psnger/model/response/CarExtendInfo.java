package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarExtendInfo extends BaseObject {
    public String goNowText;
    public int isShowCard;
    public String oldStartName;
    public String recReason;
    public String title;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.isShowCard = jSONObject.optInt("is_show_card");
        this.goNowText = jSONObject.optString("go_now_text");
        this.recReason = jSONObject.optString("rec_reason");
        this.title = jSONObject.optString("title");
        this.oldStartName = jSONObject.optString("old_start_name");
    }
}
