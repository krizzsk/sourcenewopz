package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class NextPayStatus extends BaseObject {
    public String payMsg = "";
    public String paySubject = "";
    public String payTitle = "";
    public int status;

    public void parse(JSONObject jSONObject) {
        this.status = jSONObject.optInt("order_pay_status");
        this.payTitle = jSONObject.optString("order_pay_title");
        this.paySubject = jSONObject.optString("order_pay_subject");
        this.payMsg = jSONObject.optString("order_pay_msg");
    }

    public String toString() {
        return "NextPayStatus{status=" + this.status + ", payTitle='" + this.payTitle + '\'' + ", paySubject='" + this.paySubject + '\'' + ", payMsg='" + this.payMsg + '\'' + '}';
    }
}
