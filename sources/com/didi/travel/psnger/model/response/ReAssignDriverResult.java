package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class ReAssignDriverResult extends BaseObject {
    public String assignMsg;
    public String newOid;
    public String oid;
    public int orderType;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.oid = jSONObject.optString("oid");
        this.newOid = jSONObject.optString("newOid");
        this.orderType = jSONObject.optInt("type");
    }
}
