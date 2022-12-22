package com.didi.entrega.address.list.component.search.core;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.entrega.address.data.entity.AddressCheckEntity;
import com.didi.entrega.address.list.component.search.SearchAddressComponent;
import com.didi.entrega.address.list.component.search.core.Contract;
import com.didi.entrega.address.list.component.search.model.AddressSearchRvModel;
import com.didi.entrega.address.list.component.search.model.SearchPoiEntity;
import com.didi.entrega.address.utils.AddressUtil;
import com.didi.entrega.address.utils.omega.AddressOmegaHelper;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.ClickUtils;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.taxis99.R;
import java.util.List;

public class SearchAddressPresenter extends Contract.AbsSearchAddressPresenter {

    /* renamed from: a */
    private static final String f19440a = "SearchAddressPresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f19441b;

    /* renamed from: c */
    private SerialTaskQueue f19442c = new SerialTaskQueue();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Cancelable f19443d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f19444e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ChildDataListManager<RecyclerModel> f19445f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f19446g;

    public void onCreate() {
        super.onCreate();
        m14555a();
    }

    /* renamed from: a */
    private void m14555a() {
        this.f19446g = getScopeContext().getBundle().getInt("from", -1);
        if (this.f19445f == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f19445f = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }

    public void showOrHide(boolean z, SearchAddressComponent.OnSearchAnimationListener onSearchAnimationListener) {
        ((Contract.AbsSearchAddressView) getLogicView()).showOrHideContent(z, onSearchAnimationListener);
        if (!z) {
            ChildDataListManager<RecyclerModel> childDataListManager = this.f19445f;
            if (childDataListManager != null && childDataListManager.size() > 0) {
                this.f19445f.clear();
                return;
            }
            return;
        }
        AddressOmegaHelper.INSTANCE.trackDeliverySearchInputCk();
    }

    /* access modifiers changed from: package-private */
    public void onSearchTextChange(String str) {
        this.f19441b = str;
        if (TextUtils.isEmpty(str)) {
            this.f19442c.clear();
            Cancelable cancelable = this.f19443d;
            if (cancelable != null) {
                cancelable.cancel();
            }
            ChildDataListManager<RecyclerModel> childDataListManager = this.f19445f;
            if (childDataListManager != null && childDataListManager.size() > 0) {
                this.f19445f.clear();
            }
            ((Contract.AbsSearchAddressView) getLogicView()).searchEmptyText();
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideSearchLoading(false);
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideLoading(false);
            return;
        }
        m14557a(true);
    }

    /* access modifiers changed from: package-private */
    public void onRetryAction() {
        ((Contract.AbsSearchAddressView) getLogicView()).hideLoadError();
        m14557a(false);
    }

    /* access modifiers changed from: package-private */
    public void onAddressSelected(AddressSearchRvModel addressSearchRvModel) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        if (!ClickUtils.isFastClick()) {
            ChildDataListManager<RecyclerModel> childDataListManager = this.f19445f;
            if (childDataListManager == null || addressSearchRvModel == null) {
                LogUtil.m14765i(f19440a, " mSearchListManager is " + this.f19445f + " addressSearchRvModel is " + addressSearchRvModel);
                return;
            }
            AddressOmegaHelper.INSTANCE.trackDeliverySearchResultCk(this.f19441b, this.f19444e, childDataListManager.indexOf(addressSearchRvModel), 1, this.f19446g);
            m14556a(addressSearchRvModel.mAddress);
        }
    }

    /* renamed from: a */
    private void m14556a(AddressEntity addressEntity) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        final AddressEntity addressEntity2 = addressEntity;
        if (AddressUtil.checkAddressValid(addressEntity)) {
            ((Contract.AbsSearchAddressView) getLogicView()).showCheckLoading();
            double d6 = 0.0d;
            if (AddressUtil.isSenderAddressSelected(this.f19446g)) {
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
            CustomerRpcManagerProxy.get().checkAddress(d3, d2, d, d4, 2, this.f19446g, new CustomerRpcCallback<AddressCheckEntity>() {
                public void onRpcSuccess(AddressCheckEntity addressCheckEntity, long j) {
                    ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).hideCheckLoading();
                    if (addressCheckEntity == null) {
                        return;
                    }
                    if (addressCheckEntity.legal) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("entity", addressEntity2);
                        SearchAddressPresenter.this.getScopeContext().getNavigator().finish(bundle);
                    } else if (!TextUtils.isEmpty(addressCheckEntity.content)) {
                        ToastUtil.showCustomerToast(SearchAddressPresenter.this.getScopeContext(), addressCheckEntity.content);
                        AddressOmegaHelper.INSTANCE.trackDeliverySearchResultToastSw(SearchAddressPresenter.this.f19441b, addressCheckEntity.toastType, SearchAddressPresenter.this.f19446g);
                    }
                }

                public void onRpcFailure(SFRpcException sFRpcException) {
                    super.onRpcFailure(sFRpcException);
                    ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).hideCheckLoading();
                    ToastUtil.showCustomerToast(SearchAddressPresenter.this.getScopeContext(), ResourceHelper.getString(R.string.FoodC_orderlist3_Check_the_uDiY));
                }
            });
            return;
        }
        ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_search_Address_error_jdye));
    }

    /* renamed from: a */
    private void m14557a(boolean z) {
        if (z) {
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideSearchLoading(true);
        } else {
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideLoading(true);
        }
        this.f19443d = this.f19442c.append(new SearchAddressTask(new CustomerRpcCallback<SearchPoiEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideSearchLoading(false);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideLoading(false);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showLoadError(sFRpcException.getMessage());
                Cancelable unused = SearchAddressPresenter.this.f19443d = null;
            }

            public void onRpcSuccess(SearchPoiEntity searchPoiEntity, long j) {
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideSearchLoading(false);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideLoading(false);
                if (searchPoiEntity != null) {
                    ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showLoadSuccess();
                    List<AddressSearchRvModel> convertFromSearchPoiEntity = AddressSearchRvModel.convertFromSearchPoiEntity(searchPoiEntity.poiList);
                    if (SearchAddressPresenter.this.f19445f != null && SearchAddressPresenter.this.f19445f.size() > 0) {
                        SearchAddressPresenter.this.f19445f.clear();
                    }
                    int unused = SearchAddressPresenter.this.f19444e = convertFromSearchPoiEntity.size();
                    if (SearchAddressPresenter.this.f19444e > 0) {
                        SearchAddressPresenter.this.f19445f.addAll(convertFromSearchPoiEntity);
                    } else {
                        ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showLoadNoResult();
                    }
                    AddressOmegaHelper.INSTANCE.trackDeliverySearchResultSw(SearchAddressPresenter.this.f19441b, SearchAddressPresenter.this.f19444e);
                } else {
                    ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showLoadError(ResourceHelper.getString(R.string.FoodC_remind_Unable_to_LXKj));
                }
                Cancelable unused2 = SearchAddressPresenter.this.f19443d = null;
            }
        }, this.f19441b), SerialTaskQueue.AppendMode.ReplaceStrict);
    }
}
