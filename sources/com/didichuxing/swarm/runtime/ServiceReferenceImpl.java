package com.didichuxing.swarm.runtime;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class ServiceReferenceImpl<S> implements ServiceReference<S> {

    /* renamed from: a */
    private static final AtomicLong f49217a = new AtomicLong();

    /* renamed from: b */
    private final C16506b f49218b;

    /* renamed from: c */
    private final AbstractBundle f49219c;

    /* renamed from: d */
    private final Map<String, Object> f49220d = new HashMap(2);

    /* renamed from: e */
    private final ServiceRegistration<S> f49221e;

    /* renamed from: f */
    private final S f49222f;

    public int compareTo(Object obj) {
        return 0;
    }

    public Bundle[] getUsingBundles() {
        return new Bundle[0];
    }

    public boolean isAssignableTo(Bundle bundle, String str) {
        return false;
    }

    public ServiceReferenceImpl(C16506b bVar, AbstractBundle abstractBundle, S s, Dictionary<String, ?> dictionary, String[] strArr) {
        int i;
        Integer num = null;
        this.f49221e = new ServiceRegistrationImpl();
        this.f49218b = bVar;
        this.f49219c = abstractBundle;
        this.f49222f = s;
        if (dictionary != null) {
            Enumeration<String> keys = dictionary.keys();
            while (keys.hasMoreElements()) {
                String nextElement = keys.nextElement();
                this.f49220d.put(nextElement, dictionary.get(nextElement));
            }
        }
        num = dictionary != null ? (Integer) dictionary.get(Constants.SERVICE_RANKING) : num;
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        this.f49220d.put(Constants.OBJECTCLASS, strArr);
        this.f49220d.put(Constants.SERVICE_ID, Long.valueOf(f49217a.incrementAndGet()));
        this.f49220d.put(Constants.SERVICE_RANKING, Integer.valueOf(i));
    }

    public Object getProperty(String str) {
        return this.f49220d.get(str);
    }

    public String[] getPropertyKeys() {
        return (String[]) this.f49220d.keySet().toArray(new String[this.f49220d.size()]);
    }

    public Bundle getBundle() {
        return this.f49219c;
    }

    public C16506b getFramework() {
        return this.f49218b;
    }

    public S getService() {
        return this.f49222f;
    }

    public ServiceRegistration<?> getServiceRegistration() {
        return this.f49221e;
    }

    private final class ServiceRegistrationImpl implements ServiceRegistration<S> {
        public void setProperties(Dictionary<String, ?> dictionary) {
        }

        public void unregister() {
        }

        private ServiceRegistrationImpl() {
        }

        public ServiceReference<S> getReference() {
            return ServiceReferenceImpl.this;
        }
    }
}
