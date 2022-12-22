package com.didi.travel.psnger.model.response;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CommuteConfig extends BaseObject {
    private String backUrl;
    private String subTitle;
    private String title;
    private String url;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getBackUrl() {
        return this.backUrl;
    }

    public void setBackUrl(String str) {
        this.backUrl = str;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.title = optJSONObject.optString("title");
            this.subTitle = optJSONObject.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
            this.url = optJSONObject.optString("url");
            this.backUrl = optJSONObject.optString("back_url");
        }
    }

    public String toString() {
        return "CommuteConfig{title='" + this.title + '\'' + ", subTitle=" + this.subTitle + ", url='" + this.url + '\'' + ", backUrl=" + this.backUrl + '}';
    }
}
