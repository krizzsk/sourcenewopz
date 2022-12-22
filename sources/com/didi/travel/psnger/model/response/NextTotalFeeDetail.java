package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.map.base.bubble.BaseBubbleBitmapLoader;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.gson.PostProcessable;
import com.didi.travel.psnger.utils.GsonUtil;
import java.util.Iterator;
import org.json.JSONObject;

public class NextTotalFeeDetail extends NextTotalFeeDetailRaw implements PostProcessable<NextTotalFeeDetail> {
    public transient String carCompanyPayment = "";
    public transient String carPaymentStr = "";
    public transient String carType;
    public transient String chargeDissentExtMsg = "";
    public transient String finishTime;
    public transient NextNoSecretPay mCarNoSecretPay;
    public transient NextChargeDissentModel mChargeModel;
    public transient NextRealtimeFeeItem selectedVoucherInfo;

    public NextTotalFeeDetail gsonPostProcess() {
        this.chargeDissentExtMsg = this.extra_info;
        parseExtraInfo(this.extra_info);
        if (this.favourFeeItemInfos != null && !this.favourFeeItemInfos.isEmpty()) {
            for (NextRealtimeFeeItem nextRealtimeFeeItem : this.favourFeeItemInfos) {
                if (nextRealtimeFeeItem != null) {
                    if (1005 == nextRealtimeFeeItem.feeType) {
                        this.selectedVoucherInfo = nextRealtimeFeeItem;
                    }
                    if (1011 == nextRealtimeFeeItem.feeType) {
                        this.carCompanyPayment = nextRealtimeFeeItem.paymentMode;
                    }
                }
            }
        }
        if (this.carPayments != null && !this.carPayments.isEmpty()) {
            Iterator it = this.carPayments.iterator();
            while (it.hasNext()) {
                NextFeeDetailPayment nextFeeDetailPayment = (NextFeeDetailPayment) it.next();
                if (nextFeeDetailPayment == null || 11002 == nextFeeDetailPayment.paymentMode) {
                    it.remove();
                } else {
                    this.carPaymentStr += "|" + nextFeeDetailPayment.paymentMode;
                }
            }
            if (!TextUtil.isEmpty(this.carCompanyPayment)) {
                this.carPaymentStr += "|" + this.carCompanyPayment;
            }
            this.carPaymentStr = this.carPaymentStr.replaceFirst(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG, "");
        }
        if (!TextUtil.isEmpty(this.chargeDissentEnter) || !TextUtil.isEmpty(this.chargeDissentInfos)) {
            this.mChargeModel = new NextChargeDissentModel(this.chargeDissentEnter, this.chargeDissentInfos, this.chargeDissentExtMsg);
        }
        if (!TextUtils.isEmpty(this.wxagentPayinfo)) {
            try {
                this.mCarNoSecretPay = (NextNoSecretPay) GsonUtil.objectFromJson(this.wxagentPayinfo, NextNoSecretPay.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    private void parseExtraInfo(String str) {
        if (!TextUtil.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.finishTime = jSONObject.optString("finish_time");
                this.carType = jSONObject.optString("car_type");
            } catch (Exception unused) {
            }
        }
    }
}
