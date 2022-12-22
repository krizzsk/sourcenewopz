package com.didi.entrega.order.data.model;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.MapData;

public class OrderMapStatusModel implements IEntity {
    private static final long serialVersionUID = 9152992050225749367L;
    private int isShowMap;
    private boolean mManualRefresh;
    private MapData mMapData;
    private String mOrderId;
    private int mOrderStatus;

    public OrderMapStatusModel(String str, int i, int i2, MapData mapData, boolean z) {
        this.mOrderId = str;
        this.mOrderStatus = i;
        this.mMapData = mapData;
        this.isShowMap = i2;
        this.mManualRefresh = z;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public int getOrderStatus() {
        return this.mOrderStatus;
    }

    public MapData getMapData() {
        return this.mMapData;
    }

    public int getIsShowMap() {
        return this.isShowMap;
    }

    public boolean isManualRefresh() {
        return this.mManualRefresh;
    }

    public void setManualRefresh(boolean z) {
        this.mManualRefresh = z;
    }
}
