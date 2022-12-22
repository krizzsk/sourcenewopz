package com.didi.soda.address.edit.component;

import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.order.view.AddressCardRecyclerView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/address/edit/component/EditAddressInfoView$initView$4", "Lcom/didi/soda/order/view/AddressCardRecyclerView$ExpendListener;", "expendOrPickUp", "", "distance", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoView.kt */
public final class EditAddressInfoView$initView$4 implements AddressCardRecyclerView.ExpendListener {
    final /* synthetic */ EditAddressInfoView this$0;

    EditAddressInfoView$initView$4(EditAddressInfoView editAddressInfoView) {
        this.this$0 = editAddressInfoView;
    }

    public void expendOrPickUp(float f) {
        if (f > 0.0f) {
            if (!this.this$0.f38759m) {
                this.this$0.f38759m = true;
                EditAddressInfoView editAddressInfoView = this.this$0;
                editAddressInfoView.m27460b(editAddressInfoView.m27467d());
                AddressOmegaHelper.traceLocationSw(3);
            }
        } else if (this.this$0.f38759m) {
            this.this$0.f38759m = false;
            this.this$0.m27471f();
        }
    }
}
