package com.didi.travel.psnger.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

public class ManualChoiceRecord extends BaseObject {
    @SerializedName("choice_count")
    public int choiceCount;
    @SerializedName("time_stamp")
    public long timeStamp;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.choiceCount = jSONObject.optInt("choice_count", 0);
            this.timeStamp = jSONObject.optLong("time_stamp", 0);
        }
    }
}
