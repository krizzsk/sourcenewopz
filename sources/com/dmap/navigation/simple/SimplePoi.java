package com.dmap.navigation.simple;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.location.INaviLatLng;
import com.dmap.navigation.base.location.INaviPoi;

public class SimplePoi implements INaviPoi {

    /* renamed from: a */
    private LatLng f52044a;

    /* renamed from: b */
    private String f52045b;

    /* renamed from: c */
    private String f52046c;

    /* renamed from: d */
    private String f52047d;

    public SimplePoi(INaviLatLng iNaviLatLng, String str, String str2) {
        this(iNaviLatLng, str, str2, "");
    }

    public SimplePoi(INaviLatLng iNaviLatLng, String str, String str2, String str3) {
        if (iNaviLatLng instanceof LatLng) {
            this.f52044a = (LatLng) iNaviLatLng;
        } else {
            this.f52044a = new LatLng(iNaviLatLng.getLat(), iNaviLatLng.getLng());
        }
        this.f52045b = str;
        this.f52046c = str2;
        this.f52047d = str3;
    }

    public String toString() {
        return "SimplePoi{latLng=" + this.f52044a + ", name='" + this.f52045b + '\'' + ", uid='" + this.f52046c + '\'' + ", chooseFlag='" + this.f52047d + '\'' + '}';
    }

    public LatLng getLatLng() {
        return this.f52044a;
    }

    public String getUid() {
        return this.f52046c;
    }

    public String getName() {
        return this.f52045b;
    }

    public String getChooseFlag() {
        return this.f52047d;
    }
}
