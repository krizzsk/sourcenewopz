package com.didi.map.global.component.line.data.param;

import com.didichuxing.routesearchsdk.CallFrom;

public class OrderTrajLineRequest extends BaseLineRequest {
    public int biztype;
    public String callerId;
    public String clientVersion;
    public long driverId;
    public long endTime;
    public String imei;
    public String passengerPhoneNumber;
    public String source;
    public long startTime;

    public OrderTrajLineRequest(CallFrom callFrom, String str) {
        super(callFrom, str);
    }
}
