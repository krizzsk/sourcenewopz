package com.didi.travel.psnger.core.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DTSDKCurrency extends BaseObject {
    public String abbr;
    public String symbol;
    public String unit;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.abbr = jSONObject.optString("abbr");
            this.symbol = jSONObject.optString("symbol");
            this.unit = jSONObject.optString("unit");
        }
    }
}
