package com.didi.component.common.router.eevee;

import android.content.Context;
import android.os.Bundle;
import com.didi.address.AddressResult;
import com.didi.app.router.PageRouter;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.IGroupView;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.address.address.entity.Address;
import com.didiglobal.common.common.constant.ECompConstant;
import com.taxis99.R;

public class ESugCallbackHandler implements IRouterHandler {

    /* renamed from: a */
    private Context f11716a;
    protected Address mEndAddress;
    protected Address mStartAddress;

    public void handle(Request request, Result result) {
        this.f11716a = request.getContext();
        AddressResult addressResult = (AddressResult) request.getSerializable(ECompConstant.E_SUG_RESULT_PARAMS);
        if (addressResult != null) {
            FormStore.getInstance().updateStartAddressSrcTypeBySug();
            handleSugPageResult(addressResult);
        }
    }

    /* access modifiers changed from: protected */
    public void handleSugPageResult(AddressResult addressResult) {
        if (addressResult != null) {
            this.mStartAddress = addressResult.start;
            Address address = addressResult.end;
            this.mEndAddress = address;
            if (address != null) {
                SearchIdUploadManager.getInstance().addSearchId(this.mEndAddress.searchId);
            }
            if (this.mStartAddress == null) {
                this.mStartAddress = m7939a();
            }
            Address address2 = this.mStartAddress;
            if (address2 == null || this.mEndAddress == null) {
                GLog.m7973w("handleSugPageResult mEndAddress:" + this.mEndAddress);
                return;
            }
            m7942a(address2, addressResult.isStartNeedNearRoad, this.mEndAddress);
            return;
        }
        GLog.m7973w("handleSugPageResult addressResult is null");
    }

    /* renamed from: a */
    private Address m7939a() {
        Address reverseAddress = LocationController.getInstance() != null ? LocationController.getInstance().getReverseAddress() : null;
        if (reverseAddress != null) {
            return reverseAddress;
        }
        Address address = new Address();
        address.setLatitude(0.0d);
        address.setLongitude(0.0d);
        address.setCityId(-1);
        String string = this.f11716a.getResources().getString(R.string.global_sug_current_location);
        address.setDisplayName(string);
        address.setAddress(string);
        address.setFullName(string);
        return address;
    }

    /* renamed from: a */
    private void m7942a(Address address, boolean z, Address address2) {
        if (NationComponentDataUtil.isLoginNow()) {
            m7941a(address, z);
            m7940a(address2);
            Bundle bundle = new Bundle();
            bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
            PageRouter.getInstance().forward(1030, bundle);
        }
    }

    /* renamed from: a */
    private void m7940a(Address address) {
        FormStore instance = FormStore.getInstance();
        if (address != null) {
            instance.setEndAddress(address);
        } else {
            GLog.m7964d("setAddress null");
        }
    }

    /* renamed from: a */
    private void m7941a(Address address, boolean z) {
        if (address != null) {
            FormStore.getInstance().setStartAddress(address, z);
        } else {
            GLog.m7964d("setAddress null");
        }
    }
}
