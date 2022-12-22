package com.didi.component.business.sharetrip;

import com.didi.component.common.util.GLog;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.AppUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CommonTripShareInfo extends BaseObject {
    public String shareCotent;
    public String sharePicture;
    public String shareTitle;
    public String shareUrl;
    public String share_url_origin;

    public String toString() {
        return "CommonTripShareInfo{shareTitle='" + this.shareTitle + '\'' + ", shareCotent='" + this.shareCotent + '\'' + ", shareUrl='" + this.shareUrl + '\'' + ", sharePicture='" + this.sharePicture + '\'' + '}';
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.shareTitle = optJSONObject.optString("share_title");
                this.shareCotent = optJSONObject.optString("share_content");
                if (AppUtils.isBrazilApp(DIDIApplication.getAppContext())) {
                    this.shareUrl = optJSONObject.optString("share_url_99");
                } else {
                    this.shareUrl = optJSONObject.optString("share_url");
                }
                this.sharePicture = optJSONObject.optString("share_picture");
                this.share_url_origin = optJSONObject.optString("share_url_origin");
                return;
            }
            GLog.m7968e("CommonTripShareInfo", "parse>> data is null");
        }
    }
}
