package com.didi.sdk.oneconf;

import com.didi.sdk.push.http.BaseObject;
import com.didi.soda.customer.app.constant.Const;
import org.json.JSONObject;

public class OneConfData extends BaseObject {
    public int cityId = -1;
    public int countryId = -1;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.cityId = optJSONObject.optInt("cityId", this.countryId);
            this.countryId = optJSONObject.optInt(Const.H5Params.COUNTRYID, this.countryId);
        }
    }

    public String toString() {
        return "cityId:" + this.cityId + "  countryId:" + this.countryId;
    }
}
