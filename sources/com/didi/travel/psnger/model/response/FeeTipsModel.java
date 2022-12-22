package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class FeeTipsModel extends BaseObject {
    public static final int SHOW_TYPE_CARPOOL = 3;
    public static final int SHOW_TYPE_COMMON = 1;
    public static final int SHOW_TYPE_DONATE = 2;
    private String content;
    private String more;
    private int showType;
    private String title;
    private String url;

    public int getShowType() {
        return this.showType;
    }

    public void setShowType(int i) {
        this.showType = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getMore() {
        return this.more;
    }

    public void setMore(String str) {
        this.more = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.showType = optJSONObject.optInt("show_type");
            this.title = optJSONObject.optString("title");
            this.content = optJSONObject.optString("content");
            this.more = optJSONObject.optString("more");
            this.url = optJSONObject.optString("url");
        }
    }
}
