package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class EstimatePriceTag extends BaseObject {
    public String priceTagDesc;
    public int priceTagId;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.priceTagDesc = jSONObject.optString("priceTagDesc");
            this.priceTagId = jSONObject.optInt("priceTagId");
        }
    }
}
