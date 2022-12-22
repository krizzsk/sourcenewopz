package com.didi.travel.psnger.model.response;

import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import org.json.JSONObject;

public class NextPrePayModel extends BaseObject {
    public String appId;
    public String didiBillId;
    public String enterpriseDesc;
    public int enterpriseStatus;
    public String mActualPayMoney;
    public String mZSBankUrl;
    public int payCloseMark;
    public int payMentMode = 0;
    public int payModel;
    public NextPayStatus payStatus;
    public String payString;
    public int payType;
    public int pollingFreguency = 5000;
    public int pollingTimes = 10;
    public String prepayStr;
    public QQParams qqParams;
    public int rechargeCloseMark;
    public int reimburseStatus;
    public String sign_url;
    public WXParams wxParams;
    public String wxPayVersion;
    public String zfbParams;

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.appId = jSONObject.optString("appid");
        WXParams wXParams = new WXParams();
        this.wxParams = wXParams;
        wXParams.partnerId = jSONObject.optString("partnerid");
        this.wxParams.nonceStr = jSONObject.optString("noncestr");
        this.wxParams.prepayId = jSONObject.optString("prepayid");
        this.wxParams.timeStamp = jSONObject.optString("timestamp");
        this.wxParams.appkey = jSONObject.optString("appkey");
        this.wxParams.packageValue = jSONObject.optString("package");
        this.wxParams.sign = jSONObject.optString("sign");
        this.wxPayVersion = jSONObject.optString("wxpay_version_confirm");
        this.mActualPayMoney = jSONObject.optString("actual_pay_money");
        this.payCloseMark = jSONObject.optInt("payCloseMark");
        this.rechargeCloseMark = jSONObject.optInt("chargeCloseMark");
        this.didiBillId = jSONObject.optString(ParamKeys.PARAM_BILL_ID);
        this.payModel = jSONObject.optInt("pay_mode");
        jSONObject.optJSONObject("share_coupon");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("enterprise_info");
        if (optJSONObject2 != null) {
            this.enterpriseStatus = optJSONObject2.optInt("status");
            this.enterpriseDesc = optJSONObject2.optString("description");
            this.reimburseStatus = optJSONObject2.optInt("reimburse_status");
        }
        this.pollingFreguency = jSONObject.optInt("polling_frequency") * 1000;
        this.pollingTimes = jSONObject.optInt("polling_times");
        this.sign_url = jSONObject.optString("sign_url");
        if (jSONObject.optInt("order_pay_status") == 2) {
            NextPayStatus nextPayStatus = new NextPayStatus();
            this.payStatus = nextPayStatus;
            nextPayStatus.status = 2;
            this.payStatus.payTitle = jSONObject.optString("order_pay_title");
            this.payStatus.paySubject = jSONObject.optString("order_pay_subject");
            this.payStatus.payMsg = jSONObject.optString("order_pay_msg");
        }
        this.payType = jSONObject.optInt(ParamConst.PARAM_PAY_TYPE);
        this.payMentMode = jSONObject.optInt(ParamKeys.PARAM_PAYMENT_MODE);
        this.prepayStr = jSONObject.optString("prepaystr");
        if (jSONObject.has("token_id")) {
            QQParams qQParams = new QQParams();
            this.qqParams = qQParams;
            qQParams.sign = jSONObject.optString("sig");
            this.qqParams.bargainorId = jSONObject.optString("bargainorId");
            this.qqParams.tokenId = jSONObject.optString("token_id");
            this.qqParams.nonce = jSONObject.optString("nonce");
            this.qqParams.appid = jSONObject.optString("appId");
        }
        if (jSONObject.has("extraValueMap") && (optJSONObject = jSONObject.optJSONObject("extraValueMap")) != null) {
            this.payString = optJSONObject.optString("pay_string");
        }
        if (jSONObject.has("pay_string")) {
            this.mZSBankUrl = jSONObject.optString("pay_string");
        }
    }

    public static class WXParams extends BaseObject {
        public String appId;
        public String appkey;
        public String nonceStr;
        public String packageValue;
        public String partnerId;
        public String prepayId;
        public String sign;
        public String timeStamp;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.timeStamp = jSONObject.optString("timestamp");
            this.sign = jSONObject.optString("sign");
            this.partnerId = jSONObject.optString("partnerid");
            this.nonceStr = jSONObject.optString("noncestr");
            this.prepayId = jSONObject.optString("prepayid");
            this.packageValue = jSONObject.optString("package");
            this.appkey = jSONObject.optString("appkey");
            this.appId = jSONObject.optString("appid");
        }
    }

    public static class QQParams extends BaseObject {
        public String appid;
        public String bargainorId;
        public String nonce;
        public String sign;
        public String tokenId;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.sign = jSONObject.optString("sig");
            this.bargainorId = jSONObject.optString("bargainorId");
            this.tokenId = jSONObject.optString("tokenId");
            this.nonce = jSONObject.optString("nonce");
            this.appid = jSONObject.optString("appId");
        }

        public String toString() {
            return "QQParams{sign='" + this.sign + '\'' + ", bargainorId='" + this.bargainorId + '\'' + ", tokenId='" + this.tokenId + '\'' + ", nonce='" + this.nonce + '\'' + ", appid='" + this.appid + '\'' + '}';
        }
    }
}
