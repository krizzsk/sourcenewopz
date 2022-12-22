package com.didi.component.homedestination.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import java.util.List;
import org.json.JSONObject;

public class HomeCpfAwareResponse extends BaseObject {
    public List<String> defaultPriority;
    public OrderBanCardInfo orderBanCardInfo;
    public String tag;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.tag = optJSONObject.optString("tag", "");
        }
    }
}
