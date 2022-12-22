package com.didi.soda.address.component.feed;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.address.component.feed.binder.DeliveryAddressRvModel;

class AddressFeedMessagePresenter$2 implements Action1<DeliveryAddressRvModel> {
    final /* synthetic */ C13370a this$0;

    AddressFeedMessagePresenter$2(C13370a aVar) {
        this.this$0 = aVar;
    }

    public void call(DeliveryAddressRvModel deliveryAddressRvModel) {
        int indexOf = this.this$0.f38669e.indexOf(deliveryAddressRvModel);
        if (indexOf >= 0 && indexOf < this.this$0.f38669e.size()) {
            this.this$0.f38669e.set(indexOf, deliveryAddressRvModel);
        }
    }
}
