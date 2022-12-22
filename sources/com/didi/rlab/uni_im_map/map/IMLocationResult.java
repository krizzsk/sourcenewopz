package com.didi.rlab.uni_im_map.map;

import com.didi.rlab.uni_im_map.uniapi.UniModel;
import com.didi.soda.customer.app.constant.Const;
import com.google.android.gms.location.FusedLocationProviderClient;
import java.util.HashMap;
import java.util.Map;

public class IMLocationResult extends UniModel {

    /* renamed from: a */
    private double f34172a;

    /* renamed from: b */
    private double f34173b;

    /* renamed from: c */
    private double f34174c;

    /* renamed from: d */
    private double f34175d;

    public double getLatitude() {
        return this.f34172a;
    }

    public void setLatitude(double d) {
        this.f34172a = d;
    }

    public double getLongtitude() {
        return this.f34173b;
    }

    public void setLongtitude(double d) {
        this.f34173b = d;
    }

    public double getHorizontalAccuracy() {
        return this.f34174c;
    }

    public void setHorizontalAccuracy(double d) {
        this.f34174c = d;
    }

    public double getVerticalAccuracy() {
        return this.f34175d;
    }

    public void setVerticalAccuracy(double d) {
        this.f34175d = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(Const.PageParams.LATITUDE, Double.valueOf(this.f34172a));
        hashMap.put("longtitude", Double.valueOf(this.f34173b));
        hashMap.put("horizontalAccuracy", Double.valueOf(this.f34174c));
        hashMap.put(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY, Double.valueOf(this.f34175d));
        return hashMap;
    }

    public static IMLocationResult fromMap(Map<String, Object> map) {
        IMLocationResult iMLocationResult = new IMLocationResult();
        double d = 0.0d;
        iMLocationResult.f34172a = (!map.containsKey(Const.PageParams.LATITUDE) || map.get(Const.PageParams.LATITUDE) == null) ? 0.0d : ((Double) map.get(Const.PageParams.LATITUDE)).doubleValue();
        iMLocationResult.f34173b = (!map.containsKey("longtitude") || map.get("longtitude") == null) ? 0.0d : ((Double) map.get("longtitude")).doubleValue();
        iMLocationResult.f34174c = (!map.containsKey("horizontalAccuracy") || map.get("horizontalAccuracy") == null) ? 0.0d : ((Double) map.get("horizontalAccuracy")).doubleValue();
        if (map.containsKey(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY) && map.get(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY) != null) {
            d = ((Double) map.get(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY)).doubleValue();
        }
        iMLocationResult.f34175d = d;
        return iMLocationResult;
    }
}
