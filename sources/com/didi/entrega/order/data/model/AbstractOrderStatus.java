package com.didi.entrega.order.data.model;

import com.didi.common.map.model.LatLng;
import java.util.List;

public abstract class AbstractOrderStatus {
    protected LatLng mReceiverLatLng;
    protected LatLng mRiderLatLng;
    protected LatLng mSenderLatLng;

    public abstract List<LatLng> getBestViewLocation();

    public abstract LatLng getTipLocation();

    public boolean isMarkerInfoWindowTip() {
        return false;
    }

    public boolean isSupportSliding() {
        return false;
    }

    public boolean needShowSpread() {
        return false;
    }

    public void setLocation(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        this.mSenderLatLng = latLng;
        this.mReceiverLatLng = latLng2;
        this.mRiderLatLng = latLng3;
    }
}
