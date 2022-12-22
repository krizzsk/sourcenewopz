package com.didi.travel.psnger.biz.waitornot;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyWaitPerception extends BaseObject {
    private String errmsg;
    private int errno;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
            this.errno = jSONObject2.optInt("errno");
            this.errmsg = jSONObject2.optString("errmsg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getErrno() {
        return this.errno;
    }

    public String getFrontMsg() {
        String str = this.errmsg;
        if (str != null) {
            return str;
        }
        this.errmsg = "";
        return "";
    }
}
