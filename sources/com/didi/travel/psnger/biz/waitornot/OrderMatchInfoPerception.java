package com.didi.travel.psnger.biz.waitornot;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderMatchInfoPerception extends BaseObject {
    private String buttonText;
    private String endText;
    private String endTitle;
    private String pushText;
    private String pushTitle;
    private String text;
    private int time;
    private String title;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject(new JSONObject(jSONObject.optString("data")).optString("nearby_match_info"));
            this.time = jSONObject2.optInt("time");
            this.title = jSONObject2.optString("title");
            this.text = jSONObject2.optString("text");
            this.buttonText = jSONObject2.optString("button_text");
            JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("extra_info"));
            this.endText = jSONObject3.optString("time_end_text");
            this.endTitle = jSONObject3.optString("time_end_title");
            this.pushTitle = jSONObject3.optString("push_title");
            this.pushText = jSONObject3.optString("push_text");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        String str = this.title;
        if (str != null) {
            return str;
        }
        this.title = "";
        return "";
    }

    public int getTime() {
        return this.time;
    }

    public String getButtonText() {
        String str = this.buttonText;
        if (str != null) {
            return str;
        }
        this.buttonText = "";
        return "";
    }

    public String getText() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        this.text = "";
        return "";
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public String getEndText() {
        String str = this.endText;
        if (str != null) {
            return str;
        }
        this.endText = "";
        return "";
    }

    public void setEndText(String str) {
        this.endText = str;
    }

    public String getEndTitle() {
        String str = this.endTitle;
        if (str != null) {
            return str;
        }
        this.endTitle = "";
        return "";
    }

    public void setEndTitle(String str) {
        this.endTitle = str;
    }

    public String getPushTitle() {
        String str = this.pushTitle;
        if (str != null) {
            return str;
        }
        this.pushTitle = "";
        return "";
    }

    public void setPushTitle(String str) {
        this.pushTitle = str;
    }

    public String getPushText() {
        String str = this.pushText;
        if (str != null) {
            return str;
        }
        this.pushText = "";
        return "";
    }

    public void setPushText(String str) {
        this.pushText = str;
    }
}
