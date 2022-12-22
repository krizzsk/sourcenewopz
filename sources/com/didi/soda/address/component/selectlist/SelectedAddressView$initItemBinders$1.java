package com.didi.soda.address.component.selectlist;

import com.didi.soda.address.component.selectlist.Contract;
import com.didi.soda.address.component.selectlist.binder.SelectedAddressAddBinder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/address/component/selectlist/SelectedAddressView$initItemBinders$1", "Lcom/didi/soda/address/component/selectlist/binder/SelectedAddressAddBinder;", "onAddClick", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SelectedAddressView.kt */
public final class SelectedAddressView$initItemBinders$1 extends SelectedAddressAddBinder {
    final /* synthetic */ SelectedAddressView this$0;

    SelectedAddressView$initItemBinders$1(SelectedAddressView selectedAddressView) {
        this.this$0 = selectedAddressView;
    }

    public void onAddClick() {
        ((Contract.AbsSelectedAddressPresenter) this.this$0.getPresenter()).onAddClick();
    }
}
