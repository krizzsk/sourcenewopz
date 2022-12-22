package com.didi.component.carpool.info.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class WaitLinePointData extends BaseObject {
    public String content = "";
    public int showDotLine = 0;
    public int staus = 2;
    public String title = "";
    public int type = 0;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            try {
                if (jSONObject.has("type")) {
                    this.type = jSONObject.optInt("type");
                }
                if (jSONObject.has("status")) {
                    this.staus = jSONObject.optInt("status");
                }
                if (jSONObject.has("title")) {
                    this.title = jSONObject.optString("title");
                }
                if (jSONObject.has("content")) {
                    this.content = jSONObject.optString("content");
                }
                if (jSONObject.has("show_dot_line")) {
                    this.showDotLine = jSONObject.optInt("show_dot_line");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
