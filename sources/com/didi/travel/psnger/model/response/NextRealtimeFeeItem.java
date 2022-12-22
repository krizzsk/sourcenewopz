package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.gson.PostProcessable;
import org.json.JSONObject;

public class NextRealtimeFeeItem extends NextRealtimeFeeItemRaw implements PostProcessable<NextRealtimeFeeItem> {
    public transient String paymentMode;
    public transient int selected;
    public transient String showMsg = "";

    public NextRealtimeFeeItem gsonPostProcess() {
        parseExtraInfo();
        return this;
    }

    public void parseExtraInfo() {
        if (!TextUtils.isEmpty(this.extraInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(this.extraInfo);
                this.showMsg = jSONObject.optString("show_msg", "");
                this.selected = jSONObject.optInt("selected");
                this.paymentMode = jSONObject.optString(ParamKeys.PARAM_PAYMENT_MODE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String toString() {
        return "NextRealtimeFeeItem{feeId='" + this.feeId + '\'' + ", feeType=" + this.feeType + ", feeLabel='" + this.feeLabel + '\'' + ", feeValue='" + this.feeValue + '\'' + ", feeCust=" + this.feeCust + ", feeUrl='" + this.feeUrl + '\'' + ", feeColor='" + this.feeColor + '\'' + ", extraInfo='" + this.extraInfo + '\'' + ", showMsg='" + this.showMsg + '\'' + ", selected=" + this.selected + ", paymentMode='" + this.paymentMode + '\'' + '}';
    }
}
