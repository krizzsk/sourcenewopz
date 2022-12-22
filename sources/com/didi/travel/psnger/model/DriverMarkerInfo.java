package com.didi.travel.psnger.model;

import com.didi.common.map.model.Marker;
import java.io.Serializable;

public class DriverMarkerInfo implements Serializable, Cloneable {
    public static final int HIDE = 3;
    public static final int NORMAL = 0;
    public static final int SHOW = 1;
    public int distance;
    public Marker driverMarker;
    public int eta;
    public int markerStatus;
    public String markerTag;
    public int state;
}
