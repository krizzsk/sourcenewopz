package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.travel.psnger.gson.PostProcessable;
import com.didi.travel.psnger.utils.GsonUtil;
import org.json.JSONObject;

public class NextPayResult extends NextPayResultRaw implements PostProcessable<NextPayResult> {
    public transient NextNoSecretPay carNoSecretPay;
    public transient DTSDKShareCouponModel couponInfo;
    public transient int isPay;

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public NextPayResult gsonPostProcess() {
        this.isPay = this.tradeStatus;
        if (this.shareCoupon != null && !this.shareCoupon.isJsonNull()) {
            try {
                this.couponInfo = new DTSDKShareCouponModel();
                String str = "";
                if (this.shareCoupon.isJsonObject()) {
                    str = this.shareCoupon.toString();
                } else if (this.shareCoupon.isJsonPrimitive()) {
                    str = this.shareCoupon.getAsString();
                }
                this.couponInfo.parse(new JSONObject(str));
            } catch (Exception e) {
                e.printStackTrace();
                this.couponInfo = null;
            }
        }
        if (!TextUtils.isEmpty(this.payInfo)) {
            this.carNoSecretPay = (NextNoSecretPay) GsonUtil.objectFromJson(this.payInfo, NextNoSecretPay.class);
        }
        return this;
    }
}
