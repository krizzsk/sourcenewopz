package com.didi.map.sdk.nav.inertia;

import com.map.sdk.nav.libc.common.MapMatchType;

public class CarMoveInfo {
    public MapMatchType bindResult;
    public long gpsTime;
    public double lat;
    public long localTime;
    public double lon;
    public int source;
    public int type;
}
