package com.didi.universal.pay.biz.hybird;

import android.content.Intent;
import com.didi.commoninterfacelib.web.AbsPlatformWebPageProxy;
import com.didi.commoninterfacelib.web.IPlatformWebPageProxy;
import com.didi.universal.pay.sdk.web.WebActivityIntent;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;
import org.json.JSONObject;

@ServiceProvider({AbsPlatformWebPageProxy.class})
public class UniversalCouponsIntent extends WebActivityIntent {
    public static final String PARAM_CHANGE_DACHEJIN = "param_change_dachejin";
    public static final String PARAM_COUPONS_SELECT = "para_coupons_select";
    /* access modifiers changed from: private */
    public String mTicketId = "";

    /* access modifiers changed from: private */
    public void finishWithResult() {
        Intent intent = new Intent();
        intent.putExtra("para_coupons_select", this.mTicketId);
        this.mActivity.setResult(-1, intent);
        this.mActivity.finish();
    }

    public HashMap<String, IPlatformWebPageProxy.JsExeCallBack> getJsFunctions() {
        HashMap<String, IPlatformWebPageProxy.JsExeCallBack> hashMap = new HashMap<>();
        hashMap.put("selectedCoupon", new CouponSelected());
        hashMap.put("cancelSelectedCoupon", new CouponCancel());
        hashMap.put("selectDeduction", new DaCheJinChanged());
        return hashMap;
    }

    class CouponSelected implements IPlatformWebPageProxy.JsExeCallBack {
        CouponSelected() {
        }

        public void callback(String str, JSONObject jSONObject) {
            String unused = UniversalCouponsIntent.this.mTicketId = jSONObject.optString("coupon_id");
            UniversalCouponsIntent.this.finishWithResult();
        }
    }

    class CouponCancel implements IPlatformWebPageProxy.JsExeCallBack {
        CouponCancel() {
        }

        public void callback(String str, JSONObject jSONObject) {
            String unused = UniversalCouponsIntent.this.mTicketId = "";
            UniversalCouponsIntent.this.finishWithResult();
        }
    }

    class DaCheJinChanged implements IPlatformWebPageProxy.JsExeCallBack {
        DaCheJinChanged() {
        }

        public void callback(String str, JSONObject jSONObject) {
            Intent intent = new Intent();
            intent.putExtra("param_change_dachejin", jSONObject.toString());
            UniversalCouponsIntent.this.mActivity.setResult(-1, intent);
            UniversalCouponsIntent.this.mActivity.finish();
        }
    }
}
