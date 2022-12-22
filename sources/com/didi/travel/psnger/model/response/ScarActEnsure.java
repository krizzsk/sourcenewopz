package com.didi.travel.psnger.model.response;

import org.json.JSONObject;

public class ScarActEnsure {
    public String banner_img;
    public String content;
    public String content_rgb;
    public String ticket_rbg;

    public void pares(JSONObject jSONObject) {
        this.content_rgb = jSONObject.optString("content_rgb");
        this.ticket_rbg = jSONObject.optString("ticket_rbg");
        this.banner_img = jSONObject.optString("banner_img");
        this.content = jSONObject.optString("content");
    }

    public String toString() {
        return "ScarActEnsure{content_rgb='" + this.content_rgb + '\'' + ", ticket_rbg='" + this.ticket_rbg + '\'' + ", banner_img='" + this.banner_img + '\'' + ", content='" + this.content + '\'' + '}';
    }
}
