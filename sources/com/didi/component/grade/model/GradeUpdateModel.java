package com.didi.component.grade.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class GradeUpdateModel extends BaseObject {
    public String bgImg;
    public String countryCode;
    public int createTime;
    public int expireDate;
    public String jumpLink;
    public String levelPrompt;
    public int productId;
    public int status;
    public int userId;
    public int utcOffset;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.productId = optJSONObject.optInt("productId", 0);
            this.countryCode = optJSONObject.optString("countryCode", (String) null);
            this.userId = optJSONObject.optInt("userId", 0);
            this.createTime = optJSONObject.optInt("createTime", 0);
            this.expireDate = optJSONObject.optInt("expireDate", 0);
            this.utcOffset = optJSONObject.optInt("utcOffset", 0);
            this.bgImg = optJSONObject.optString("bgImg", (String) null);
            this.jumpLink = optJSONObject.optString("jumpLink", (String) null);
            this.status = optJSONObject.optInt("status", 0);
            this.levelPrompt = optJSONObject.optString("levelPrompt");
        }
    }
}
