package com.didi.soda.business.component.address;

import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/business/component/address/Contract;", "", "AbsBusinessAddressMapPresenter", "AbsBusinessAddressMapView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/business/component/address/Contract$AbsBusinessAddressMapPresenter;", "Lcom/didi/soda/customer/base/ICustomerPresenter;", "Lcom/didi/soda/business/component/address/Contract$AbsBusinessAddressMapView;", "()V", "onPageClose", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsBusinessAddressMapPresenter extends ICustomerPresenter<AbsBusinessAddressMapView> {
        public abstract void onPageClose();
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/business/component/address/Contract$AbsBusinessAddressMapView;", "Lcom/didi/soda/customer/base/ICustomerView;", "Lcom/didi/soda/business/component/address/Contract$AbsBusinessAddressMapPresenter;", "()V", "showBusinessInfoText", "", "name", "", "address", "showLocationMarkView", "customerLatLng", "Lcom/didi/common/map/model/LatLng;", "businessLatLng", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsBusinessAddressMapView extends ICustomerView<AbsBusinessAddressMapPresenter> {
        public abstract void showBusinessInfoText(String str, String str2);

        public abstract void showLocationMarkView(LatLng latLng, LatLng latLng2);
    }
}
