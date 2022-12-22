package com.didi.travel.psnger.model.response;

import com.didi.common.map.model.LatLng;
import com.didi.sdk.messagecenter.p152pb.OrderStat;
import java.util.List;

public class CarMoveBean {
    public int bizType;
    public LatLng carLatLng;
    public int carLevelType;
    public int channel;
    public String companyId;
    public long curRouteId;
    public long driverId;
    public List<Long> driversId;
    public LatLng endLatLng;
    public List<LatLng> etaList;
    public String extraPassengerDriver;
    public String imei;
    public boolean isNeedTraj;
    public String lastOrderId;
    public String orderId;
    public OrderStat orderStage;
    public String passengerPhone;
    public List<String> pickupFreeCompIds;
    public String sdkmaptype;
    public String sid;
    public LatLng startLatLng;
    public String token;
    public String travelId;
    public String version;
}
