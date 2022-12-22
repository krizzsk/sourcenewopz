package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarUpdateFrontMsg extends BaseObject {
    public String goNowTxt;
    public String recReason;
    public String title;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.title = jSONObject.optString("title");
        this.recReason = jSONObject.optString("rec_reason");
        this.goNowTxt = jSONObject.optString("go_now_txt");
    }
}
