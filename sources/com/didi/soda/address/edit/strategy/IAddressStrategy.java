package com.didi.soda.address.edit.strategy;

import com.didi.soda.address.edit.binder.EditAddressModel;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\nH&¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/address/edit/strategy/IAddressStrategy;", "", "getBottomHeight", "", "getPromptScene", "handleAddressClick", "", "editAddressModel", "Lcom/didi/soda/address/edit/binder/EditAddressModel;", "isAddressClickAble", "", "saveAddressSuccess", "address", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "isDeliveryAddress", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IAddressStrategy.kt */
public interface IAddressStrategy {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IAddressStrategy.kt */
    public static final class DefaultImpls {
        public static int getPromptScene(IAddressStrategy iAddressStrategy) {
            Intrinsics.checkNotNullParameter(iAddressStrategy, "this");
            return 0;
        }
    }

    int getBottomHeight();

    int getPromptScene();

    void handleAddressClick(EditAddressModel editAddressModel);

    boolean isAddressClickAble();

    void saveAddressSuccess(AddressEntity addressEntity, boolean z);
}
