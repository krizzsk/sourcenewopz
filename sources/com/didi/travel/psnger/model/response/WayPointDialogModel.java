package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class WayPointDialogModel extends BaseObject {
    private String content;
    private int type;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.content = jSONObject.optString("text");
            this.type = jSONObject.optInt("type");
        }
    }
}
