package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CarHasEvaluateData extends BaseObject {
    public String content;
    public int isCommented;
    public String level_text;
    public String negative_text;
    public String refine_guide;
    public int score;
    public List<CarNoEvaluateData.EvaluateTagImpl> tags;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            this.isCommented = jSONObject2.optInt("isCommented");
            this.score = jSONObject2.optInt("score");
            this.tags = new ArrayList();
            JSONArray jSONArray = jSONObject2.getJSONArray("tag_list");
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    CarNoEvaluateData.EvaluateTagImpl evaluateTagImpl = new CarNoEvaluateData.EvaluateTagImpl();
                    evaluateTagImpl.parse(jSONArray.optString(i));
                    this.tags.add(evaluateTagImpl);
                }
            }
            this.content = jSONObject2.optString("content");
            this.level_text = jSONObject2.optString("level_text");
            this.negative_text = jSONObject2.optString("negative_text");
            this.refine_guide = jSONObject2.optString("refine_guide");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
