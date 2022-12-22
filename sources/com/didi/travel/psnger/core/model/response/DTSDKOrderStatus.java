package com.didi.travel.psnger.core.model.response;

import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import org.json.JSONException;
import org.json.JSONObject;

public class DTSDKOrderStatus extends BaseObject implements IOrderStatus {
    public static final int HAVE_NO_FEE_OBJECTION = 0;
    public static final int NEED_REQUEST_FEE_OBJECTION = 1;
    public int carpoolStatus;
    public int code;
    public int feeObjectionStatus;
    public String freezeAlert;
    public int freezeStatus;
    public int intervalTime;
    public boolean isTimeout;
    public String lineMD5;
    public String md5;
    public String msg;
    public int newOrderBookingMode;
    public String newOrderId;
    public String oid;
    public int status;
    public int subStatus;
    public String timeoutMsg;
    public int waitTime;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            parseData(jSONObject.optJSONObject("data"));
        }
    }

    public void parseRecommendMsg(String str) {
        try {
            parseData(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseData(JSONObject jSONObject) {
        this.oid = jSONObject.optString("order_id");
        this.newOrderId = jSONObject.optString("new_order_id");
        this.lineMD5 = jSONObject.optString("line_md5");
        this.intervalTime = jSONObject.optInt("interval_time");
        this.status = jSONObject.optInt("status");
        this.subStatus = jSONObject.optInt(ParamKeys.PARAM_SUB_STATUS);
        this.waitTime = jSONObject.optInt(ParamConst.PARAM_WAIT_TIME);
        this.isTimeout = jSONObject.optInt("is_timeout") != 0;
        this.timeoutMsg = jSONObject.optString("timeout_msg");
        this.freezeStatus = jSONObject.optInt("freeze_status");
        this.freezeAlert = jSONObject.optString("freeze_alert");
        this.feeObjectionStatus = jSONObject.optInt("fee_objection_status");
        this.newOrderBookingMode = jSONObject.optInt("new_order_booking_mode");
        this.carpoolStatus = jSONObject.optInt("carpool_status");
        this.md5 = jSONObject.optString("md5");
        this.msg = jSONObject.optString("msg");
        this.code = jSONObject.optInt("code");
    }

    public String oid() {
        return this.oid;
    }

    public String lineMD5() {
        return this.lineMD5;
    }

    public int intervalTime() {
        return this.intervalTime;
    }

    public int status() {
        return this.status;
    }

    public int subStatus() {
        return this.subStatus;
    }

    public boolean isTimeout() {
        return this.isTimeout;
    }

    public void setOid(String str) {
        this.oid = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setSubStatus(int i) {
        this.subStatus = i;
    }
}
