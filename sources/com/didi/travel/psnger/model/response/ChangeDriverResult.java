package com.didi.travel.psnger.model.response;

import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.core.model.response.DTSDKDriverModel;
import org.json.JSONObject;

public class ChangeDriverResult extends BaseObject {
    public DTSDKDriverModel changedDriver;
    public boolean isChangeSuccess;
    public boolean needPay = false;
    public boolean newControl = false;
    public String newControlCancelMsg;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        boolean z = false;
        boolean z2 = jSONObject.optInt(ParamConst.PARAM_IS_SUCCESS) == 1;
        this.isChangeSuccess = z2;
        if (z2 && jSONObject.has("driver_info")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("driver_info");
            DTSDKDriverModel dTSDKDriverModel = new DTSDKDriverModel();
            this.changedDriver = dTSDKDriverModel;
            dTSDKDriverModel.parse(optJSONObject);
        }
        if (jSONObject.has("is_pay_not")) {
            this.newControl = true;
            if (jSONObject.optInt("is_pay_not") == 1) {
                z = true;
            }
            this.needPay = z;
        }
        this.newControlCancelMsg = jSONObject.optString("cancel_title_tip");
    }
}
