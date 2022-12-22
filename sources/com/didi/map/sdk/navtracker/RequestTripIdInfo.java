package com.didi.map.sdk.navtracker;

import com.didi.map.sdk.proto.driver_gl.OidPidPair;
import java.util.List;

public class RequestTripIdInfo {
    public static final String API_NAME_DYNAMIC_STREET_VIEW = "DynamicStreetView";
    public static final String API_NAME_NAV_SDK = "GoogleNavSDK";
    public static final String API_NAME_STATIC_STREET_VIEW = "StaticStreetView";

    /* renamed from: a */
    private List<OidPidPair> f28549a;

    /* renamed from: b */
    private String f28550b;

    /* renamed from: c */
    private String f28551c;

    /* renamed from: d */
    private String f28552d;

    public @interface Scenes {
        public static final String DYNAMIC_STREET_VIEW = "DynamicStreetView";
        public static final String HOMEPAGE = "GoogleNavSDK_homepage";
        public static final String ONTRIP = "GoogleNavSDK_ontrip";
        public static final String PICKUP = "GoogleNavSDK_pickup";
        public static final String SODA = "GoogleNavSDK_soda";
        public static final String STATIC_STREET_VIEW = "StaticStreetView";
    }

    public RequestTripIdInfo(String str, String str2, List<OidPidPair> list) {
        this(str, str2, list, API_NAME_NAV_SDK);
    }

    public RequestTripIdInfo(String str, String str2, List<OidPidPair> list, String str3) {
        this.f28551c = str;
        this.f28550b = str2;
        this.f28549a = list;
        this.f28552d = str3;
    }

    public String getTicket() {
        return this.f28550b;
    }

    public List<OidPidPair> getOidPidPairList() {
        return this.f28549a;
    }

    public String getScenes() {
        return this.f28551c;
    }

    public String getApiName() {
        return this.f28552d;
    }
}
