package global.didi.pay.web.p237js;

import android.app.Activity;
import android.content.Intent;
import org.json.JSONObject;

/* renamed from: global.didi.pay.web.js.UniPayBridgeFunctions */
public class UniPayBridgeFunctions {
    private static final String PARAM_COUPONS_SELECT = "para_coupons_select";

    public static void doSelectedCoupon(Activity activity, JSONObject jSONObject) {
        if (jSONObject != null && activity != null) {
            finishCouponWithResult(activity, jSONObject.optString("coupon_id"));
        }
    }

    public static void doCancelSelectedCoupon(Activity activity, JSONObject jSONObject) {
        if (activity != null) {
            finishCouponWithResult(activity, "");
        }
    }

    private static void finishCouponWithResult(Activity activity, String str) {
        Intent intent = new Intent();
        intent.putExtra("para_coupons_select", str);
        activity.setResult(-1, intent);
        activity.finish();
    }
}
