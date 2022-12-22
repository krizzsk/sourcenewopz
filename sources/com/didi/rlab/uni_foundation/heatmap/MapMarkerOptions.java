package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didi.soda.customer.app.constant.Const;
import java.util.HashMap;
import java.util.Map;

public class MapMarkerOptions extends UniModel {

    /* renamed from: a */
    private String f34033a;

    /* renamed from: b */
    private String f34034b;

    /* renamed from: c */
    private long f34035c;

    /* renamed from: d */
    private double f34036d;

    /* renamed from: e */
    private double f34037e;

    /* renamed from: f */
    private double f34038f;

    /* renamed from: g */
    private double f34039g;

    /* renamed from: h */
    private double f34040h;

    /* renamed from: i */
    private String f34041i;

    /* renamed from: j */
    private double f34042j;

    /* renamed from: k */
    private double f34043k;

    /* renamed from: l */
    private boolean f34044l;

    public String getIcon() {
        return this.f34033a;
    }

    public void setIcon(String str) {
        this.f34033a = str;
    }

    public String getTitle() {
        return this.f34034b;
    }

    public void setTitle(String str) {
        this.f34034b = str;
    }

    public long getZIndex() {
        return this.f34035c;
    }

    public void setZIndex(long j) {
        this.f34035c = j;
    }

    public double getAlpha() {
        return this.f34036d;
    }

    public void setAlpha(double d) {
        this.f34036d = d;
    }

    public double getAnchorU() {
        return this.f34037e;
    }

    public void setAnchorU(double d) {
        this.f34037e = d;
    }

    public double getAnchorV() {
        return this.f34038f;
    }

    public void setAnchorV(double d) {
        this.f34038f = d;
    }

    public double getLatitude() {
        return this.f34039g;
    }

    public void setLatitude(double d) {
        this.f34039g = d;
    }

    public double getLongitude() {
        return this.f34040h;
    }

    public void setLongitude(double d) {
        this.f34040h = d;
    }

    public String getTag() {
        return this.f34041i;
    }

    public void setTag(String str) {
        this.f34041i = str;
    }

    public double getRotation() {
        return this.f34042j;
    }

    public void setRotation(double d) {
        this.f34042j = d;
    }

    public double getSize() {
        return this.f34043k;
    }

    public void setSize(double d) {
        this.f34043k = d;
    }

    public boolean getDodge() {
        return this.f34044l;
    }

    public void setDodge(boolean z) {
        this.f34044l = z;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("icon", this.f34033a);
        hashMap.put("title", this.f34034b);
        hashMap.put("zIndex", Long.valueOf(this.f34035c));
        hashMap.put("alpha", Double.valueOf(this.f34036d));
        hashMap.put("anchorU", Double.valueOf(this.f34037e));
        hashMap.put("anchorV", Double.valueOf(this.f34038f));
        hashMap.put(Const.PageParams.LATITUDE, Double.valueOf(this.f34039g));
        hashMap.put(Const.PageParams.LONGITUDE, Double.valueOf(this.f34040h));
        hashMap.put("tag", this.f34041i);
        hashMap.put("rotation", Double.valueOf(this.f34042j));
        hashMap.put("size", Double.valueOf(this.f34043k));
        hashMap.put("dodge", Boolean.valueOf(this.f34044l));
        return hashMap;
    }

    public static MapMarkerOptions fromMap(Map<String, Object> map) {
        MapMarkerOptions mapMarkerOptions = new MapMarkerOptions();
        String str = "";
        mapMarkerOptions.f34033a = (!map.containsKey("icon") || map.get("icon") == null) ? str : (String) map.get("icon");
        mapMarkerOptions.f34034b = (!map.containsKey("title") || map.get("title") == null) ? str : (String) map.get("title");
        mapMarkerOptions.f34035c = (!map.containsKey("zIndex") || map.get("zIndex") == null) ? 0 : ((Number) map.get("zIndex")).longValue();
        double d = 0.0d;
        mapMarkerOptions.f34036d = (!map.containsKey("alpha") || map.get("alpha") == null) ? 0.0d : ((Double) map.get("alpha")).doubleValue();
        mapMarkerOptions.f34037e = (!map.containsKey("anchorU") || map.get("anchorU") == null) ? 0.0d : ((Double) map.get("anchorU")).doubleValue();
        mapMarkerOptions.f34038f = (!map.containsKey("anchorV") || map.get("anchorV") == null) ? 0.0d : ((Double) map.get("anchorV")).doubleValue();
        mapMarkerOptions.f34039g = (!map.containsKey(Const.PageParams.LATITUDE) || map.get(Const.PageParams.LATITUDE) == null) ? 0.0d : ((Double) map.get(Const.PageParams.LATITUDE)).doubleValue();
        mapMarkerOptions.f34040h = (!map.containsKey(Const.PageParams.LONGITUDE) || map.get(Const.PageParams.LONGITUDE) == null) ? 0.0d : ((Double) map.get(Const.PageParams.LONGITUDE)).doubleValue();
        if (map.containsKey("tag") && map.get("tag") != null) {
            str = (String) map.get("tag");
        }
        mapMarkerOptions.f34041i = str;
        mapMarkerOptions.f34042j = (!map.containsKey("rotation") || map.get("rotation") == null) ? 0.0d : ((Double) map.get("rotation")).doubleValue();
        if (map.containsKey("size") && map.get("size") != null) {
            d = ((Double) map.get("size")).doubleValue();
        }
        mapMarkerOptions.f34043k = d;
        mapMarkerOptions.f34044l = (!map.containsKey("dodge") || map.get("dodge") == null) ? false : ((Boolean) map.get("dodge")).booleanValue();
        return mapMarkerOptions;
    }
}
