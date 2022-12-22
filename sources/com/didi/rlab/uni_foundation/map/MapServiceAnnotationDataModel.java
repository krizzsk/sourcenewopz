package com.didi.rlab.uni_foundation.map;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.rider.rlab_im_map_plugin.tool.ImCommons;
import java.util.HashMap;
import java.util.Map;

public class MapServiceAnnotationDataModel extends UniModel {

    /* renamed from: a */
    private String f34062a;

    /* renamed from: b */
    private double f34063b;

    /* renamed from: c */
    private double f34064c;

    /* renamed from: d */
    private String f34065d;

    /* renamed from: e */
    private long f34066e;

    /* renamed from: f */
    private boolean f34067f;

    /* renamed from: g */
    private long f34068g;

    /* renamed from: h */
    private long f34069h;

    /* renamed from: i */
    private double f34070i;

    /* renamed from: j */
    private double f34071j;

    /* renamed from: k */
    private String f34072k;

    /* renamed from: l */
    private Map<String, String> f34073l;

    public String getAddressName() {
        return this.f34062a;
    }

    public void setAddressName(String str) {
        this.f34062a = str;
    }

    public double getLat() {
        return this.f34063b;
    }

    public void setLat(double d) {
        this.f34063b = d;
    }

    public double getLng() {
        return this.f34064c;
    }

    public void setLng(double d) {
        this.f34064c = d;
    }

    public String getImagePath() {
        return this.f34065d;
    }

    public void setImagePath(String str) {
        this.f34065d = str;
    }

    public long getImagePosition() {
        return this.f34066e;
    }

    public void setImagePosition(long j) {
        this.f34066e = j;
    }

    public boolean getEnable() {
        return this.f34067f;
    }

    public void setEnable(boolean z) {
        this.f34067f = z;
    }

    public long getCalloutType() {
        return this.f34068g;
    }

    public void setCalloutType(long j) {
        this.f34068g = j;
    }

    public long getZIndex() {
        return this.f34069h;
    }

    public void setZIndex(long j) {
        this.f34069h = j;
    }

    public double getAnchorU() {
        return this.f34070i;
    }

    public void setAnchorU(double d) {
        this.f34070i = d;
    }

    public double getAnchorV() {
        return this.f34071j;
    }

    public void setAnchorV(double d) {
        this.f34071j = d;
    }

    public String getAirBgPath() {
        return this.f34072k;
    }

    public void setAirBgPath(String str) {
        this.f34072k = str;
    }

    public Map<String, String> getExtParams() {
        return this.f34073l;
    }

    public void setExtParams(Map<String, String> map) {
        this.f34073l = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("addressName", this.f34062a);
        hashMap.put("lat", Double.valueOf(this.f34063b));
        hashMap.put("lng", Double.valueOf(this.f34064c));
        hashMap.put("imagePath", this.f34065d);
        hashMap.put("imagePosition", Long.valueOf(this.f34066e));
        hashMap.put("enable", Boolean.valueOf(this.f34067f));
        hashMap.put("calloutType", Long.valueOf(this.f34068g));
        hashMap.put("zIndex", Long.valueOf(this.f34069h));
        hashMap.put("anchorU", Double.valueOf(this.f34070i));
        hashMap.put("anchorV", Double.valueOf(this.f34071j));
        hashMap.put("airBgPath", this.f34072k);
        hashMap.put(ImCommons.BUNDLE_MAP, this.f34073l);
        return hashMap;
    }

    public static MapServiceAnnotationDataModel fromMap(Map<String, Object> map) {
        MapServiceAnnotationDataModel mapServiceAnnotationDataModel = new MapServiceAnnotationDataModel();
        String str = "";
        mapServiceAnnotationDataModel.f34062a = (!map.containsKey("addressName") || map.get("addressName") == null) ? str : (String) map.get("addressName");
        double d = 0.0d;
        mapServiceAnnotationDataModel.f34063b = (!map.containsKey("lat") || map.get("lat") == null) ? 0.0d : ((Double) map.get("lat")).doubleValue();
        mapServiceAnnotationDataModel.f34064c = (!map.containsKey("lng") || map.get("lng") == null) ? 0.0d : ((Double) map.get("lng")).doubleValue();
        mapServiceAnnotationDataModel.f34065d = (!map.containsKey("imagePath") || map.get("imagePath") == null) ? str : (String) map.get("imagePath");
        long j = 0;
        mapServiceAnnotationDataModel.f34066e = (!map.containsKey("imagePosition") || map.get("imagePosition") == null) ? 0 : ((Number) map.get("imagePosition")).longValue();
        mapServiceAnnotationDataModel.f34067f = (!map.containsKey("enable") || map.get("enable") == null) ? false : ((Boolean) map.get("enable")).booleanValue();
        mapServiceAnnotationDataModel.f34068g = (!map.containsKey("calloutType") || map.get("calloutType") == null) ? 0 : ((Number) map.get("calloutType")).longValue();
        if (map.containsKey("zIndex") && map.get("zIndex") != null) {
            j = ((Number) map.get("zIndex")).longValue();
        }
        mapServiceAnnotationDataModel.f34069h = j;
        mapServiceAnnotationDataModel.f34070i = (!map.containsKey("anchorU") || map.get("anchorU") == null) ? 0.0d : ((Double) map.get("anchorU")).doubleValue();
        if (map.containsKey("anchorV") && map.get("anchorV") != null) {
            d = ((Double) map.get("anchorV")).doubleValue();
        }
        mapServiceAnnotationDataModel.f34071j = d;
        if (map.containsKey("airBgPath") && map.get("airBgPath") != null) {
            str = (String) map.get("airBgPath");
        }
        mapServiceAnnotationDataModel.f34072k = str;
        mapServiceAnnotationDataModel.f34073l = (!map.containsKey(ImCommons.BUNDLE_MAP) || map.get(ImCommons.BUNDLE_MAP) == null) ? new HashMap<>() : (Map) map.get(ImCommons.BUNDLE_MAP);
        return mapServiceAnnotationDataModel;
    }
}
