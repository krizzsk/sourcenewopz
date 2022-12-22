package com.didi.component.matchtogo20.ontrip.model;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class MatchOnTripModel extends BaseObject {
    public String button_content;
    public int enable_button_time;
    private boolean hasContent = false;
    public String main_content;
    public String main_icon_url;
    public String sub_content;
    public String sub_icon_url;

    public boolean isAvailable() {
        return this.errno == 0;
    }

    public boolean isHasContent() {
        return this.hasContent;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject.has("normal")) {
            jSONObject = jSONObject.optJSONObject("normal");
        }
        if (jSONObject.has("data")) {
            jSONObject = jSONObject.optJSONObject("data");
            this.hasContent = true;
        }
        this.main_content = jSONObject.optString(BlocksConst.WIDGET_PARAMS_MAIN_CONTENT);
        this.sub_content = jSONObject.optString(BlocksConst.WIDGET_PARAMS_SUB_CONTENT);
        this.button_content = jSONObject.optString("button_content");
        this.main_icon_url = jSONObject.optString("main_icon_url");
        this.sub_icon_url = jSONObject.optString("sub_icon_url");
        this.enable_button_time = jSONObject.optInt("enable_button_time");
    }

    public String toString() {
        return "WaitAcceptModel{, main_content='" + this.main_content + '\'' + ", sub_content='" + this.sub_content + '\'' + ", button_content='" + this.button_content + '\'' + ", main_icon_url='" + this.main_icon_url + '\'' + ", sub_icon_url='" + this.sub_icon_url + '\'' + ", enable_button_time=" + this.enable_button_time + '}';
    }
}
