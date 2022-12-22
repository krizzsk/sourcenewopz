package com.dmap.navigation.engine.p207a;

import com.dmap.navigation.api.core.INaviPlannerInner;
import com.dmap.navigation.base.route.IRoute;
import com.dmap.navigation.jni.swig.NaviResponse;
import com.dmap.navigation.jni.swig.NaviRouteList;
import com.dmap.navigation.jni.swig.NaviToastInfoList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.dmap.navigation.engine.a.f */
/* compiled from: SimpleNaviResponse */
public final class C17393f implements INaviPlannerInner.INaviResponse {

    /* renamed from: a */
    private final List<IRoute> f51769a;

    /* renamed from: b */
    private final int f51770b;

    /* renamed from: c */
    private final boolean f51771c;

    /* renamed from: d */
    private final byte[] f51772d;

    /* renamed from: e */
    private final byte[] f51773e;

    /* renamed from: f */
    private final Object f51774f;

    /* renamed from: g */
    private final int f51775g;

    public C17393f(Object obj, NaviResponse naviResponse) {
        this.f51774f = obj;
        this.f51770b = naviResponse.getErrorCode();
        this.f51771c = naviResponse.getMandatory();
        this.f51775g = naviResponse.getIsMultiRoute();
        this.f51772d = C17400m.m37040a(naviResponse.getTrafficEvent(), naviResponse.getTrafficEventSize());
        this.f51773e = C17400m.m37040a(naviResponse.getExtendData(), naviResponse.getExtendDataSize());
        NaviToastInfoList toastList = naviResponse.getToastList();
        ArrayList arrayList = new ArrayList((int) toastList.size());
        for (int i = 0; ((long) i) < toastList.size(); i++) {
            arrayList.add(new C17396i(toastList.get(i)));
        }
        NaviRouteList routes = naviResponse.getRoutes();
        int size = (int) routes.size();
        if (size > 0) {
            this.f51769a = new ArrayList(size);
            for (int i2 = 0; ((long) i2) < routes.size(); i2++) {
                this.f51769a.add(new C17394g(this, routes.get(i2), this.f51772d, this.f51773e, arrayList, this.f51771c ? 1 : 0));
            }
            return;
        }
        this.f51769a = null;
    }

    public final String toString() {
        return "SimpleNaviResponse{routeList=" + this.f51769a + ", errorCode=" + this.f51770b + ", mandatory=" + this.f51771c + ", trafficEventData=" + Arrays.toString(this.f51772d) + '}';
    }

    public final int getErrorCode() {
        return this.f51770b;
    }

    public final boolean isMandatory() {
        return this.f51771c;
    }

    public final int getIsMultiRoute() {
        return this.f51775g;
    }

    public final byte[] getTrafficEventData() {
        return this.f51772d;
    }

    public final List<IRoute> getRoutesList() {
        return this.f51769a;
    }
}
