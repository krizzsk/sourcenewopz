package com.didi.entrega.pay;

import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class PayMethodView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PayMethodView f21009a;

    public PayMethodView_ViewBinding(PayMethodView payMethodView, View view) {
        this.f21009a = payMethodView;
        payMethodView.mPayMethodInfoContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.customer_ll_item_group, "field 'mPayMethodInfoContainer'", LinearLayout.class);
        payMethodView.mBackView = Utils.findRequiredView(view, R.id.customer_iv_close, "field 'mBackView'");
    }

    public void unbind() {
        PayMethodView payMethodView = this.f21009a;
        if (payMethodView != null) {
            this.f21009a = null;
            payMethodView.mPayMethodInfoContainer = null;
            payMethodView.mBackView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
