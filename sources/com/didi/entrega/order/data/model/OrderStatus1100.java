package com.didi.entrega.order.data.model;

import com.didi.common.map.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class OrderStatus1100 extends AbstractOrderStatus {
    public boolean needShowSpread() {
        return true;
    }

    public List<LatLng> getBestViewLocation() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mSenderLatLng);
        return arrayList;
    }

    public LatLng getTipLocation() {
        return this.mSenderLatLng;
    }
}
