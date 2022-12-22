package com.didi.travel.psnger.model.response;

import android.util.Patterns;
import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.regex.Matcher;
import org.json.JSONObject;

public class RedirectActionModel extends BaseObject {
    public String linkName;
    public String phone;
    public String pointLink;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject.has("point_link")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("point_link");
            this.pointLink = optJSONObject.optString("url");
            this.linkName = optJSONObject.optString("name");
            return;
        }
        Matcher matcher = Patterns.PHONE.matcher(jSONObject.toString());
        if (matcher.find()) {
            if (matcher.end() - matcher.start() > 5) {
                this.phone = matcher.group();
            }
        }
    }
}
