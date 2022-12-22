package com.didi.travel.psnger.core.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DTSDKEvaluateModel extends BaseObject {
    public int evaluateMark;
    public int evaluateScore;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.evaluateMark = jSONObject.optInt("status");
            this.evaluateScore = jSONObject.optInt("level");
        }
    }
}
