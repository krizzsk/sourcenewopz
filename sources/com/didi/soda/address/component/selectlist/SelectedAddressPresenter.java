package com.didi.soda.address.component.selectlist;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.address.component.selectlist.Contract;
import com.didi.soda.address.edit.EditAddressInfoPage;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.OrderAddressListEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.taxis99.R;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0016J\u0012\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010.\u001a\u00020*H\u0016J\u001a\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020*H\u0016J\b\u00104\u001a\u00020*H\u0016J\u001a\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u00010$2\u0006\u00107\u001a\u00020\u0005H\u0016J\u0010\u00108\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010:J\b\u0010;\u001a\u00020*H\u0016R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006<"}, mo175978d2 = {"Lcom/didi/soda/address/component/selectlist/SelectedAddressPresenter;", "Lcom/didi/soda/address/component/selectlist/Contract$AbsSelectedAddressPresenter;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "<set-?>", "", "isConfirmEnable", "()Z", "setConfirmEnable", "(Z)V", "isConfirmEnable$delegate", "Lkotlin/properties/ReadWriteProperty;", "listManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "getListManager", "()Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "setListManager", "(Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;)V", "newAddAid", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getNewAddAid", "()Ljava/lang/StringBuilder;", "setNewAddAid", "(Ljava/lang/StringBuilder;)V", "orderAid", "", "getOrderAid", "()Ljava/lang/String;", "setOrderAid", "(Ljava/lang/String;)V", "orderId", "getOrderId", "setOrderId", "selectedAddress", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "getSelectedAddress", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "setSelectedAddress", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;)V", "finish", "", "initDataManagers", "isAddressSelected", "aid", "onAddClick", "onAddressItemClick", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity;", "isCurrSelected", "onConfirmClick", "onCreate", "onEditClick", "address", "isSelected", "onPageResult", "data", "Landroid/os/Bundle;", "onRefreshList", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SelectedAddressPresenter.kt */
public final class SelectedAddressPresenter extends Contract.AbsSelectedAddressPresenter implements IRFFloatingExpand {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f38696a = {C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(SelectedAddressPresenter.class, "isConfirmEnable", "isConfirmEnable()Z", 0))};

    /* renamed from: b */
    private ChildDataListManager<RecyclerModel> f38697b;

    /* renamed from: c */
    private String f38698c;

    /* renamed from: d */
    private AddressEntity f38699d;

    /* renamed from: e */
    private StringBuilder f38700e = new StringBuilder();

    /* renamed from: f */
    private String f38701f;

    /* renamed from: g */
    private final ReadWriteProperty f38702g;

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public SelectedAddressPresenter() {
        Delegates delegates = Delegates.INSTANCE;
        this.f38702g = new SelectedAddressPresenter$special$$inlined$observable$1(true, true, this);
    }

    public final ChildDataListManager<RecyclerModel> getListManager() {
        return this.f38697b;
    }

    public final void setListManager(ChildDataListManager<RecyclerModel> childDataListManager) {
        this.f38697b = childDataListManager;
    }

    public final String getOrderId() {
        return this.f38698c;
    }

    public final void setOrderId(String str) {
        this.f38698c = str;
    }

    public final AddressEntity getSelectedAddress() {
        return this.f38699d;
    }

    public final void setSelectedAddress(AddressEntity addressEntity) {
        this.f38699d = addressEntity;
    }

    public final StringBuilder getNewAddAid() {
        return this.f38700e;
    }

    public final void setNewAddAid(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<set-?>");
        this.f38700e = sb;
    }

    public final String getOrderAid() {
        return this.f38701f;
    }

    public final void setOrderAid(String str) {
        this.f38701f = str;
    }

    public final boolean isConfirmEnable() {
        return ((Boolean) this.f38702g.getValue(this, f38696a[0])).booleanValue();
    }

    public final void setConfirmEnable(boolean z) {
        this.f38702g.setValue(this, f38696a[0], Boolean.valueOf(z));
    }

    public void onCreate() {
        super.onCreate();
        this.f38698c = getScopeContext().getBundle().getString("orderId", "");
        onRefreshList();
        AddressOmegaHelper.traceDeliveryCommonSW(this.f38698c);
    }

    public void onRefreshList() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
        CustomerRpcManagerProxy.get().addressListShow(this.f38698c, this.f38700e.toString(), new SelectedAddressPresenter$onRefreshList$1(this));
    }

    public void onConfirmClick() {
        AddressOmegaHelper.traceDeliveryConfirmCK(this.f38698c);
        if (!isConfirmEnable()) {
            ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_payment_Please_confirm_ITjW));
        } else {
            DialogUtil.showOrderAddressUpdate(getScopeContext().getNavigator(), new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    SelectedAddressPresenter.m27416a(SelectedAddressPresenter.this, rFDialog);
                }
            }, $$Lambda$SelectedAddressPresenter$ColkcVkc9nHjmH3ufwSANk6t43w.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27416a(SelectedAddressPresenter selectedAddressPresenter, RFDialog rFDialog) {
        String str;
        Intrinsics.checkNotNullParameter(selectedAddressPresenter, "this$0");
        AddressOmegaHelper.traceDeliveryConfirmChangeCK(1);
        rFDialog.dismiss();
        DialogUtil.showLoadingDialog(selectedAddressPresenter.getScopeContext(), false);
        CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
        String orderId = selectedAddressPresenter.getOrderId();
        AddressEntity selectedAddress = selectedAddressPresenter.getSelectedAddress();
        String str2 = "";
        if (!(selectedAddress == null || (str = selectedAddress.aid) == null)) {
            str2 = str;
        }
        customerRpcService.addressListCk(orderId, str2, new SelectedAddressPresenter$onConfirmClick$1$1(selectedAddressPresenter));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27414a(RFDialog rFDialog) {
        AddressOmegaHelper.traceDeliveryConfirmChangeCK(2);
        rFDialog.dismiss();
    }

    public void onEditClick(AddressEntity addressEntity, boolean z) {
        AddressOmegaHelper.traceDeliveryEditCK(this.f38698c);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.PageParams.ADDRESS_ENTITY, addressEntity);
        bundle.putInt("from", 5);
        bundle.putBoolean(Const.PageParams.CHECK_STATUS, z);
        Page newInstance = PageFactory.newInstance(EditAddressInfoPage.class, bundle);
        if (newInstance != null) {
            getScopeContext().getNavigator().pushForResult((EditAddressInfoPage) newInstance);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.address.edit.EditAddressInfoPage");
    }

    public void onAddClick() {
        AddressOmegaHelper.traceDeliveryAddCK(this.f38698c);
        AddressEntity delieveryAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.PageParams.ADDRESS_ENTITY, delieveryAddress);
        bundle.putInt("from", 4);
        bundle.putBoolean(Const.PageParams.CHECK_STATUS, false);
        Page newInstance = PageFactory.newInstance(EditAddressInfoPage.class, bundle);
        if (newInstance != null) {
            getScopeContext().getNavigator().pushForResult((EditAddressInfoPage) newInstance);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.address.edit.EditAddressInfoPage");
    }

    public boolean isAddressSelected(String str) {
        AddressEntity addressEntity = this.f38699d;
        return Intrinsics.areEqual((Object) str, (Object) addressEntity == null ? null : addressEntity.aid);
    }

    public void onAddressItemClick(OrderAddressListEntity.AddrOptionStructEntity addrOptionStructEntity, boolean z) {
        AddressEntity address;
        String str;
        if (addrOptionStructEntity != null && (address = addrOptionStructEntity.getAddress()) != null && (str = address.aid) != null) {
            AddressEntity selectedAddress = getSelectedAddress();
            if (!Intrinsics.areEqual((Object) selectedAddress == null ? null : selectedAddress.aid, (Object) str)) {
                boolean z2 = false;
                boolean z3 = true;
                if (addrOptionStructEntity.getDisable() == 1) {
                    CharSequence disableReason = addrOptionStructEntity.getDisableReason();
                    if (disableReason == null || disableReason.length() == 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        ToastUtil.showCustomerToast(getScopeContext(), addrOptionStructEntity.getDisableReason());
                        return;
                    }
                    return;
                }
                setSelectedAddress(addrOptionStructEntity.getAddress());
                if (getSelectedAddress() == null) {
                    z3 = false;
                }
                setConfirmEnable(z3);
                ChildDataListManager<RecyclerModel> listManager = getListManager();
                if (listManager != null) {
                    listManager.onChanged(0, listManager.size(), (Object) null);
                }
            }
        }
    }

    public void finish() {
        dismiss(getScopeContext());
    }

    public void initDataManagers() {
        super.initDataManagers();
        ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
        this.f38697b = createChildDataListManager;
        addDataManager(createChildDataListManager);
    }

    public final void onPageResult(Bundle bundle) {
        Serializable serializable;
        String str;
        if (!(bundle == null || (serializable = bundle.getSerializable("entity")) == null || !(serializable instanceof AddressEntity) || (str = ((AddressEntity) serializable).aid) == null)) {
            if (Intrinsics.areEqual((Object) getOrderAid(), (Object) str) || bundle.getInt("from") != 5) {
                if (getNewAddAid().length() > 0) {
                    getNewAddAid().append(",");
                }
                getNewAddAid().append(str);
            } else {
                return;
            }
        }
        ((Contract.AbsSelectedAddressView) getLogicView()).post(new Runnable() {
            public final void run() {
                SelectedAddressPresenter.m27415a(SelectedAddressPresenter.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27415a(SelectedAddressPresenter selectedAddressPresenter) {
        Intrinsics.checkNotNullParameter(selectedAddressPresenter, "this$0");
        selectedAddressPresenter.onRefreshList();
    }
}
