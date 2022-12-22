package com.didi.travel.psnger.model;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class DepartureWindowInfo {
    public int distance;
    public int driverSize;
    public List<LatLng> driversPosition;
    public int eta;
    public String etaStr;
    public int redirect;
}
