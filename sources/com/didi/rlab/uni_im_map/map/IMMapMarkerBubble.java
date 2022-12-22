package com.didi.rlab.uni_im_map.map;

import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.rlab.uni_im_map.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class IMMapMarkerBubble extends UniModel {

    /* renamed from: a */
    private String f34206a;

    /* renamed from: b */
    private double f34207b;

    /* renamed from: c */
    private double f34208c;

    /* renamed from: d */
    private String f34209d;

    /* renamed from: e */
    private String f34210e;

    /* renamed from: f */
    private String f34211f;

    /* renamed from: g */
    private String f34212g;

    /* renamed from: h */
    private String f34213h;

    public String getIcon() {
        return this.f34206a;
    }

    public void setIcon(String str) {
        this.f34206a = str;
    }

    public double getLat() {
        return this.f34207b;
    }

    public void setLat(double d) {
        this.f34207b = d;
    }

    public double getLng() {
        return this.f34208c;
    }

    public void setLng(double d) {
        this.f34208c = d;
    }

    public String getAddress() {
        return this.f34209d;
    }

    public void setAddress(String str) {
        this.f34209d = str;
    }

    public String getDisplayname() {
        return this.f34210e;
    }

    public void setDisplayname(String str) {
        this.f34210e = str;
    }

    public String getCityName() {
        return this.f34211f;
    }

    public void setCityName(String str) {
        this.f34211f = str;
    }

    public String getCityid() {
        return this.f34212g;
    }

    public void setCityid(String str) {
        this.f34212g = str;
    }

    public String getCountry_iso_code() {
        return this.f34213h;
    }

    public void setCountry_iso_code(String str) {
        this.f34213h = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("icon", this.f34206a);
        hashMap.put("lat", Double.valueOf(this.f34207b));
        hashMap.put("lng", Double.valueOf(this.f34208c));
        hashMap.put("address", this.f34209d);
        hashMap.put("displayname", this.f34210e);
        hashMap.put(InvitationPageActivity.CITY_NAME, this.f34211f);
        hashMap.put("cityid", this.f34212g);
        hashMap.put("country_iso_code", this.f34213h);
        return hashMap;
    }

    public static IMMapMarkerBubble fromMap(Map<String, Object> map) {
        IMMapMarkerBubble iMMapMarkerBubble = new IMMapMarkerBubble();
        String str = "";
        iMMapMarkerBubble.f34206a = (!map.containsKey("icon") || map.get("icon") == null) ? str : (String) map.get("icon");
        double d = 0.0d;
        iMMapMarkerBubble.f34207b = (!map.containsKey("lat") || map.get("lat") == null) ? 0.0d : ((Double) map.get("lat")).doubleValue();
        if (map.containsKey("lng") && map.get("lng") != null) {
            d = ((Double) map.get("lng")).doubleValue();
        }
        iMMapMarkerBubble.f34208c = d;
        iMMapMarkerBubble.f34209d = (!map.containsKey("address") || map.get("address") == null) ? str : (String) map.get("address");
        iMMapMarkerBubble.f34210e = (!map.containsKey("displayname") || map.get("displayname") == null) ? str : (String) map.get("displayname");
        iMMapMarkerBubble.f34211f = (!map.containsKey(InvitationPageActivity.CITY_NAME) || map.get(InvitationPageActivity.CITY_NAME) == null) ? str : (String) map.get(InvitationPageActivity.CITY_NAME);
        iMMapMarkerBubble.f34212g = (!map.containsKey("cityid") || map.get("cityid") == null) ? str : (String) map.get("cityid");
        if (map.containsKey("country_iso_code") && map.get("country_iso_code") != null) {
            str = (String) map.get("country_iso_code");
        }
        iMMapMarkerBubble.f34213h = str;
        return iMMapMarkerBubble;
    }
}
