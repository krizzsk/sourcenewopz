package com.didi.soda.address.component.feed.listener;

import com.didi.soda.address.component.feed.binder.DeliveryAddressRvModel;

public interface OnAddressHandleListener {
    void onAddressDeleteClick(DeliveryAddressRvModel deliveryAddressRvModel, int i);

    void onAddressEditClick(DeliveryAddressRvModel deliveryAddressRvModel, int i);
}
