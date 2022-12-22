package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.core.model.response.ICancelOrder;
import org.json.JSONObject;

public class CancelOrder extends BaseObject implements ICancelOrder {
    public String reassignOid;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.reassignOid = optJSONObject.optString("reassign_oid");
        }
    }

    public boolean isReassignOrder() {
        return !TextUtils.isEmpty(this.reassignOid);
    }
}
