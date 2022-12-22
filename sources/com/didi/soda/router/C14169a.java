package com.didi.soda.router;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.soda.router.a */
/* compiled from: HubNode */
class C14169a {

    /* renamed from: a */
    private Route f43671a;

    /* renamed from: b */
    private WeakReference<IHubHandler> f43672b;

    /* renamed from: c */
    private List<IInterceptor> f43673c;

    /* renamed from: d */
    private List<C14169a> f43674d = new ArrayList();

    /* renamed from: e */
    private C14169a f43675e;

    C14169a(Route route, IHubHandler iHubHandler) {
        this.f43671a = Route.create(route);
        this.f43672b = new WeakReference<>(iHubHandler);
    }

    /* renamed from: a */
    public C14169a mo108780a(Route route) {
        if (this.f43671a.equals(route)) {
            return this;
        }
        for (C14169a next : this.f43674d) {
            if (route.equals(next.f43671a)) {
                return next;
            }
            if (route.isChild(next.f43671a)) {
                return next.mo108780a(route);
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo108783a(C14169a aVar) {
        if (this.f43671a.equals(aVar.f43671a) || this.f43674d.contains(aVar)) {
            return false;
        }
        if (aVar.f43671a.isDirectChild(this.f43671a)) {
            aVar.f43675e = this;
            return this.f43674d.add(aVar);
        }
        for (int i = 0; i < this.f43674d.size(); i++) {
            if (aVar.f43671a.isChild(this.f43674d.get(i).f43671a)) {
                return this.f43674d.get(i).mo108783a(aVar);
            }
        }
        return false;
    }

    /* renamed from: b */
    public C14169a mo108785b(Route route) {
        C14169a aVar;
        C14169a a = mo108780a(route);
        if (a == null || (aVar = a.f43675e) == null) {
            return null;
        }
        aVar.f43674d.remove(a);
        a.f43675e = null;
        return a;
    }

    /* renamed from: a */
    public List<C14169a> mo108781a() {
        return this.f43674d;
    }

    /* renamed from: b */
    public IHubHandler mo108784b() {
        WeakReference<IHubHandler> weakReference = this.f43672b;
        if (weakReference != null) {
            return (IHubHandler) weakReference.get();
        }
        return null;
    }

    /* renamed from: c */
    public List<IInterceptor> mo108786c() {
        return this.f43673c;
    }

    /* renamed from: a */
    public void mo108782a(List<IInterceptor> list) {
        this.f43673c = list;
    }

    public int hashCode() {
        Route route = this.f43671a;
        return ((route == null ? 0 : route.hashCode()) * 17) + 31;
    }

    public boolean equals(Object obj) {
        Route route;
        if (obj instanceof C14169a) {
            C14169a aVar = (C14169a) obj;
            Route route2 = this.f43671a;
            if (!(route2 == null || (route = aVar.f43671a) == null)) {
                return route2.equals(route);
            }
        }
        return false;
    }

    public String toString() {
        return "HubNode[route:" + this.f43671a + ", hubHandler:" + mo108784b() + ", interceptors:" + this.f43673c + Const.jaRight;
    }
}
