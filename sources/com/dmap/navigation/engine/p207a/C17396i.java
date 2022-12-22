package com.dmap.navigation.engine.p207a;

import com.dmap.navigation.base.route.IToastInfo;
import com.dmap.navigation.jni.swig.NaviToastInfo;

/* renamed from: com.dmap.navigation.engine.a.i */
/* compiled from: SimpleToastInfo */
public final class C17396i implements IToastInfo {

    /* renamed from: a */
    private final int f51810a;

    /* renamed from: b */
    private final String f51811b;

    public C17396i(NaviToastInfo naviToastInfo) {
        this.f51810a = naviToastInfo.getType();
        this.f51811b = naviToastInfo.getContent();
    }

    public final String toString() {
        return "SimpleToastInfo{type=" + this.f51810a + ", content='" + this.f51811b + '\'' + '}';
    }

    public final int getType() {
        return this.f51810a;
    }

    public final String getContent() {
        return this.f51811b;
    }
}
