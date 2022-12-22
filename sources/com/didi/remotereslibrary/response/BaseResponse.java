package com.didi.remotereslibrary.response;

import com.didi.sdk.event.Event;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseResponse implements Event, Serializable {
    public int RESULT_OK = 0;
    protected JSONObject jsonObject;
    public String message;
    private String result;
    public int resultCode;

    public void parser(JSONObject jSONObject) {
    }

    public void parser(String str) {
        try {
            this.result = str;
            JSONObject jSONObject = new JSONObject(str);
            this.jsonObject = jSONObject;
            this.resultCode = jSONObject.optInt("errno", -1);
            this.message = this.jsonObject.optString("errmsg", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getResultData() {
        return this.result;
    }

    public boolean isSuccess() {
        return this.resultCode == this.RESULT_OK;
    }
}
