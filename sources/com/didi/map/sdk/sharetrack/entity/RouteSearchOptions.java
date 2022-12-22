package com.didi.map.sdk.sharetrack.entity;

import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import java.util.List;

public class RouteSearchOptions {
    public static final int CALC_TYPE_DRAW_LINE = 1;
    public static final int CALC_TYPE_DRAW_NAV = 0;
    public double altitude;
    public ISearchRouteCallback callback;
    public LineOptions currentLineOptions;
    public LatLng destination;
    public int direction;
    public DriverOrderRouteReqParam driverReqParam;
    public GpsLocation gpsLocation;
    public boolean isDriverReq;
    public boolean isSctx = true;
    public int lineColor;
    public int lineWidth = 0;
    public int lineZindex;
    public List<OrderPoint> orderPoints;
    public String phoneNumber;
    public LineOptions remainLineOptions;
    public LatLng start;
    public long time;
    public String token;
    public int type;
    public float velocity;
    public boolean withTraffic;

    public RouteSearchOptions(LatLng latLng, LatLng latLng2) {
        this.start = latLng;
        this.destination = latLng2;
    }

    public RouteSearchOptions(GpsLocation gpsLocation2, LatLng latLng, LatLng latLng2) {
        this.gpsLocation = gpsLocation2;
        this.start = latLng;
        this.destination = latLng2;
    }
}
