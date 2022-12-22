package com.didi.soda.address.component.selectlist;

import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import com.didi.soda.customer.foundation.rpc.entity.OrderAddressListEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/address/component/selectlist/Contract;", "", "()V", "AbsSelectedAddressPresenter", "AbsSelectedAddressView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public final class Contract {

    @Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0005H&J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0005H&J\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0005H&¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/address/component/selectlist/Contract$AbsSelectedAddressPresenter;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/soda/address/component/selectlist/Contract$AbsSelectedAddressView;", "()V", "finish", "", "isAddressSelected", "", "aid", "", "onAddClick", "onAddressItemClick", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity;", "isCurrSelected", "onConfirmClick", "onEditClick", "address", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "isSelected", "onRefreshList", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsSelectedAddressPresenter extends CustomerRecyclerPresenter<AbsSelectedAddressView> {
        public abstract void finish();

        public abstract boolean isAddressSelected(String str);

        public abstract void onAddClick();

        public abstract void onAddressItemClick(OrderAddressListEntity.AddrOptionStructEntity addrOptionStructEntity, boolean z);

        public abstract void onConfirmClick();

        public abstract void onEditClick(AddressEntity addressEntity, boolean z);

        public abstract void onRefreshList();
    }

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/address/component/selectlist/Contract$AbsSelectedAddressView;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/soda/address/component/selectlist/Contract$AbsSelectedAddressPresenter;", "()V", "hideLoadError", "", "post", "runnable", "Ljava/lang/Runnable;", "setConfirmEnable", "isEnable", "", "showLoadError", "errorMsg", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsSelectedAddressView extends CustomerRecyclerView<AbsSelectedAddressPresenter> {
        public abstract void hideLoadError();

        public abstract void post(Runnable runnable);

        public abstract void setConfirmEnable(boolean z);

        public abstract void showLoadError(String str);
    }
}
