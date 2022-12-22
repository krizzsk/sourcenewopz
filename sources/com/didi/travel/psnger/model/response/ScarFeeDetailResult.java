package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.GsonUtil;
import org.json.JSONObject;

public class ScarFeeDetailResult extends BaseObject {
    private static final long serialVersionUID = 462015028530173744L;
    public NextTotalFeeDetail feeDetail;
    public int payMark;
    public int pricingModel;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.payMark = jSONObject.optInt("isPay");
        this.pricingModel = jSONObject.optInt("pricingModel");
        JSONObject optJSONObject = jSONObject.optJSONObject("feeInfo");
        if (optJSONObject != null) {
            this.feeDetail = (NextTotalFeeDetail) GsonUtil.objectFromJson(optJSONObject.toString(), NextTotalFeeDetail.class);
        }
    }
}
