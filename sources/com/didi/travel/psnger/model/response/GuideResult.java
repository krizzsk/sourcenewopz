package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import org.json.JSONObject;

public class GuideResult extends BaseObject {
    public int guideAction;
    public int guideComboType;
    public int guideProduct;
    public String guideRequireLevel;
    public int guideScene;
    public int sourceComboType;
    public int sourceProduct;
    public String sourceRequireLevel;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.sourceProduct = jSONObject.optInt(ParamKeys.PARAM_DIVERSION_SOURCE_PRODUCT);
        this.sourceRequireLevel = jSONObject.optString("source_require_level");
        this.sourceComboType = jSONObject.optInt("source_combo_type");
        this.guideProduct = jSONObject.optInt("guide_product");
        this.guideRequireLevel = jSONObject.optString("guide_require_level");
        this.guideComboType = jSONObject.optInt("guide_combo_type");
        this.guideScene = jSONObject.optInt(ParamKeys.PARAM_DIVERSION_GUIDE_SCENE);
        this.guideAction = jSONObject.optInt("guide_action");
    }
}
