package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class SafetyTrainCardInfo extends BaseObject {
    public String bg_color;
    public String bg_image;
    public String content;
    public String descLabel;
    public String detailUrl;
    public String title;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        try {
            super.parse(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("passenger_unAvailableService").optJSONObject("safetyEducation").optJSONObject("data");
            if (optJSONObject != null) {
                this.title = optJSONObject.optString("title");
                this.content = optJSONObject.optString("content");
                this.detailUrl = optJSONObject.optString("detailUrl");
                this.descLabel = optJSONObject.optString("btn_title");
                this.bg_image = optJSONObject.optString("bg_image");
                this.bg_color = optJSONObject.optString(BlocksConst.WIDGET_PARAMS_BG_COLOR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAvailable() {
        if (TextUtils.isEmpty(this.title) || TextUtils.isEmpty(this.content) || TextUtils.isEmpty(this.detailUrl) || TextUtils.isEmpty(this.descLabel)) {
            return false;
        }
        return super.isAvailable();
    }
}
