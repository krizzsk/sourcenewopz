package com.didi.soda.address.component.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.didi.soda.address.component.search.Contract;
import com.didi.soda.address.component.search.SearchAddressComponent;
import com.didi.soda.address.model.AddressSearchRvModel;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.SearchPoiEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.router.DiRouter;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;

public class SearchAddressPresenter extends Contract.AbsSearchAddressPresenter {

    /* renamed from: a */
    private static final String f38680a = "SearchAddressPresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f38681b;

    /* renamed from: c */
    private SerialTaskQueue f38682c = new SerialTaskQueue();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Cancelable f38683d;

    /* renamed from: e */
    private int f38684e;

    /* renamed from: f */
    private String f38685f;

    /* renamed from: g */
    private int f38686g = 0;

    public void onCreate() {
        super.onCreate();
        m27402a();
    }

    public void showOrHide(boolean z, SearchAddressComponent.OnSearchAnimationListener onSearchAnimationListener) {
        ((Contract.AbsSearchAddressView) getLogicView()).showOrHideContent(z, onSearchAnimationListener);
        if (!z) {
            clearDataManagers();
        }
    }

    /* access modifiers changed from: package-private */
    public void onSearchTextChange(String str) {
        this.f38681b = str;
        if (TextUtils.isEmpty(str)) {
            this.f38682c.clear();
            Cancelable cancelable = this.f38683d;
            if (cancelable != null) {
                cancelable.cancel();
            }
            clearDataManagers();
            ((Contract.AbsSearchAddressView) getLogicView()).searchEmptyText();
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideSearchLoading(false);
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideLoading(false);
            return;
        }
        m27406a(true);
    }

    /* access modifiers changed from: package-private */
    public void onRetryAction() {
        ((Contract.AbsSearchAddressView) getLogicView()).hideLoadError();
        m27406a(false);
    }

    /* access modifiers changed from: package-private */
    public void onAddressSelected(AddressSearchRvModel addressSearchRvModel, int i) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        if (!ClickUtils.isFastClick()) {
            m27404a(addressSearchRvModel.mAddress, i);
            if (m27407b()) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("entity", addressSearchRvModel.mAddress);
                getScopeContext().getNavigator().finish(bundle);
            } else if (!LoginUtil.isLogin()) {
                ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByAddress(addressSearchRvModel.mAddress, 0);
                getScopeContext().getNavigator().finish();
            } else {
                DiRouter.request().path(RoutePath.ADDRESS_EDIT).putSerializable(Const.PageParams.ADDRESS_ENTITY, addressSearchRvModel.mAddress).putInt("from", 3).putBoolean(Const.PageParams.CHECK_STATUS, true).putBoolean(Const.PageParams.IS_FROM_BUSINESS, m27408c()).open();
            }
        }
    }

    /* renamed from: a */
    private void m27402a() {
        int i = getScopeContext().getBundle().getInt("from", -1);
        this.f38684e = i;
        if (i == 4) {
            AddressOmegaHelper.traceCartAddressPoiCk();
        }
    }

    /* renamed from: a */
    private void m27406a(boolean z) {
        if (z) {
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideSearchLoading(true);
        } else {
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideLoading(true);
        }
        this.f38683d = this.f38682c.append(new SearchAddressTask(new CustomerRpcCallback<SearchPoiEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideSearchLoading(false);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideLoading(false);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showLoadError(sFRpcException.getMessage());
                SearchAddressPresenter searchAddressPresenter = SearchAddressPresenter.this;
                searchAddressPresenter.m27405a((SearchPoiEntity) null, searchAddressPresenter.f38681b, false, String.valueOf(sFRpcException.getCode()), sFRpcException.getMessage());
                Cancelable unused = SearchAddressPresenter.this.f38683d = null;
            }

            public void onRpcSuccess(SearchPoiEntity searchPoiEntity, long j) {
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideSearchLoading(false);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideLoading(false);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showLoadSuccess();
                List<AddressSearchRvModel> convertFromSearchPoiEntity = AddressSearchRvModel.convertFromSearchPoiEntity(searchPoiEntity.poiList);
                if (convertFromSearchPoiEntity.size() > 0) {
                    SearchAddressPresenter.this.clearDataManagers();
                    SearchAddressPresenter searchAddressPresenter = SearchAddressPresenter.this;
                    searchAddressPresenter.addDataManager(searchAddressPresenter.createChildDataListManager(convertFromSearchPoiEntity));
                } else {
                    ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showLoadNoResult();
                }
                SearchAddressPresenter searchAddressPresenter2 = SearchAddressPresenter.this;
                searchAddressPresenter2.m27405a(searchPoiEntity, searchAddressPresenter2.f38681b, true, "", "");
                Cancelable unused = SearchAddressPresenter.this.f38683d = null;
            }
        }, this.f38681b), SerialTaskQueue.AppendMode.ReplaceStrict);
    }

    /* renamed from: b */
    private boolean m27407b() {
        int i = this.f38684e;
        return i == 4 || i == 9;
    }

    /* renamed from: c */
    private boolean m27408c() {
        return this.f38684e == 8;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27405a(SearchPoiEntity searchPoiEntity, String str, boolean z, String str2, String str3) {
        String str4;
        int i;
        if (searchPoiEntity != null) {
            this.f38685f = searchPoiEntity.recid;
            if (searchPoiEntity.poiList != null) {
                this.f38686g = searchPoiEntity.poiList.size();
                JsonArray jsonArray = new JsonArray();
                int i2 = 0;
                for (int i3 = 0; i3 < this.f38686g; i3++) {
                    AddressEntity.PoiEntity poiEntity = searchPoiEntity.poiList.get(i3);
                    if (!TextUtils.isEmpty(poiEntity.distStr)) {
                        i2 = 1;
                    }
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("index", (Number) Integer.valueOf(i3));
                    jsonObject.addProperty("poi_id", poiEntity.poiId);
                    jsonArray.add((JsonElement) jsonObject);
                }
                str4 = jsonArray.toString();
                i = i2;
                int i4 = CustomerSystemUtil.isGpsEnabled(getContext()) ? 1 : 0;
                AddressOmegaHelper.searchAddress(getScopeContext(), i4, str, this.f38686g, i, z, str2, str3, str4);
            }
        }
        str4 = "";
        i = 0;
        int i42 = CustomerSystemUtil.isGpsEnabled(getContext()) ? 1 : 0;
        AddressOmegaHelper.searchAddress(getScopeContext(), i42, str, this.f38686g, i, z, str2, str3, str4);
    }

    /* renamed from: a */
    private void m27404a(AddressEntity addressEntity, int i) {
        boolean isGpsEnabled = CustomerSystemUtil.isGpsEnabled(getContext());
        AddressOmegaHelper.trackSearchAddressClick(isGpsEnabled ? 1 : 0, this.f38681b, this.f38686g, i, addressEntity.poi);
    }
}
