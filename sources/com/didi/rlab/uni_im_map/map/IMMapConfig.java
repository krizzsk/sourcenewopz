package com.didi.rlab.uni_im_map.map;

import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.rlab.uni_im_map.uniapi.UniModel;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.rider.rlab_im_map_plugin.tool.ImCommons;
import java.util.HashMap;
import java.util.Map;

public class IMMapConfig extends UniModel {

    /* renamed from: a */
    private String f34176a;

    /* renamed from: b */
    private long f34177b;

    /* renamed from: c */
    private long f34178c;

    /* renamed from: d */
    private long f34179d;

    /* renamed from: e */
    private boolean f34180e;

    /* renamed from: f */
    private boolean f34181f;

    /* renamed from: g */
    private String f34182g;

    /* renamed from: h */
    private String f34183h;

    /* renamed from: i */
    private String f34184i;

    /* renamed from: j */
    private String f34185j;

    /* renamed from: k */
    private String f34186k;

    /* renamed from: l */
    private String f34187l;

    /* renamed from: m */
    private double f34188m;

    /* renamed from: n */
    private double f34189n;

    /* renamed from: o */
    private String f34190o;

    /* renamed from: p */
    private String f34191p;

    /* renamed from: q */
    private String f34192q;

    /* renamed from: r */
    private long f34193r;

    /* renamed from: s */
    private String f34194s;

    /* renamed from: t */
    private String f34195t;

    /* renamed from: u */
    private String f34196u;

    /* renamed from: v */
    private Map<String, Object> f34197v;

    /* renamed from: w */
    private String f34198w;

    public String getMapKey() {
        return this.f34176a;
    }

    public void setMapKey(String str) {
        this.f34176a = str;
    }

    public long getCallFrom() {
        return this.f34177b;
    }

    public void setCallFrom(long j) {
        this.f34177b = j;
    }

    public long getPageType() {
        return this.f34178c;
    }

    public void setPageType(long j) {
        this.f34178c = j;
    }

    public long getZoomLevel() {
        return this.f34179d;
    }

    public void setZoomLevel(long j) {
        this.f34179d = j;
    }

    public boolean getDowngradeMap() {
        return this.f34180e;
    }

    public void setDowngradeMap(boolean z) {
        this.f34180e = z;
    }

    public boolean getDowngradeMapNavigation() {
        return this.f34181f;
    }

    public void setDowngradeMapNavigation(boolean z) {
        this.f34181f = z;
    }

    public String getMapStyle() {
        return this.f34182g;
    }

    public void setMapStyle(String str) {
        this.f34182g = str;
    }

    public String getTicket() {
        return this.f34183h;
    }

    public void setTicket(String str) {
        this.f34183h = str;
    }

    public String getOrderId() {
        return this.f34184i;
    }

    public void setOrderId(String str) {
        this.f34184i = str;
    }

    public String getPassengerid() {
        return this.f34185j;
    }

    public void setPassengerid(String str) {
        this.f34185j = str;
    }

    public String getAddress() {
        return this.f34186k;
    }

    public void setAddress(String str) {
        this.f34186k = str;
    }

    public String getDisplayname() {
        return this.f34187l;
    }

    public void setDisplayname(String str) {
        this.f34187l = str;
    }

    public double getLat() {
        return this.f34188m;
    }

    public void setLat(double d) {
        this.f34188m = d;
    }

    public double getLng() {
        return this.f34189n;
    }

    public void setLng(double d) {
        this.f34189n = d;
    }

    public String getCityName() {
        return this.f34190o;
    }

    public void setCityName(String str) {
        this.f34190o = str;
    }

    public String getCityid() {
        return this.f34191p;
    }

    public void setCityid(String str) {
        this.f34191p = str;
    }

    public String getCountry_iso_code() {
        return this.f34192q;
    }

    public void setCountry_iso_code(String str) {
        this.f34192q = str;
    }

    public long getTravelMode() {
        return this.f34193r;
    }

    public void setTravelMode(long j) {
        this.f34193r = j;
    }

    public String getSettingTypeKey() {
        return this.f34194s;
    }

    public void setSettingTypeKey(String str) {
        this.f34194s = str;
    }

    public String getProductID() {
        return this.f34195t;
    }

    public void setProductID(String str) {
        this.f34195t = str;
    }

    public String getToken() {
        return this.f34196u;
    }

    public void setToken(String str) {
        this.f34196u = str;
    }

    public Map<String, Object> getExtParams() {
        return this.f34197v;
    }

    public void setExtParams(Map<String, Object> map) {
        this.f34197v = map;
    }

    public String getFavor() {
        return this.f34198w;
    }

    public void setFavor(String str) {
        this.f34198w = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("mapKey", this.f34176a);
        hashMap.put(ImCommons.BUNDLE_CALL_FROM, Long.valueOf(this.f34177b));
        hashMap.put(ImCommons.BUNDLE_TYPE, Long.valueOf(this.f34178c));
        hashMap.put("zoomLevel", Long.valueOf(this.f34179d));
        hashMap.put(ImCommons.BUNDLE_DOWNGRADE_MAP, Boolean.valueOf(this.f34180e));
        hashMap.put("downgradeMapNavigation", Boolean.valueOf(this.f34181f));
        hashMap.put("mapStyle", this.f34182g);
        hashMap.put("ticket", this.f34183h);
        hashMap.put("orderId", this.f34184i);
        hashMap.put(ParamKeys.PARAM_PASSENGER_ID, this.f34185j);
        hashMap.put("address", this.f34186k);
        hashMap.put("displayname", this.f34187l);
        hashMap.put("lat", Double.valueOf(this.f34188m));
        hashMap.put("lng", Double.valueOf(this.f34189n));
        hashMap.put(InvitationPageActivity.CITY_NAME, this.f34190o);
        hashMap.put("cityid", this.f34191p);
        hashMap.put("country_iso_code", this.f34192q);
        hashMap.put(ImCommons.BUNDLE_NAV_TYPE, Long.valueOf(this.f34193r));
        hashMap.put("settingTypeKey", this.f34194s);
        hashMap.put(SDKConstants.PARAM_PRODUCT_ID, this.f34195t);
        hashMap.put("token", this.f34196u);
        hashMap.put(ImCommons.BUNDLE_MAP, this.f34197v);
        hashMap.put(ImCommons.BUNDLE_FAVOR, this.f34198w);
        return hashMap;
    }

    public static IMMapConfig fromMap(Map<String, Object> map) {
        IMMapConfig iMMapConfig = new IMMapConfig();
        String str = "";
        iMMapConfig.f34176a = (!map.containsKey("mapKey") || map.get("mapKey") == null) ? str : (String) map.get("mapKey");
        long j = 0;
        iMMapConfig.f34177b = (!map.containsKey(ImCommons.BUNDLE_CALL_FROM) || map.get(ImCommons.BUNDLE_CALL_FROM) == null) ? 0 : ((Number) map.get(ImCommons.BUNDLE_CALL_FROM)).longValue();
        iMMapConfig.f34178c = (!map.containsKey(ImCommons.BUNDLE_TYPE) || map.get(ImCommons.BUNDLE_TYPE) == null) ? 0 : ((Number) map.get(ImCommons.BUNDLE_TYPE)).longValue();
        iMMapConfig.f34179d = (!map.containsKey("zoomLevel") || map.get("zoomLevel") == null) ? 0 : ((Number) map.get("zoomLevel")).longValue();
        iMMapConfig.f34180e = (!map.containsKey(ImCommons.BUNDLE_DOWNGRADE_MAP) || map.get(ImCommons.BUNDLE_DOWNGRADE_MAP) == null) ? false : ((Boolean) map.get(ImCommons.BUNDLE_DOWNGRADE_MAP)).booleanValue();
        iMMapConfig.f34181f = (!map.containsKey("downgradeMapNavigation") || map.get("downgradeMapNavigation") == null) ? false : ((Boolean) map.get("downgradeMapNavigation")).booleanValue();
        iMMapConfig.f34182g = (!map.containsKey("mapStyle") || map.get("mapStyle") == null) ? str : (String) map.get("mapStyle");
        iMMapConfig.f34183h = (!map.containsKey("ticket") || map.get("ticket") == null) ? str : (String) map.get("ticket");
        iMMapConfig.f34184i = (!map.containsKey("orderId") || map.get("orderId") == null) ? str : (String) map.get("orderId");
        iMMapConfig.f34185j = (!map.containsKey(ParamKeys.PARAM_PASSENGER_ID) || map.get(ParamKeys.PARAM_PASSENGER_ID) == null) ? str : (String) map.get(ParamKeys.PARAM_PASSENGER_ID);
        iMMapConfig.f34186k = (!map.containsKey("address") || map.get("address") == null) ? str : (String) map.get("address");
        iMMapConfig.f34187l = (!map.containsKey("displayname") || map.get("displayname") == null) ? str : (String) map.get("displayname");
        iMMapConfig.f34188m = (!map.containsKey("lat") || map.get("lat") == null) ? 0.0d : ((Double) map.get("lat")).doubleValue();
        iMMapConfig.f34189n = (!map.containsKey("lng") || map.get("lng") == null) ? 0.0d : ((Double) map.get("lng")).doubleValue();
        iMMapConfig.f34190o = (!map.containsKey(InvitationPageActivity.CITY_NAME) || map.get(InvitationPageActivity.CITY_NAME) == null) ? str : (String) map.get(InvitationPageActivity.CITY_NAME);
        iMMapConfig.f34191p = (!map.containsKey("cityid") || map.get("cityid") == null) ? str : (String) map.get("cityid");
        iMMapConfig.f34192q = (!map.containsKey("country_iso_code") || map.get("country_iso_code") == null) ? str : (String) map.get("country_iso_code");
        if (map.containsKey(ImCommons.BUNDLE_NAV_TYPE) && map.get(ImCommons.BUNDLE_NAV_TYPE) != null) {
            j = ((Number) map.get(ImCommons.BUNDLE_NAV_TYPE)).longValue();
        }
        iMMapConfig.f34193r = j;
        iMMapConfig.f34194s = (!map.containsKey("settingTypeKey") || map.get("settingTypeKey") == null) ? str : (String) map.get("settingTypeKey");
        iMMapConfig.f34195t = (!map.containsKey(SDKConstants.PARAM_PRODUCT_ID) || map.get(SDKConstants.PARAM_PRODUCT_ID) == null) ? str : (String) map.get(SDKConstants.PARAM_PRODUCT_ID);
        iMMapConfig.f34196u = (!map.containsKey("token") || map.get("token") == null) ? str : (String) map.get("token");
        iMMapConfig.f34197v = (!map.containsKey(ImCommons.BUNDLE_MAP) || map.get(ImCommons.BUNDLE_MAP) == null) ? new HashMap<>() : (Map) map.get(ImCommons.BUNDLE_MAP);
        if (map.containsKey(ImCommons.BUNDLE_FAVOR) && map.get(ImCommons.BUNDLE_FAVOR) != null) {
            str = (String) map.get(ImCommons.BUNDLE_FAVOR);
        }
        iMMapConfig.f34198w = str;
        return iMMapConfig;
    }
}
