package com.didi.unifiedPay.component.activity;

import android.content.Intent;
import com.didi.commoninterfacelib.web.AbsPlatformWebPageProxy;
import com.didi.commoninterfacelib.web.IPlatformWebPageProxy;
import com.didi.unifiedPay.util.LogUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;
import org.json.JSONObject;

@ServiceProvider({AbsPlatformWebPageProxy.class})
public class CouponsListWebActivityIntent extends WebActivityIntent {
    public static final String PARAM_CHANGE_DACHEJIN = "param_change_dachejin";
    public static final String PARAM_COUPONS_SELECT = "para_coupons_select";
    /* access modifiers changed from: private */
    public static final String TAG = CouponsListWebActivityIntent.class.getSimpleName();
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
        hashMap.put("selectDeduction", new DachejinChanged());
        return hashMap;
    }

    class CouponSelected implements IPlatformWebPageProxy.JsExeCallBack {
        CouponSelected() {
        }

        public void callback(String str, JSONObject jSONObject) {
            String unused = CouponsListWebActivityIntent.this.mTicketId = jSONObject.optString("coupon_id");
            String access$100 = CouponsListWebActivityIntent.TAG;
            LogUtil.m31684d(access$100, "CouponSelected mTicketId:" + CouponsListWebActivityIntent.this.mTicketId);
            CouponsListWebActivityIntent.this.finishWithResult();
        }
    }

    class CouponCancel implements IPlatformWebPageProxy.JsExeCallBack {
        CouponCancel() {
        }

        public void callback(String str, JSONObject jSONObject) {
            String optString = jSONObject.optString("coupon_id");
            String unused = CouponsListWebActivityIntent.this.mTicketId = "";
            String access$100 = CouponsListWebActivityIntent.TAG;
            LogUtil.m31684d(access$100, "CouponCancel couponId:" + optString);
            CouponsListWebActivityIntent.this.finishWithResult();
        }
    }

    class DachejinChanged implements IPlatformWebPageProxy.JsExeCallBack {
        DachejinChanged() {
        }

        public void callback(String str, JSONObject jSONObject) {
            Intent intent = new Intent();
            intent.putExtra("param_change_dachejin", jSONObject.toString());
            CouponsListWebActivityIntent.this.mActivity.setResult(-1, intent);
            CouponsListWebActivityIntent.this.mActivity.finish();
        }
    }
}
