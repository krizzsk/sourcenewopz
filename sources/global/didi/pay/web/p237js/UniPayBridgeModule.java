package global.didi.pay.web.p237js;

import android.app.Activity;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.payment.base.view.webview.fusion.model.FusionBridgeModule;

/* renamed from: global.didi.pay.web.js.UniPayBridgeModule */
public class UniPayBridgeModule extends FusionBridgeModule {
    private Activity mActivity;

    public UniPayBridgeModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.mActivity = hybridableContainer.getActivity();
        addUniPayFunction();
    }

    private void addUniPayFunction() {
        addFunction("selectedCoupon", new CouponSelectedFunction(this.mActivity));
        addFunction("cancelSelectedCoupon", new CouponCancelFunction(this.mActivity));
    }
}
