package com.didi.soda.address.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.LiveData;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.address.component.feed.binder.DeliveryAddressRvModel;

public class AddressMessageRepo extends Repo<Object> {

    /* renamed from: a */
    LiveData<AddressAnimStatus> f38779a = new LiveData<>();

    /* renamed from: b */
    LiveData<DeliveryAddressRvModel> f38780b = new LiveData<>();

    public enum AddressAnimStatus {
        ANIM_START,
        ANIM_END
    }

    public void setAddressDragStatus(DeliveryAddressRvModel deliveryAddressRvModel, int i) {
        if (deliveryAddressRvModel.mDragStatus != i) {
            deliveryAddressRvModel.mDragStatus = i;
            this.f38780b.setValue(deliveryAddressRvModel);
        }
    }

    public void setAddressGuideAnimMessage(AddressAnimStatus addressAnimStatus) {
        this.f38779a.setValue(addressAnimStatus);
    }

    public boolean isAddressGuideAnimStart() {
        if (this.f38779a.getValue() == null || this.f38779a.getValue() != AddressAnimStatus.ANIM_START) {
            return false;
        }
        return true;
    }

    public Subscription subscribeAddressAnimMessage(ScopeContext scopeContext, Action<AddressAnimStatus> action) {
        return this.f38779a.from().subscribe(scopeContext, action);
    }

    public Subscription subscribeAddressDragStatus(ScopeContext scopeContext, Action<DeliveryAddressRvModel> action) {
        return this.f38780b.from().subscribe(scopeContext, action);
    }
}
