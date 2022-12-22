package com.didi.soda.cart.component;

import com.didi.soda.cart.component.Contract;
import com.didi.soda.cart.component.CustomerFloatingCartView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/cart/component/CustomerFloatingCartView$hideAllCartView$1", "Lcom/didi/soda/cart/component/CustomerFloatingCartView$AnimationEndListener;", "onClearData", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerFloatingCartView.kt */
public final class CustomerFloatingCartView$hideAllCartView$1 implements CustomerFloatingCartView.AnimationEndListener {
    final /* synthetic */ CustomerFloatingCartView this$0;

    CustomerFloatingCartView$hideAllCartView$1(CustomerFloatingCartView customerFloatingCartView) {
        this.this$0 = customerFloatingCartView;
    }

    public void onClearData() {
        ((Contract.AbsFloatingCartPresenter) this.this$0.getPresenter()).clearAllData();
    }
}
