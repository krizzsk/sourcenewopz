package com.didi.soda.customer.component.flutterordermap.model;

import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapUtil;
import java.util.ArrayList;
import java.util.List;

public class OrderStatus200 extends AbstractOrderStatus {
    public List<LatLng> getBestViewLocation() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mBusinessLatLng);
        arrayList.add(this.mCustomerLatLng);
        return arrayList;
    }

    public boolean isSupportSliding() {
        if (this.mDeliveryType != 1 || !OrderMapUtil.checkRiderForBusinessPrepare(this.mOriginOrderStatus, this.mCeta21AB, this.mShowDeliveryStatus)) {
            return false;
        }
        return true;
    }

    public LatLng getTipLocation() {
        return this.mBusinessLatLng;
    }
}
