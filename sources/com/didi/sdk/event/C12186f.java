package com.didi.sdk.event;

import java.lang.reflect.Method;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.sdk.event.f */
/* compiled from: SubscriberMethod */
final class C12186f {

    /* renamed from: a */
    final Method f35870a;

    /* renamed from: b */
    final ThreadMode f35871b;

    /* renamed from: c */
    final Class<?> f35872c;

    /* renamed from: d */
    String f35873d;

    C12186f(Method method, ThreadMode threadMode, Class<?> cls) {
        this.f35870a = method;
        this.f35871b = threadMode;
        this.f35872c = cls;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C12186f)) {
            return false;
        }
        m25409a();
        C12186f fVar = (C12186f) obj;
        fVar.m25409a();
        return this.f35873d.equals(fVar.f35873d);
    }

    /* renamed from: a */
    private synchronized void m25409a() {
        if (this.f35873d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f35870a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f35870a.getName());
            sb.append(VersionRange.LEFT_OPEN);
            sb.append(this.f35872c.getName());
            this.f35873d = sb.toString();
        }
    }

    public int hashCode() {
        return this.f35870a.hashCode();
    }
}
