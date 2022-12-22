package com.didi.entrega.address.list.component.feed.core;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.address.data.entity.AddressCheckEntity;
import com.didi.entrega.address.list.component.feed.core.Contract;
import com.didi.entrega.address.list.component.feed.model.AddressListSplitRvModel;
import com.didi.entrega.address.list.component.feed.model.AddressListTitleRvModel;
import com.didi.entrega.address.list.component.feed.model.AddressPageListEntity;
import com.didi.entrega.address.list.component.feed.model.DeliveryAddressRvModel;
import com.didi.entrega.address.utils.AddressUtil;
import com.didi.entrega.address.utils.omega.AddressOmegaHelper;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.ClickUtils;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.LocalPermissionHelper;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.foundation.util.NetWorkUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.widget.abnormal.AbnormalRvModel;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModelFactory;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.taxis99.R;
import java.util.List;

public class AddressFeedMessagePresenter extends Contract.AbsAddressFeedMessagePresenter {

    /* renamed from: a */
    private static final String f19424a = "AddressFeedMessagePresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f19425b;

    /* renamed from: c */
    private boolean f19426c;

    /* renamed from: d */
    private int f19427d;

    /* renamed from: e */
    private int f19428e;

    /* renamed from: f */
    private ChildDataListManager<RecyclerModel> f19429f;

    /* renamed from: g */
    private DeliveryAddressRvModel f19430g;

    /* renamed from: h */
    private int f19431h = 0;

    /* renamed from: i */
    private AddressListTitleRvModel f19432i;

    /* renamed from: j */
    private AddressListSplitRvModel f19433j;

    public void onCreate() {
        super.onCreate();
        if (this.f19429f == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f19429f = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
        m14542c();
        m14536b();
    }

    public void onResume() {
        if (!this.f19426c) {
            this.f19426c = true;
        } else {
            m14527a();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void getAddressAllList() {
        m14545d();
    }

    /* renamed from: a */
    private void m14527a() {
        boolean i = m14550i();
        boolean hasValidLocation = LocationUtil.hasValidLocation();
        LogUtil.m14765i(f19424a, "refreshLocation---- hasValidLocation=" + hasValidLocation + "----locationPermission=" + i + "---size=" + this.f19431h);
        if (i && hasValidLocation) {
            onRetryLocation();
        } else if (this.f19431h == 0) {
            m14546e();
        }
    }

    public void onAddressClick(DeliveryAddressRvModel deliveryAddressRvModel) {
        if (!ClickUtils.isFastClick()) {
            ChildDataListManager<RecyclerModel> childDataListManager = this.f19429f;
            if (childDataListManager == null || deliveryAddressRvModel == null) {
                LogUtil.m14765i(f19424a, " mAddressListManager is " + this.f19429f + " deliveryAddressRvModel is " + deliveryAddressRvModel);
                return;
            }
            AddressOmegaHelper.INSTANCE.trackDeliverySearchResultCk("", this.f19431h, childDataListManager.indexOf(deliveryAddressRvModel), deliveryAddressRvModel.addressType, this.f19425b);
            m14534a(deliveryAddressRvModel.mAddress);
        }
    }

    /* renamed from: a */
    private void m14534a(AddressEntity addressEntity) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        final AddressEntity addressEntity2 = addressEntity;
        if (AddressUtil.checkAddressValid(addressEntity)) {
            ((Contract.AbsAddressFeedMessageView) getLogicView()).showLoading();
            double d6 = 0.0d;
            if (AddressUtil.isSenderAddressSelected(this.f19425b)) {
                double d7 = addressEntity2.poi.lat;
                double d8 = addressEntity2.poi.lng;
                AddressEntity receiveContact = ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).getReceiveContact();
                if (AddressUtil.checkAddressValid(receiveContact)) {
                    d6 = receiveContact.poi.lat;
                    d4 = receiveContact.poi.lng;
                } else {
                    d4 = 0.0d;
                }
                d = d6;
                d3 = d7;
                d2 = d8;
            } else {
                AddressEntity sendContact = ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).getSendContact();
                if (AddressUtil.checkAddressValid(sendContact)) {
                    d6 = sendContact.poi.lat;
                    d5 = sendContact.poi.lng;
                } else {
                    d5 = 0.0d;
                }
                double d9 = addressEntity2.poi.lat;
                d4 = addressEntity2.poi.lng;
                d3 = d6;
                d2 = d5;
                d = d9;
            }
            CustomerRpcManagerProxy.get().checkAddress(d3, d2, d, d4, 2, this.f19425b, new CustomerRpcCallback<AddressCheckEntity>() {
                public void onRpcSuccess(AddressCheckEntity addressCheckEntity, long j) {
                    ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                    if (addressCheckEntity == null) {
                        return;
                    }
                    if (addressCheckEntity.legal) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("entity", addressEntity2);
                        AddressFeedMessagePresenter.this.getScopeContext().getNavigator().finish(bundle);
                    } else if (!TextUtils.isEmpty(addressCheckEntity.content)) {
                        ToastUtil.showCustomerToast(AddressFeedMessagePresenter.this.getScopeContext(), addressCheckEntity.content);
                        AddressOmegaHelper.INSTANCE.trackDeliverySearchResultToastSw("", addressCheckEntity.toastType, AddressFeedMessagePresenter.this.f19425b);
                    }
                }

                public void onRpcFailure(SFRpcException sFRpcException) {
                    super.onRpcFailure(sFRpcException);
                    ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                    ToastUtil.showCustomerToast(AddressFeedMessagePresenter.this.getScopeContext(), ResourceHelper.getString(R.string.FoodC_orderlist3_Check_the_uDiY));
                }
            });
            return;
        }
        ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_search_Address_error_jdye));
    }

    public void onOpenLocation() {
        CustomerSystemUtil.openLocationSettingActivity(getContext());
    }

    public void onRetryLocation() {
        LocationUtil.getCurrentLocationOnce(new LocationUtil.LocationCallback() {
            public void onLocationError() {
                LogUtil.m14765i(AddressFeedMessagePresenter.f19424a, "onLocationError");
                AddressFeedMessagePresenter.this.m14546e();
                AddressFeedMessagePresenter.this.m14548g();
            }

            public void onLocationSuccess(LatLng latLng) {
                LogUtil.m14765i(AddressFeedMessagePresenter.f19424a, "onLocationSuccess");
                AddressFeedMessagePresenter.this.getAddressAllList();
            }
        });
    }

    public void onOpenLocationPermission() {
        LogUtil.m14765i(f19424a, "onOpenLocationPermission");
        LocalPermissionHelper.openPermissionSetting((Activity) GlobalContext.getContext());
    }

    public void showErrorView(int i, String str) {
        DeliveryAddressRvModel deliveryAddressRvModel = this.f19430g;
        if (deliveryAddressRvModel == null || this.f19429f.indexOf(deliveryAddressRvModel) < 0) {
            m14547f();
            AbnormalRvModel abnormalRvModel = new AbnormalRvModel();
            abnormalRvModel.mHeight = -1;
            if (NetWorkUtils.isNetworkConnected(getContext())) {
                abnormalRvModel.setAbnormalVm(AbnormalViewModelFactory.buildNoService(str, new View.OnClickListener() {
                    public final void onClick(View view) {
                        AddressFeedMessagePresenter.this.m14537b(view);
                    }
                }));
            } else {
                abnormalRvModel.setAbnormalVm(AbnormalViewModelFactory.buildNoNetwork(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AddressFeedMessagePresenter.this.m14528a(view);
                    }
                }));
            }
            this.f19429f.add(abnormalRvModel);
            return;
        }
        if (i == -1) {
            ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_remind_Unable_to_Wjlz));
        }
        m14546e();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m14537b(View view) {
        getAddressAllList();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m14528a(View view) {
        getAddressAllList();
    }

    /* renamed from: b */
    private void m14536b() {
        this.f19425b = getScopeContext().getBundle().getInt("from", -1);
    }

    /* renamed from: c */
    private void m14542c() {
        boolean i = m14550i();
        boolean hasValidLocation = LocationUtil.hasValidLocation();
        LogUtil.m14765i(f19424a, "initLocationData---- hasValidLocation=" + hasValidLocation + "----locationPermission=" + i);
        if (!i || !hasValidLocation) {
            DeliveryAddressRvModel buildLocationAddressRvModel = DeliveryAddressRvModel.buildLocationAddressRvModel((AddressEntity) null, m14549h(), m14550i(), false, true);
            this.f19430g = buildLocationAddressRvModel;
            this.f19429f.add(buildLocationAddressRvModel);
            return;
        }
        getAddressAllList();
    }

    /* renamed from: d */
    private void m14545d() {
        ((Contract.AbsAddressFeedMessageView) getLogicView()).showLoading();
        CustomerRpcManagerProxy.get().getAddressList(new CustomerRpcCallback<AddressPageListEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                AddressFeedMessagePresenter.this.showErrorView(sFRpcException.getCode(), sFRpcException.getMessage());
            }

            public void onRpcSuccess(AddressPageListEntity addressPageListEntity, long j) {
                ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                AddressFeedMessagePresenter.this.m14531a(addressPageListEntity);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14531a(AddressPageListEntity addressPageListEntity) {
        if (addressPageListEntity != null) {
            m14547f();
            if (AddressUtil.checkAddressValid(addressPageListEntity.locationAddress)) {
                m14539b(addressPageListEntity);
            } else {
                m14541b(addressPageListEntity.locationAddress);
            }
        }
    }

    /* renamed from: b */
    private void m14539b(AddressPageListEntity addressPageListEntity) {
        if (addressPageListEntity != null) {
            if (!CollectionsUtil.isEmpty(addressPageListEntity.nearbyAddress) || !CollectionsUtil.isEmpty(addressPageListEntity.addressList) || !CollectionsUtil.isEmpty(addressPageListEntity.sodaAddressList)) {
                ((Contract.AbsAddressFeedMessageView) getLogicView()).showLoadSuccess();
                m14544c(addressPageListEntity);
            } else {
                ((Contract.AbsAddressFeedMessageView) getLogicView()).showEmptyNearbyResult();
            }
            AddressOmegaHelper.INSTANCE.trackDeliverySearchExposureSw(this.f19425b, !CollectionsUtil.isEmpty(addressPageListEntity.nearbyAddress), this.f19427d, this.f19428e);
            AddressOmegaHelper.INSTANCE.trackDeliverySearchResultSw("", this.f19431h);
        }
    }

    /* renamed from: c */
    private void m14544c(AddressPageListEntity addressPageListEntity) {
        int i = 0;
        List<DeliveryAddressRvModel> buildAddressRvModelList = DeliveryAddressRvModel.buildAddressRvModelList(addressPageListEntity.nearbyAddress, 0);
        if (!CollectionsUtil.isEmpty(buildAddressRvModelList)) {
            AddressListTitleRvModel addressListTitleRvModel = new AddressListTitleRvModel();
            addressListTitleRvModel.title = ResourceHelper.getString(R.string.FoodC_search_Near_address_rIJX);
            addressListTitleRvModel.isFirst = true;
            this.f19429f.add(addressListTitleRvModel);
            this.f19429f.addAll(buildAddressRvModelList);
            i = buildAddressRvModelList.size();
        }
        List<DeliveryAddressRvModel> buildAddressRvModelList2 = DeliveryAddressRvModel.buildAddressRvModelList(addressPageListEntity.addressList, 3);
        List<DeliveryAddressRvModel> buildAddressRvModelList3 = DeliveryAddressRvModel.buildAddressRvModelList(addressPageListEntity.sodaAddressList, 2);
        if (!CollectionsUtil.isEmpty(buildAddressRvModelList2) || !CollectionsUtil.isEmpty(buildAddressRvModelList3)) {
            AddressListTitleRvModel addressListTitleRvModel2 = new AddressListTitleRvModel();
            this.f19432i = addressListTitleRvModel2;
            addressListTitleRvModel2.title = ResourceHelper.getString(R.string.FoodC_info_List_of_QGFT);
            this.f19429f.add(this.f19432i);
        }
        if (!CollectionsUtil.isEmpty(buildAddressRvModelList2)) {
            this.f19429f.addAll(buildAddressRvModelList2);
            this.f19428e = buildAddressRvModelList2.size();
        }
        if (!CollectionsUtil.isEmpty(buildAddressRvModelList3)) {
            AddressListSplitRvModel addressListSplitRvModel = new AddressListSplitRvModel();
            this.f19433j = addressListSplitRvModel;
            this.f19429f.add(addressListSplitRvModel);
            this.f19429f.addAll(buildAddressRvModelList3);
            this.f19427d = buildAddressRvModelList3.size();
        }
        this.f19431h = i + this.f19427d + this.f19428e;
    }

    /* renamed from: b */
    private void m14541b(AddressEntity addressEntity) {
        DeliveryAddressRvModel buildLocationAddressRvModel = DeliveryAddressRvModel.buildLocationAddressRvModel(addressEntity, m14549h(), m14550i(), false, this.f19429f.size() == 0);
        this.f19430g = buildLocationAddressRvModel;
        this.f19429f.add(0, buildLocationAddressRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m14546e() {
        boolean z = true;
        if (this.f19429f.size() != 1) {
            z = false;
        }
        DeliveryAddressRvModel deliveryAddressRvModel = this.f19430g;
        if (deliveryAddressRvModel != null) {
            deliveryAddressRvModel.setGpsEnable(m14549h(), m14550i(), z);
            this.f19429f.set(0, this.f19430g);
        }
    }

    /* renamed from: f */
    private void m14547f() {
        this.f19429f.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m14548g() {
        DeliveryAddressRvModel deliveryAddressRvModel = this.f19430g;
        if (deliveryAddressRvModel != null && AddressUtil.checkAddressValid(deliveryAddressRvModel.mAddress)) {
            ToastUtil.showCustomerErrorToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_search_Unable_to_UwcS));
        }
    }

    /* renamed from: h */
    private boolean m14549h() {
        return CustomerSystemUtil.isGpsEnabled(getContext());
    }

    /* renamed from: i */
    private boolean m14550i() {
        return LocalPermissionHelper.checkoutPermission((Activity) GlobalContext.getContext(), LocalPermissionHelper.LOCATION_PERMISSIONS);
    }

    public void onAddressDeleteClick(DeliveryAddressRvModel deliveryAddressRvModel) {
        DialogUtil.showWarningDialog(ResourceHelper.getString(R.string.FoodC_info_Delete_Records_IzwE), ResourceHelper.getString(R.string.FoodC_info_Confirm_deletion_JaYz), R.string.FoodC_up_Cancel_anHR, R.string.FoodC_up_Confirmation_hKaf, getScopeContext(), C7981xf6e56995.INSTANCE, new RFDialogInterface.OnClickListener(deliveryAddressRvModel) {
            public final /* synthetic */ DeliveryAddressRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(RFDialog rFDialog) {
                AddressFeedMessagePresenter.this.m14533a(this.f$1, rFDialog);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m14535a(RFDialog rFDialog) {
        if (rFDialog != null) {
            rFDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m14533a(DeliveryAddressRvModel deliveryAddressRvModel, RFDialog rFDialog) {
        if (rFDialog != null) {
            rFDialog.dismiss();
        }
        m14532a(deliveryAddressRvModel);
    }

    /* renamed from: a */
    private void m14532a(final DeliveryAddressRvModel deliveryAddressRvModel) {
        if (deliveryAddressRvModel.mAddress != null && !TextUtils.isEmpty(deliveryAddressRvModel.mAddress.aid)) {
            ((Contract.AbsAddressFeedMessageView) getLogicView()).showLoading();
            CustomerRpcManagerProxy.get().deleteContact(deliveryAddressRvModel.mAddress.aid, new CustomerRpcCallback<Object>() {
                public void onRpcSuccess(Object obj, long j) {
                    ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                    AddressFeedMessagePresenter.this.m14540b(deliveryAddressRvModel);
                }

                public void onRpcFailure(SFRpcException sFRpcException) {
                    super.onRpcFailure(sFRpcException);
                    ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                    String string = ResourceHelper.getString(R.string.FoodC_info_Unable_to_tlve);
                    if (sFRpcException != null && !TextUtils.isEmpty(sFRpcException.getMessage())) {
                        string = sFRpcException.getMessage();
                    }
                    ToastUtil.showCustomerErrorToast(AddressFeedMessagePresenter.this.getScopeContext(), string);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14540b(DeliveryAddressRvModel deliveryAddressRvModel) {
        AddressListSplitRvModel addressListSplitRvModel;
        this.f19429f.remove(this.f19429f.indexOf(deliveryAddressRvModel));
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.f19429f.size(); i++) {
            RecyclerModel recyclerModel = this.f19429f.get(i);
            if (recyclerModel instanceof DeliveryAddressRvModel) {
                int i2 = ((DeliveryAddressRvModel) recyclerModel).addressType;
                if (i2 == 3) {
                    z = true;
                } else if (i2 == 2) {
                    z2 = true;
                }
            }
        }
        if (!z && !z2) {
            AddressListTitleRvModel addressListTitleRvModel = this.f19432i;
            if (addressListTitleRvModel != null) {
                this.f19429f.remove(this.f19429f.indexOf(addressListTitleRvModel));
            }
            AddressListSplitRvModel addressListSplitRvModel2 = this.f19433j;
            if (addressListSplitRvModel2 != null) {
                this.f19429f.remove(this.f19429f.indexOf(addressListSplitRvModel2));
            }
        }
        if (!z && z2 && (addressListSplitRvModel = this.f19433j) != null) {
            this.f19429f.remove(this.f19429f.indexOf(addressListSplitRvModel));
        }
    }
}
