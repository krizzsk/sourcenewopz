package com.didi.rlab.uni_foundation.location;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didi.soda.customer.app.constant.Const;
import com.google.android.gms.location.FusedLocationProviderClient;
import java.util.HashMap;
import java.util.Map;

public class LocationResult extends UniModel {

    /* renamed from: a */
    private double f34057a;

    /* renamed from: b */
    private double f34058b;

    /* renamed from: c */
    private double f34059c;

    /* renamed from: d */
    private double f34060d;

    public double getLongtitude() {
        return this.f34057a;
    }

    public void setLongtitude(double d) {
        this.f34057a = d;
    }

    public double getLatitude() {
        return this.f34058b;
    }

    public void setLatitude(double d) {
        this.f34058b = d;
    }

    public double getHorizontalAccuracy() {
        return this.f34059c;
    }

    public void setHorizontalAccuracy(double d) {
        this.f34059c = d;
    }

    public double getVerticalAccuracy() {
        return this.f34060d;
    }

    public void setVerticalAccuracy(double d) {
        this.f34060d = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("longtitude", Double.valueOf(this.f34057a));
        hashMap.put(Const.PageParams.LATITUDE, Double.valueOf(this.f34058b));
        hashMap.put("horizontalAccuracy", Double.valueOf(this.f34059c));
        hashMap.put(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY, Double.valueOf(this.f34060d));
        return hashMap;
    }

    public static LocationResult fromMap(Map<String, Object> map) {
        LocationResult locationResult = new LocationResult();
        double d = 0.0d;
        locationResult.f34057a = (!map.containsKey("longtitude") || map.get("longtitude") == null) ? 0.0d : ((Double) map.get("longtitude")).doubleValue();
        locationResult.f34058b = (!map.containsKey(Const.PageParams.LATITUDE) || map.get(Const.PageParams.LATITUDE) == null) ? 0.0d : ((Double) map.get(Const.PageParams.LATITUDE)).doubleValue();
        locationResult.f34059c = (!map.containsKey("horizontalAccuracy") || map.get("horizontalAccuracy") == null) ? 0.0d : ((Double) map.get("horizontalAccuracy")).doubleValue();
        if (map.containsKey(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY) && map.get(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY) != null) {
            d = ((Double) map.get(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY)).doubleValue();
        }
        locationResult.f34060d = d;
        return locationResult;
    }
}
