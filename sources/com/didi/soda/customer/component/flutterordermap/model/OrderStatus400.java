package com.didi.soda.customer.component.flutterordermap.model;

import com.didi.common.map.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class OrderStatus400 extends AbstractOrderStatus {
    public boolean isMarkerInfoWindowTip() {
        return true;
    }

    public boolean isSupportSliding() {
        return this.mDeliveryType == 1;
    }

    public List<LatLng> getBestViewLocation() {
        ArrayList arrayList = new ArrayList();
        if (this.mDeliveryType == 2) {
            arrayList.add(this.mBusinessLatLng);
        } else {
            arrayList.add(this.mDeliveryLatLng);
        }
        arrayList.add(this.mCustomerLatLng);
        return arrayList;
    }

    public LatLng getTipLocation() {
        if (isMarkerInfoWindowTip()) {
            return null;
        }
        return this.mDeliveryLatLng;
    }
}
