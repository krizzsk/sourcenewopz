package com.didi.soda.address.component.selectlist;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.soda.address.component.selectlist.Contract;
import com.didi.soda.address.component.selectlist.binder.SelectedAddressAddRvModel;
import com.didi.soda.address.component.selectlist.binder.SelectedAddressDescRvModel;
import com.didi.soda.address.component.selectlist.binder.SelectedAddressItemRvModel;
import com.didi.soda.address.component.selectlist.binder.TypeCorner;
import com.didi.soda.customer.foundation.rpc.entity.OrderAddressListEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.DialogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/address/component/selectlist/SelectedAddressPresenter$onRefreshList$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SelectedAddressPresenter.kt */
public final class SelectedAddressPresenter$onRefreshList$1 extends CustomerRpcCallback<OrderAddressListEntity> {
    final /* synthetic */ SelectedAddressPresenter this$0;

    SelectedAddressPresenter$onRefreshList$1(SelectedAddressPresenter selectedAddressPresenter) {
        this.this$0 = selectedAddressPresenter;
    }

    public void onRpcSuccess(OrderAddressListEntity orderAddressListEntity, long j) {
        ChildDataListManager<RecyclerModel> listManager;
        ChildDataListManager<RecyclerModel> listManager2;
        Intrinsics.checkNotNullParameter(orderAddressListEntity, "entity");
        DialogUtil.hideLoadingDialog();
        ((Contract.AbsSelectedAddressView) this.this$0.getLogicView()).hideLoadError();
        ChildDataListManager<RecyclerModel> listManager3 = this.this$0.getListManager();
        if (listManager3 != null) {
            listManager3.clear();
        }
        this.this$0.setOrderAid(orderAddressListEntity.getOrderAid());
        String ruleDesc = orderAddressListEntity.getRuleDesc();
        if (!(ruleDesc == null || (listManager2 = this.this$0.getListManager()) == null)) {
            listManager2.add(new SelectedAddressDescRvModel(ruleDesc));
        }
        String addAddrRuleDesc = orderAddressListEntity.getAddAddrRuleDesc();
        if (!(addAddrRuleDesc == null || (listManager = this.this$0.getListManager()) == null)) {
            listManager.add(new SelectedAddressAddRvModel(addAddrRuleDesc));
        }
        List<OrderAddressListEntity.AddrOptionStructEntity> addressList = orderAddressListEntity.getAddressList();
        if (addressList != null) {
            SelectedAddressPresenter selectedAddressPresenter = this.this$0;
            selectedAddressPresenter.setSelectedAddress((AddressEntity) null);
            boolean z = false;
            int i = 0;
            for (Object next : addressList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                OrderAddressListEntity.AddrOptionStructEntity addrOptionStructEntity = (OrderAddressListEntity.AddrOptionStructEntity) next;
                AddressEntity address = addrOptionStructEntity.getAddress();
                if (Intrinsics.areEqual((Object) address == null ? null : address.aid, (Object) orderAddressListEntity.getOrderAid())) {
                    selectedAddressPresenter.setSelectedAddress(addrOptionStructEntity.getAddress());
                }
                String str = "";
                if (addressList.size() == 1) {
                    ChildDataListManager<RecyclerModel> listManager4 = selectedAddressPresenter.getListManager();
                    if (listManager4 != null) {
                        String orderAid = orderAddressListEntity.getOrderAid();
                        if (orderAid != null) {
                            str = orderAid;
                        }
                        listManager4.add(new SelectedAddressItemRvModel(addrOptionStructEntity, str, TypeCorner.ALL));
                    }
                } else if (i == 0) {
                    ChildDataListManager<RecyclerModel> listManager5 = selectedAddressPresenter.getListManager();
                    if (listManager5 != null) {
                        String orderAid2 = orderAddressListEntity.getOrderAid();
                        if (orderAid2 != null) {
                            str = orderAid2;
                        }
                        listManager5.add(new SelectedAddressItemRvModel(addrOptionStructEntity, str, TypeCorner.TOP));
                    }
                } else if (i == addressList.size() - 1) {
                    ChildDataListManager<RecyclerModel> listManager6 = selectedAddressPresenter.getListManager();
                    if (listManager6 != null) {
                        String orderAid3 = orderAddressListEntity.getOrderAid();
                        if (orderAid3 != null) {
                            str = orderAid3;
                        }
                        listManager6.add(new SelectedAddressItemRvModel(addrOptionStructEntity, str, TypeCorner.BOTTOM));
                    }
                } else {
                    ChildDataListManager<RecyclerModel> listManager7 = selectedAddressPresenter.getListManager();
                    if (listManager7 != null) {
                        String orderAid4 = orderAddressListEntity.getOrderAid();
                        if (orderAid4 != null) {
                            str = orderAid4;
                        }
                        listManager7.add(new SelectedAddressItemRvModel(addrOptionStructEntity, str, TypeCorner.NONE));
                    }
                }
                i = i2;
            }
            if (selectedAddressPresenter.getSelectedAddress() != null) {
                z = true;
            }
            selectedAddressPresenter.setConfirmEnable(z);
        }
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        super.onRpcFailure(sFRpcException);
        DialogUtil.hideLoadingDialog();
        ((Contract.AbsSelectedAddressView) this.this$0.getLogicView()).showLoadError(sFRpcException == null ? null : sFRpcException.getMessage());
    }
}
