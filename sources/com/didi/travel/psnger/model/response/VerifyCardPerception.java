package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONException;
import org.json.JSONObject;

public class VerifyCardPerception extends BaseObject {
    private int code;
    private String frontMsg;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
            this.code = jSONObject2.optInt("code");
            this.frontMsg = jSONObject2.optString("frontMsg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getCode() {
        return this.code;
    }

    public String getFrontMsg() {
        String str = this.frontMsg;
        if (str != null) {
            return str;
        }
        this.frontMsg = "";
        return "";
    }
}
