package com.didi.soda.address.component.selectlist;

import com.didi.soda.address.component.selectlist.Contract;
import com.didi.soda.address.component.selectlist.binder.SelectedAddressItemBinder;
import com.didi.soda.customer.foundation.rpc.entity.OrderAddressListEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/soda/address/component/selectlist/SelectedAddressView$initItemBinders$2", "Lcom/didi/soda/address/component/selectlist/binder/SelectedAddressItemBinder;", "isAidSelected", "", "aid", "", "onEditClick", "", "address", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "isSelected", "onItemClick", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity;", "isCurrSelected", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SelectedAddressView.kt */
public final class SelectedAddressView$initItemBinders$2 extends SelectedAddressItemBinder {
    final /* synthetic */ SelectedAddressView this$0;

    SelectedAddressView$initItemBinders$2(SelectedAddressView selectedAddressView) {
        this.this$0 = selectedAddressView;
    }

    public boolean isAidSelected(String str) {
        return ((Contract.AbsSelectedAddressPresenter) this.this$0.getPresenter()).isAddressSelected(str);
    }

    public void onItemClick(OrderAddressListEntity.AddrOptionStructEntity addrOptionStructEntity, boolean z) {
        ((Contract.AbsSelectedAddressPresenter) this.this$0.getPresenter()).onAddressItemClick(addrOptionStructEntity, z);
    }

    public void onEditClick(AddressEntity addressEntity, boolean z) {
        ((Contract.AbsSelectedAddressPresenter) this.this$0.getPresenter()).onEditClick(addressEntity, z);
    }
}
