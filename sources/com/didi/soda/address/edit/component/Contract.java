package com.didi.soda.address.edit.component;

import com.didi.soda.address.edit.binder.EditAddressModel;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/address/edit/component/Contract;", "", "AbsEditAddressInfoPresent", "AbsEditAddressInfoView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H&J\b\u0010\u0019\u001a\u00020\u0005H&J\b\u0010\u001a\u001a\u00020\u0005H&J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#H&J\b\u0010$\u001a\u00020\u0005H&J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001dH&J\u001c\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00172\b\u0010)\u001a\u0004\u0018\u00010\u0017H&¨\u0006*"}, mo175978d2 = {"Lcom/didi/soda/address/edit/component/Contract$AbsEditAddressInfoPresent;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/soda/address/edit/component/Contract$AbsEditAddressInfoView;", "()V", "freshAddressTipStatus", "", "alreadyOperated", "", "getReversePoi", "lat", "", "lng", "isAddressClickable", "isContactShow", "isTypeAid", "isUseBillAddressStrategy", "needShowAddressTips", "onAddressClick", "onBindFinish", "height", "", "onCountryResult", "callingCode", "", "countryId", "onFinish", "resetModel", "saveAddress", "addressModel", "Lcom/didi/soda/address/edit/binder/EditAddressModel;", "saveContact", "contact", "Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;", "setEmptyHeight", "distance", "", "traceConfirmClick", "updateByModel", "editAddress", "updateHouseBuildName", "houseNumber", "buildName", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsEditAddressInfoPresent extends CustomerRecyclerPresenter<AbsEditAddressInfoView> {
        public abstract void freshAddressTipStatus(boolean z);

        public abstract void getReversePoi(double d, double d2);

        public abstract boolean isAddressClickable();

        public abstract boolean isContactShow();

        public abstract boolean isTypeAid();

        public abstract boolean isUseBillAddressStrategy();

        public abstract boolean needShowAddressTips();

        public abstract void onAddressClick();

        public abstract void onBindFinish(int i);

        public abstract void onCountryResult(String str, int i);

        public abstract void onFinish();

        public abstract void resetModel();

        public abstract void saveAddress(EditAddressModel editAddressModel);

        public abstract void saveContact(ContactEntity contactEntity);

        public abstract void setEmptyHeight(float f);

        public abstract void traceConfirmClick();

        public abstract void updateByModel(EditAddressModel editAddressModel);

        public abstract void updateHouseBuildName(String str, String str2);
    }

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/address/edit/component/Contract$AbsEditAddressInfoView;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/soda/address/edit/component/Contract$AbsEditAddressInfoPresent;", "()V", "centerBestView", "", "editAddress", "Lcom/didi/soda/address/edit/binder/EditAddressModel;", "topEmptyHeight", "", "hideLoading", "hidePinLoading", "barStr", "", "isMapGesture", "", "pinLoading", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsEditAddressInfoView extends CustomerRecyclerView<AbsEditAddressInfoPresent> {
        public abstract void centerBestView(EditAddressModel editAddressModel, int i);

        public abstract void hideLoading();

        public abstract void hidePinLoading(String str, boolean z);

        public abstract void pinLoading();
    }
}
