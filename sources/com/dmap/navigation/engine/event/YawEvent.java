package com.dmap.navigation.engine.event;

import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.engine.simple.SimpleLocation;
import com.dmap.navigation.jni.swig.BindNaviLocation;
import com.dmap.navigation.jni.swig.NaviLocation;

public class YawEvent extends NaviEvent {

    /* renamed from: a */
    private final INaviLocation f51992a;

    /* renamed from: b */
    private final int f51993b;

    /* renamed from: c */
    private final int f51994c;

    /* renamed from: d */
    private final int f51995d;

    public YawEvent(BindNaviLocation bindNaviLocation, int i, int i2, int i3) {
        this.f51992a = new SimpleLocation((NaviLocation) bindNaviLocation);
        this.f51993b = i;
        this.f51994c = i2;
        this.f51995d = i3;
    }

    public String toString() {
        return "YawEvent{bindLocation=" + this.f51992a + ", bindIndex=" + this.f51993b + ", toastBehavior=" + this.f51994c + ", mainSideYaw=" + this.f51995d + '}';
    }

    public INaviLocation getBindLocation() {
        return this.f51992a;
    }

    public int getBindIndex() {
        return this.f51993b;
    }

    public int getToastBehavior() {
        return this.f51994c;
    }

    public int getMainSideYaw() {
        return this.f51995d;
    }
}
