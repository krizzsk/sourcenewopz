package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.travel.psnger.gson.PostProcessable;
import org.json.JSONObject;

public class NextFeeDetailPayment extends NextFeeDetailPaymentRaw implements PostProcessable<NextFeeDetailPayment> {
    public transient int disabled;
    public transient String showMsg = "";

    public NextFeeDetailPayment gsonPostProcess() {
        parseWarnMsg();
        return this;
    }

    public void parseWarnMsg() {
        if (!TextUtils.isEmpty(this.paymentWarnMsg)) {
            try {
                JSONObject jSONObject = new JSONObject(this.paymentWarnMsg);
                this.showMsg = jSONObject.optString("show_msg", "");
                this.disabled = jSONObject.optInt("disabled");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String toString() {
        return "NextFeeDetailPayment{paymentMode=" + this.paymentMode + ", paymentName='" + this.paymentName + '\'' + ", paymentIconUrl='" + this.paymentIconUrl + '\'' + ", paymentExtMsg='" + this.paymentExtMsg + '\'' + ", paymentActUrl='" + this.paymentActUrl + '\'' + ", paymentWarnMsg='" + this.paymentWarnMsg + '\'' + ", showMsg='" + this.showMsg + '\'' + ", disabled=" + this.disabled + ", isLatestPayed=" + this.isLatestPayed + ", isDisplay=" + this.isDisplay + '}';
    }
}
