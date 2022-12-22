package com.didi.component.matchtogo20.wait.model;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class WaitAcceptModel extends BaseObject {
    public String background_icon_url;
    public long call_match_on_trip_time;
    private boolean hasContent = false;
    public String main_content;
    public String main_icon_url;
    public String sub_content;
    public String sub_icon_url;
    public String sub_title;
    public String title;

    public boolean isAvailable() {
        return true;
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
        this.title = jSONObject.optString("title");
        this.sub_title = jSONObject.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
        this.main_content = jSONObject.optString(BlocksConst.WIDGET_PARAMS_MAIN_CONTENT);
        this.sub_content = jSONObject.optString(BlocksConst.WIDGET_PARAMS_SUB_CONTENT);
        this.background_icon_url = jSONObject.optString("background_icon_url");
        this.main_icon_url = jSONObject.optString("main_icon_url");
        this.sub_icon_url = jSONObject.optString("sub_icon_url");
        this.call_match_on_trip_time = jSONObject.optLong("call_match_on_trip_time", 0);
    }

    public String toString() {
        return "WaitAcceptModel{title='" + this.title + '\'' + ", sub_title='" + this.sub_title + '\'' + ", main_content='" + this.main_content + '\'' + ", sub_content='" + this.sub_content + '\'' + ", background_icon_url='" + this.background_icon_url + '\'' + ", main_icon_url='" + this.main_icon_url + '\'' + ", sub_icon_url='" + this.sub_icon_url + '\'' + ", call_match_on_trip_time=" + this.call_match_on_trip_time + '}';
    }
}
