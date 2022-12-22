package com.didi.travel.psnger.core.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONArray;
import org.json.JSONObject;

public class DTSDKCompanyTags extends BaseObject {
    public String companyStatement;
    public CompanyTag[] tags;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.companyStatement = jSONObject.optString("company_fixed_text");
        JSONArray optJSONArray = jSONObject.optJSONArray("tags");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            this.tags = new CompanyTag[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    CompanyTag companyTag = new CompanyTag();
                    companyTag.tagIcon = optJSONObject.optString("image");
                    companyTag.tagLabel = optJSONObject.optString("text");
                    this.tags[i] = companyTag;
                }
            }
        }
    }

    public class CompanyTag {
        public String tagIcon;
        public String tagLabel;

        public CompanyTag() {
        }
    }
}
