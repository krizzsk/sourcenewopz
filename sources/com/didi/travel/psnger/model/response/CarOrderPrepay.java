package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.sdk.log.Logger;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarOrderPrepay extends BaseObject {
    public String out_trade_id;
    public PrePayTipsModel prePayTipsModel;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        Logger.m25808d("CarOrderPrepay is : " + jSONObject, new Object[0]);
        if (jSONObject.has("data")) {
            jSONObject = jSONObject.optJSONObject("data");
        }
        this.out_trade_id = jSONObject.optString("out_trade_id");
        if (jSONObject.has("sign_params")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("sign_params");
            PrePayTipsModel prePayTipsModel2 = new PrePayTipsModel();
            this.prePayTipsModel = prePayTipsModel2;
            prePayTipsModel2.outTradeId = this.out_trade_id;
            this.prePayTipsModel.bizContent = optJSONObject.optString(Const.PayParams.BIZ_CONTENT_UNDERLINE);
            this.prePayTipsModel.sign = optJSONObject.optString("sign");
            this.prePayTipsModel.signType = optJSONObject.optString(Const.PayParams.SIGN_TYPE_UNDERLINE);
            this.prePayTipsModel.pixPrepay = optJSONObject.optBoolean("pixPrepay", true);
        }
    }

    public boolean needPrepay() {
        return !TextUtils.isEmpty(this.out_trade_id);
    }
}
