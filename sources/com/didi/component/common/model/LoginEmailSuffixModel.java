package com.didi.component.common.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LoginEmailSuffixModel extends BaseObject {
    public List<String> emailSuffix = new ArrayList();
    public boolean isAllow;
    public String pidGroupName;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.isAllow = optJSONObject.optBoolean("is_allow");
            this.pidGroupName = optJSONObject.optString("pid_group_name");
            JSONArray optJSONArray = optJSONObject.optJSONArray("email_suffix");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.emailSuffix.add(optJSONArray.optString(i));
                }
            }
        }
    }
}
