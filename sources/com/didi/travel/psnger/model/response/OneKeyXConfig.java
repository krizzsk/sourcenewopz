package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class OneKeyXConfig extends BaseObject {
    public String bannerImage;
    public String bannerLink;
    public int carLevel;
    public int productId;
    public boolean ruleChecked;
    public String ruleText;
    public String ruleUrl;
    public int verifyStatus;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.carLevel = optJSONObject.optInt("car_level");
            this.productId = optJSONObject.optInt("product_id");
            this.bannerImage = optJSONObject.optString("order_banner");
            this.bannerLink = optJSONObject.optString("order_link");
            boolean z = true;
            if (optJSONObject.optInt("rule_ischecked") != 1) {
                z = false;
            }
            this.ruleChecked = z;
            this.ruleText = optJSONObject.optString("rule_readtext");
            this.ruleUrl = optJSONObject.optString("rule_readurl");
            this.verifyStatus = optJSONObject.optInt("verify_status");
        }
    }
}
