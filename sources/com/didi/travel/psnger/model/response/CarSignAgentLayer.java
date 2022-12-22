package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarSignAgentLayer extends BaseObject {
    public String cancelLabel;
    public String confirmLabel;
    public String content;
    public String subTitle;
    public String title;
    public int type;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject.optInt("type") == 1) {
            this.type = 133;
        } else if (jSONObject.optInt("type") == 2) {
            this.type = 134;
        }
        this.title = jSONObject.optString("bind_title");
        this.subTitle = jSONObject.optString("bind_subject");
        this.content = jSONObject.optString("bind_msg");
        this.confirmLabel = jSONObject.optString("button_confirm");
        this.cancelLabel = jSONObject.optString("button_cancel");
    }
}
