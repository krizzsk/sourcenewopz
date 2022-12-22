package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class TravelInfoMsg extends BaseObject {
    public String content;
    public int status;
    public String title;
    public int type;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.status = jSONObject.optInt("status");
            this.title = jSONObject.optString("title");
            this.content = jSONObject.optString("content");
        }
    }

    public String toString() {
        return "-- title = " + this.title + "-- content = " + this.content + "-- type = " + this.type + "-- status = " + this.status;
    }
}
