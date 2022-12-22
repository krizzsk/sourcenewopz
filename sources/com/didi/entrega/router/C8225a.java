package com.didi.entrega.router;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.entrega.router.a */
/* compiled from: HubNode */
class C8225a {

    /* renamed from: a */
    private Route f21038a;

    /* renamed from: b */
    private WeakReference<IHubHandler> f21039b;

    /* renamed from: c */
    private List<IInterceptor> f21040c;

    /* renamed from: d */
    private List<C8225a> f21041d = new ArrayList();

    /* renamed from: e */
    private C8225a f21042e;

    C8225a(Route route, IHubHandler iHubHandler) {
        this.f21038a = Route.create(route);
        this.f21039b = new WeakReference<>(iHubHandler);
    }

    /* renamed from: a */
    public C8225a mo62669a(Route route) {
        if (this.f21038a.equals(route)) {
            return this;
        }
        for (C8225a next : this.f21041d) {
            if (route.equals(next.f21038a)) {
                return next;
            }
            if (route.isChild(next.f21038a)) {
                return next.mo62669a(route);
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo62672a(C8225a aVar) {
        if (this.f21038a.equals(aVar.f21038a) || this.f21041d.contains(aVar)) {
            return false;
        }
        if (aVar.f21038a.isDirectChild(this.f21038a)) {
            aVar.f21042e = this;
            return this.f21041d.add(aVar);
        }
        for (int i = 0; i < this.f21041d.size(); i++) {
            if (aVar.f21038a.isChild(this.f21041d.get(i).f21038a)) {
                return this.f21041d.get(i).mo62672a(aVar);
            }
        }
        return false;
    }

    /* renamed from: b */
    public C8225a mo62674b(Route route) {
        C8225a aVar;
        C8225a a = mo62669a(route);
        if (a == null || (aVar = a.f21042e) == null) {
            return null;
        }
        aVar.f21041d.remove(a);
        a.f21042e = null;
        return a;
    }

    /* renamed from: a */
    public List<C8225a> mo62670a() {
        return this.f21041d;
    }

    /* renamed from: b */
    public IHubHandler mo62673b() {
        WeakReference<IHubHandler> weakReference = this.f21039b;
        if (weakReference != null) {
            return (IHubHandler) weakReference.get();
        }
        return null;
    }

    /* renamed from: c */
    public List<IInterceptor> mo62675c() {
        return this.f21040c;
    }

    /* renamed from: a */
    public void mo62671a(List<IInterceptor> list) {
        this.f21040c = list;
    }

    public int hashCode() {
        Route route = this.f21038a;
        return ((route == null ? 0 : route.hashCode()) * 17) + 31;
    }

    public boolean equals(Object obj) {
        Route route;
        if (obj instanceof C8225a) {
            C8225a aVar = (C8225a) obj;
            Route route2 = this.f21038a;
            if (!(route2 == null || (route = aVar.f21038a) == null)) {
                return route2.equals(route);
            }
        }
        return false;
    }

    public String toString() {
        return "HubNode[route:" + this.f21038a + ", hubHandler:" + mo62673b() + ", interceptors:" + this.f21040c + Const.jaRight;
    }
}
