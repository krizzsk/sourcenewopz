package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class ScarShareCommonModel extends BaseObject {
    public boolean isDisplayLogo;
    public String shareChannel;
    public String shareContent;
    public String shareImageUrl;
    public String shareLogoUrl;
    public String shareTitle;
    public String shareUrl;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.shareTitle = jSONObject.optString("share_title");
            this.shareContent = jSONObject.optString("share_msg");
            this.shareUrl = jSONObject.optString("share_url");
            this.shareLogoUrl = jSONObject.optString("share_logo");
            boolean z = true;
            if (jSONObject.optInt("display_coupon_logo") != 1) {
                z = false;
            }
            this.isDisplayLogo = z;
        }
    }
}
