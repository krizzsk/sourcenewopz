package com.didi.component.phoneentrance.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class SheetOption extends BaseObject {
    public String text = "";
    public int type = 0;
    public String url = "";

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.text = jSONObject.optString("text");
            this.type = jSONObject.optInt("type");
            this.url = jSONObject.optString("url");
        }
    }
}
