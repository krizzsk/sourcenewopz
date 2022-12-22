package com.didi.soda.customer.component.flutterordermap.model;

import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusModel;
import java.util.List;

public abstract class AbstractOrderStatus {
    protected LatLng mBusinessLatLng;
    public int mBusinessMode = 0;
    protected int mCeta21AB;
    protected LatLng mCustomerLatLng;
    protected LatLng mDeliveryLatLng;
    protected int mDeliveryType;
    protected int mOriginOrderStatus;
    protected int mShowDeliveryStatus;

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
        this.mBusinessLatLng = latLng;
        this.mCustomerLatLng = latLng2;
        this.mDeliveryLatLng = latLng3;
    }

    public void updateOrderData(OrderMapStatusModel orderMapStatusModel) {
        if (orderMapStatusModel != null) {
            this.mCeta21AB = orderMapStatusModel.mCeta21AB;
            this.mShowDeliveryStatus = orderMapStatusModel.mShowDeliveryStatus;
            this.mOriginOrderStatus = orderMapStatusModel.getOrderStatus();
            setDeliveryType(orderMapStatusModel.mDeliveryType, orderMapStatusModel.mBusinessMode);
        }
    }

    public void setDeliveryType(int i, int i2) {
        this.mDeliveryType = i;
        this.mBusinessMode = i2;
    }
}
