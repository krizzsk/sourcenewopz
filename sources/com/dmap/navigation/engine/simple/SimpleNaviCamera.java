package com.dmap.navigation.engine.simple;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.engine.core.camera.INaviCamera;
import com.dmap.navigation.jni.swig.NaviCamera;
import com.dmap.navigation.simple.SimpleLatlng;

public class SimpleNaviCamera implements INaviCamera {

    /* renamed from: a */
    private final int f52015a;

    /* renamed from: b */
    private final int f52016b;

    /* renamed from: c */
    private final LatLng f52017c;

    /* renamed from: d */
    private final int f52018d;

    /* renamed from: e */
    private final int f52019e;

    /* renamed from: f */
    private final int f52020f;

    /* renamed from: g */
    private final String f52021g;

    public SimpleNaviCamera(NaviCamera naviCamera) {
        this.f52015a = naviCamera.getType();
        this.f52016b = naviCamera.getSpeed();
        this.f52017c = new SimpleLatlng(naviCamera.getLatLng().getLat(), naviCamera.getLatLng().getLng());
        this.f52018d = naviCamera.getWeight();
        this.f52019e = naviCamera.getGroupId();
        this.f52020f = naviCamera.getBubbleType();
        this.f52021g = null;
    }

    public SimpleNaviCamera(int i, int i2, LatLng latLng, String str) {
        this.f52015a = i;
        this.f52016b = i2;
        this.f52017c = latLng;
        this.f52021g = str;
        this.f52018d = 0;
        this.f52019e = 0;
        this.f52020f = 0;
    }

    public String toString() {
        return "SimpleNaviCamera{type=" + this.f52015a + ", speed=" + this.f52016b + ", latLng=" + this.f52017c + ", weight=" + this.f52018d + ", groupId=" + this.f52019e + ", bubbleType=" + this.f52020f + ", describe='" + this.f52021g + '\'' + '}';
    }

    public int getType() {
        return this.f52015a;
    }

    public int getSpeed() {
        return this.f52016b;
    }

    public LatLng getLatLng() {
        return this.f52017c;
    }

    public int getWeight() {
        return this.f52018d;
    }

    public int getGroupId() {
        return this.f52019e;
    }

    public int getBubbleType() {
        return this.f52020f;
    }

    public String getDescribe() {
        return this.f52021g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof INaviCamera)) {
            return false;
        }
        INaviCamera iNaviCamera = (INaviCamera) obj;
        return this.f52017c != null && iNaviCamera.getLatLng() != null && this.f52015a == iNaviCamera.getType() && this.f52016b == iNaviCamera.getSpeed() && this.f52018d == iNaviCamera.getWeight() && this.f52017c.equals(iNaviCamera.getLatLng());
    }
}
