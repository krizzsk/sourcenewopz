package com.didi.component.carpool.info.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class TravelInfoMsg extends BaseObject {
    public String content;
    public int showDotLine = 0;
    public int status = 2;
    public String title;
    public int type;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            if (jSONObject.has("status")) {
                this.status = jSONObject.optInt("status");
            }
            this.title = jSONObject.optString("title");
            this.content = jSONObject.optString("content");
            this.showDotLine = jSONObject.optInt("show_dot_line");
        }
    }

    public String toString() {
        return "-- title = " + this.title + "-- content = " + this.content + "-- type = " + this.type + "-- status = " + this.status;
    }
}
