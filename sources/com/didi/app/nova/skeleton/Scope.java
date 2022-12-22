package com.didi.app.nova.skeleton;

import com.didi.app.nova.skeleton.tools.TraceUtil;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public final class Scope {

    /* renamed from: g */
    private static final Object f8254g = new Object();

    /* renamed from: a */
    ServiceRegistry f8255a;

    /* renamed from: b */
    private String f8256b;

    /* renamed from: c */
    private Scope f8257c;

    /* renamed from: d */
    private Map<Class, Object> f8258d = new LinkedHashMap();

    /* renamed from: e */
    private Map<String, Scope> f8259e = new LinkedHashMap();

    /* renamed from: f */
    private boolean f8260f;

    public Scope(String str, Scope scope, ServiceRegistry serviceRegistry, List<Class> list) {
        this.f8256b = str;
        this.f8257c = scope;
        this.f8255a = serviceRegistry;
        if (TraceUtil.ENABLE) {
            TraceUtil.trace("Scope", getName() + " construct ");
        }
        for (Class put : list) {
            this.f8258d.put(put, f8254g);
        }
        if (scope != null) {
            scope.f8259e.put(str, this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40510a(List<Class> list) {
        for (Class next : list) {
            if (!this.f8258d.containsKey(next)) {
                this.f8258d.put(next, f8254g);
            }
        }
    }

    public void destroy() {
        if (TraceUtil.ENABLE) {
            TraceUtil.trace("Scope", getName() + " onDestroy ");
        }
        for (Map.Entry value : new HashSet(this.f8259e.entrySet())) {
            ((Scope) value.getValue()).destroy();
        }
        this.f8260f = true;
        Scope scope = this.f8257c;
        if (scope != null) {
            scope.f8259e.remove(getName());
        }
        for (Map.Entry next : this.f8258d.entrySet()) {
            if (!(next == null || next == f8254g)) {
                this.f8255a.releaseService(next.getValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo40511a() {
        return this.f8260f;
    }

    public <T> T findService(Class cls) {
        return m5423a(this, cls);
    }

    /* renamed from: a */
    private <T> T m5423a(Scope scope, Class cls) {
        Scope scope2;
        T t = scope.f8258d.get(cls);
        if (t == f8254g) {
            T allocService = this.f8255a.allocService(cls);
            scope.f8258d.put(cls, allocService);
            return allocService;
        } else if (t == null && (scope2 = scope.f8257c) != null) {
            return m5423a(scope2, cls);
        } else {
            if (t != null) {
                return t;
            }
            throw new IllegalArgumentException("Service of " + cls.getName() + "  not declarat with annotation in scope");
        }
    }

    public String getName() {
        return this.f8256b;
    }

    public Scope getParent() {
        return this.f8257c;
    }

    public Scope findChild(String str) {
        return this.f8259e.get(str);
    }
}
