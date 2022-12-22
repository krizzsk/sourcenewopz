package global.didi.pay.web.p237js;

import android.app.Activity;
import com.didi.payment.base.view.webview.fusion.model.FusionBridgeModule;
import org.json.JSONObject;

/* renamed from: global.didi.pay.web.js.CouponSelectedFunction */
public class CouponSelectedFunction extends FusionBridgeModule.Function {
    private Activity mActivity;

    public CouponSelectedFunction(Activity activity) {
        this.mActivity = activity;
    }

    public JSONObject execute(JSONObject jSONObject) {
        UniPayBridgeFunctions.doSelectedCoupon(this.mActivity, jSONObject);
        return null;
    }
}
