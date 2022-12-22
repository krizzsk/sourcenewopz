package com.didi.soda.cart.binder;

import com.didi.rfusion.widget.stepper.RFStepper;
import com.didi.soda.cart.model.CartItemModel;
import com.didi.soda.cart.repo.CheckCartMaxNumKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/soda/cart/binder/CustomerCartMenuBinder$bind$3", "Lcom/didi/rfusion/widget/stepper/RFStepper$OnStepperChangedListener;", "onStepperChanged", "", "sourceType", "", "oldValue", "curValue", "onStepperIntercepted", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerCartMenuBinder.kt */
public final class CustomerCartMenuBinder$bind$3 extends RFStepper.OnStepperChangedListener {
    final /* synthetic */ CartItemModel $model;
    final /* synthetic */ CustomerCartMenuBinder this$0;

    CustomerCartMenuBinder$bind$3(CustomerCartMenuBinder customerCartMenuBinder, CartItemModel cartItemModel) {
        this.this$0 = customerCartMenuBinder;
        this.$model = cartItemModel;
    }

    public boolean onStepperIntercepted(int i, int i2, int i3) {
        if (i3 > i2) {
            return CheckCartMaxNumKt.isReachMaxNum(this.this$0.scopeContext, this.$model.getShopId(), this.$model.getItemUniqKey(), this.$model.getMduId(), i3, (Function0<Unit>) null);
        }
        return false;
    }

    public void onStepperChanged(int i, int i2, int i3) {
        this.$model.setAmount(i3);
        this.this$0.updateSku(this.$model, i3 > i2);
    }
}
