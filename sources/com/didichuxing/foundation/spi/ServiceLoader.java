package com.didichuxing.foundation.spi;

import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceConfigurationError;
import java.util.Set;

public final class ServiceLoader<S> implements Iterable<S> {

    /* renamed from: a */
    private final Class<S> f47640a;

    /* renamed from: b */
    private final String f47641b;

    /* renamed from: c */
    private final Set<S> f47642c;

    public static final <S> ServiceLoader<S> load(Class<S> cls) {
        return new ServiceLoader<>(cls);
    }

    public static final <S> ServiceLoader<S> load(Class<S> cls, String str) {
        return new ServiceLoader<>(cls, str);
    }

    private ServiceLoader(Class<S> cls) {
        this(cls, (String) null);
    }

    public ServiceLoader(Class<S> cls, String str) {
        this.f47642c = new LinkedHashSet();
        this.f47640a = cls;
        this.f47641b = str;
        m34102a();
    }

    public S get() {
        Iterator<S> it = this.f47642c.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public Iterator<S> iterator() {
        return Collections.unmodifiableSet(this.f47642c).iterator();
    }

    /* renamed from: a */
    private void m34102a() {
        for (Class cls : m34103b()) {
            try {
                this.f47642c.add(ServiceRegistry.m34104a(cls));
            } catch (Throwable th) {
                throw new ServiceConfigurationError("Provider " + cls.getName() + " could not be initialized", th);
            }
        }
    }

    /* renamed from: b */
    private Set<Class<? extends S>> m34103b() {
        Set<Class<? extends S>> set = ServiceRegistry.get(this.f47640a);
        if (this.f47641b == null) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Class next : set) {
            ServiceProvider serviceProvider = (ServiceProvider) next.getAnnotation(ServiceProvider.class);
            if (serviceProvider != null && this.f47641b.equals(serviceProvider.alias())) {
                linkedHashSet.add(next);
            }
        }
        return linkedHashSet;
    }
}
