package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class MisBannerResponse extends BaseObject {
    public MisBannerData bannerData;
    private String[] resourceArray;
    private String[] sidArray;
    public String version;

    public MisBannerResponse(String[] strArr, String[] strArr2) {
        this.resourceArray = strArr;
        this.sidArray = strArr2;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.version = jSONObject.optString("__version", "0");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            MisBannerData misBannerData = new MisBannerData(this.resourceArray, this.sidArray);
            this.bannerData = misBannerData;
            misBannerData.parse(optJSONObject);
        }
    }
}
