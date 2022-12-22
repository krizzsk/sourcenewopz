package com.didi.soda.customer.component.flutterordermap.data;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.MapData;

public class OrderMapStatusModel implements IEntity {
    private static final long serialVersionUID = 6694190357023392259L;
    public int mBusinessMode;
    public int mCeta21AB;
    public int mDeliveryType;
    public MapData mMapData;
    private String mOrderId;
    private int mOrderStatus;
    public int mShopPrepareStatus;
    public int mShowDeliveryStatus;
    public boolean manualMapRest;

    public OrderMapStatusModel(String str, int i, int i2, int i3, MapData mapData) {
        this(str, i, i2, i3, mapData, 1, 0, 0);
    }

    public OrderMapStatusModel(String str, int i, int i2, int i3, MapData mapData, int i4, int i5, int i6) {
        this.mDeliveryType = 0;
        this.mBusinessMode = 0;
        this.mOrderId = str;
        this.mOrderStatus = i;
        this.mDeliveryType = i2;
        this.mBusinessMode = i3;
        this.mMapData = mapData;
        this.mCeta21AB = i4;
        this.mShowDeliveryStatus = i5;
        this.mShopPrepareStatus = i6;
        this.manualMapRest = false;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public int getOrderStatus() {
        return this.mOrderStatus;
    }

    public void setOrderStatus(int i) {
        this.mOrderStatus = i;
    }

    public String toString() {
        return "OrderMapStatusModel{mOrderId='" + this.mOrderId + '\'' + ", mOrderStatus=" + this.mOrderStatus + ", mDeliveryType=" + this.mDeliveryType + ", mMapData=" + this.mMapData + '}';
    }
}
