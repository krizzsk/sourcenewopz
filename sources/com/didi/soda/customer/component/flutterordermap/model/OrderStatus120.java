package com.didi.soda.customer.component.flutterordermap.model;

import com.didi.common.map.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class OrderStatus120 extends AbstractOrderStatus {
    public boolean needShowSpread() {
        return true;
    }

    public List<LatLng> getBestViewLocation() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mBusinessLatLng);
        arrayList.add(this.mCustomerLatLng);
        return arrayList;
    }

    public LatLng getTipLocation() {
        return this.mBusinessLatLng;
    }
}
