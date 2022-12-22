package com.didi.travel.psnger.core.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.OperationModel;
import com.didi.travel.psnger.model.response.WillWaitInfo;
import org.json.JSONObject;

public class DTSDKCreateOrderModel extends BaseObject {
    public long createTime;
    public OperationModel mOperationModel;
    String oid;
    public int otype;
    public String overdraftOid;
    public String toastContent;
    public String toastTitle;
    public WillWaitInfo willWaitInfo;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.oid = jSONObject.optString("oid");
        this.otype = jSONObject.optInt(ParamKeys.PARAM_OTYPE);
        this.createTime = jSONObject.optLong("createTime") * 1000;
        this.overdraftOid = jSONObject.optString("overdraftOid");
        this.toastTitle = jSONObject.optString("toast_title");
        this.toastContent = jSONObject.optString("toast_content");
        if (jSONObject.optJSONObject("act_ensure") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("act_ensure");
            OperationModel operationModel = new OperationModel();
            this.mOperationModel = operationModel;
            operationModel.parse(optJSONObject);
        } else if (jSONObject.optJSONObject("special_ensure") != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("special_ensure");
            OperationModel operationModel2 = new OperationModel();
            this.mOperationModel = operationModel2;
            operationModel2.parse(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("like_wait_info");
        if (optJSONObject3 != null) {
            WillWaitInfo willWaitInfo2 = new WillWaitInfo();
            this.willWaitInfo = willWaitInfo2;
            willWaitInfo2.parse(optJSONObject3);
        }
    }
}
