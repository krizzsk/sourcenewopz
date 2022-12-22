package com.dmap.navigation.engine.simple;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.jni.swig.NaviLocation;
import com.dmap.navigation.simple.SimpleLatlng;
import java.math.BigInteger;

public class SimpleLocation implements INaviLocation {

    /* renamed from: a */
    private final LatLng f51996a;

    /* renamed from: b */
    private final float f51997b;

    /* renamed from: c */
    private final float f51998c;

    /* renamed from: d */
    private final float f51999d;

    /* renamed from: e */
    private final float f52000e;

    /* renamed from: f */
    private final float f52001f;

    /* renamed from: g */
    private final int f52002g;

    /* renamed from: h */
    private final INaviLocation.NaviSource f52003h;

    /* renamed from: i */
    private final int f52004i;

    /* renamed from: j */
    private final int f52005j;

    /* renamed from: k */
    private final String f52006k;

    /* renamed from: l */
    private final int f52007l;

    /* renamed from: m */
    private final BigInteger f52008m;

    /* renamed from: n */
    private final BigInteger f52009n;

    /* renamed from: o */
    private final String f52010o;

    /* renamed from: p */
    private final String f52011p;

    public void setNaviSource(INaviLocation.NaviSource naviSource) {
    }

    public SimpleLocation(NaviLocation naviLocation) {
        this.f51996a = new SimpleLatlng(naviLocation.getLatLng().getLat(), naviLocation.getLatLng().getLng());
        this.f51997b = naviLocation.getAngle();
        this.f51998c = naviLocation.getAccuracy();
        this.f51999d = naviLocation.getVelocity();
        this.f52000e = naviLocation.getFlpBearing();
        this.f52001f = naviLocation.getFlpConfidence();
        this.f52002g = naviLocation.getFlpStatus();
        int naviSource = naviLocation.getNaviSource();
        if (INaviLocation.NaviSource.ORIGINAL.getValue() == naviSource) {
            this.f52003h = INaviLocation.NaviSource.ORIGINAL;
        } else if (INaviLocation.NaviSource.VIRTUAL.getValue() == naviSource) {
            this.f52003h = INaviLocation.NaviSource.VIRTUAL;
        } else if (INaviLocation.NaviSource.VIRTUAL_WEAK.getValue() == naviSource) {
            this.f52003h = INaviLocation.NaviSource.VIRTUAL_WEAK;
        } else {
            this.f52003h = INaviLocation.NaviSource.UNKNOWN;
        }
        this.f52004i = naviLocation.getGpsProvider();
        this.f52005j = naviLocation.getVdrConf();
        this.f52006k = naviLocation.getFlpExt();
        this.f52007l = naviLocation.getSatellitesNum();
        this.f52008m = naviLocation.getGpsTime();
        this.f52009n = naviLocation.getPhoneTime();
        this.f52010o = naviLocation.getGpsSource();
        this.f52011p = "gps";
    }

    public SimpleLocation(LatLng latLng) {
        this.f51996a = latLng;
        this.f51997b = 0.0f;
        this.f51998c = 0.0f;
        this.f51999d = 0.0f;
        this.f52000e = 0.0f;
        this.f52001f = 0.0f;
        this.f52002g = 0;
        this.f52003h = INaviLocation.NaviSource.VIRTUAL;
        this.f52004i = -1;
        this.f52005j = 0;
        this.f52006k = "";
        this.f52007l = 0;
        this.f52008m = BigInteger.valueOf(System.currentTimeMillis());
        this.f52009n = BigInteger.valueOf(System.currentTimeMillis());
        this.f52010o = "gps";
        this.f52011p = "gps";
    }

    public String toString() {
        return "SimpleLocation{latLng=" + this.f51996a + ", angle=" + this.f51997b + ", accuracy=" + this.f51998c + ", velocity=" + this.f51999d + ", flpBearing=" + this.f52000e + ", flpConfidence=" + this.f52001f + ", flpStatus=" + this.f52002g + ", naviSource=" + this.f52003h + ", gpsProvider=" + this.f52004i + ", vdrConf=" + this.f52005j + ", flpExt='" + this.f52006k + '\'' + ", satellitesNum=" + this.f52007l + ", gpsTime=" + this.f52008m + ", phoneTime=" + this.f52009n + ", gpsSource='" + this.f52010o + '\'' + '}';
    }

    public LatLng getLatLng() {
        return this.f51996a;
    }

    public float getAngle() {
        return this.f51997b;
    }

    public float getAccuracy() {
        return this.f51998c;
    }

    public float getVelocity() {
        return this.f51999d;
    }

    public float getFlpBearing() {
        return this.f52000e;
    }

    public float getFlpConfidence() {
        return this.f52001f;
    }

    public int getFlpStatus() {
        return this.f52002g;
    }

    public INaviLocation.NaviSource getNaviSource() {
        return this.f52003h;
    }

    public int getGpsProvider() {
        return this.f52004i;
    }

    public int getVdrConf() {
        return this.f52005j;
    }

    public String getFlpExt() {
        return this.f52006k;
    }

    public int getSatellitesNum() {
        return this.f52007l;
    }

    public long getGpsTime() {
        return this.f52008m.longValue();
    }

    public long getPhoneTime() {
        return this.f52009n.longValue();
    }

    public String getGpsSource() {
        return this.f52010o;
    }

    public String getProvider() {
        return this.f52011p;
    }
}
