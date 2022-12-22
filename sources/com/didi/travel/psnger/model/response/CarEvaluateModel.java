package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarEvaluateModel extends BaseObject {
    public int bShowCards;
    public String evaluateContent;
    public int evaluateMark;
    public int evaluateScore;
    public String evaluateTag;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.evaluateScore = jSONObject.optInt("level");
        this.evaluateContent = jSONObject.optString("content");
        this.evaluateTag = jSONObject.optString("cmp_type_txt");
        this.bShowCards = jSONObject.optInt("bShowCards");
    }
}
