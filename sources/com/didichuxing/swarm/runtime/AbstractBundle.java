package com.didichuxing.swarm.runtime;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceObjects;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

abstract class AbstractBundle implements Bundle {

    /* renamed from: a */
    protected final C16506b f49204a;

    /* renamed from: b */
    protected final BundleContext f49205b;

    /* renamed from: c */
    protected final Dictionary<String, String> f49206c;

    /* renamed from: d */
    protected final List<ServiceReference<?>> f49207d;

    /* renamed from: e */
    protected final ClassLoader f49208e;

    /* renamed from: f */
    protected final long f49209f;

    /* renamed from: g */
    protected final String f49210g;

    /* renamed from: h */
    protected long f49211h;

    /* renamed from: i */
    protected int f49212i;

    /* renamed from: a */
    public int compareTo(Bundle bundle) {
        return 0;
    }

    public Enumeration<URL> findEntries(String str, String str2, boolean z) {
        return null;
    }

    public File getDataFile(String str) {
        return null;
    }

    public URL getEntry(String str) {
        return null;
    }

    public Enumeration<String> getEntryPaths(String str) {
        return null;
    }

    public ServiceReference<?>[] getServicesInUse() {
        return new ServiceReference[0];
    }

    public Map<X509Certificate, List<X509Certificate>> getSignerCertificates(int i) {
        return null;
    }

    public boolean hasPermission(Object obj) {
        return true;
    }

    AbstractBundle() {
        this.f49205b = new BundleContextImpl();
        this.f49206c = new Hashtable();
        this.f49207d = new ArrayList();
        this.f49208e = getClass().getClassLoader();
        this.f49212i = 0;
        this.f49204a = (C16506b) this;
        this.f49209f = 0;
        this.f49210g = Constants.SYSTEM_BUNDLE_LOCATION;
        this.f49211h = System.currentTimeMillis();
    }

    protected AbstractBundle(C16506b bVar, long j, String str) {
        this.f49205b = new BundleContextImpl();
        this.f49206c = new Hashtable();
        this.f49207d = new ArrayList();
        this.f49208e = getClass().getClassLoader();
        this.f49212i = 0;
        this.f49204a = bVar;
        this.f49209f = j;
        this.f49210g = str;
        this.f49211h = System.currentTimeMillis();
    }

    public int getState() {
        return this.f49212i;
    }

    public Dictionary<String, String> getHeaders() {
        return this.f49206c;
    }

    public long getBundleId() {
        return this.f49209f;
    }

    public String getLocation() {
        return this.f49210g;
    }

    public ServiceReference<?>[] getRegisteredServices() {
        List<ServiceReference<?>> list = this.f49207d;
        return (ServiceReference[]) list.toArray(new ServiceReference[list.size()]);
    }

    public URL getResource(String str) {
        return this.f49208e.getResource(str);
    }

    public Dictionary<String, String> getHeaders(String str) {
        return getHeaders();
    }

    public Class<?> loadClass(String str) throws ClassNotFoundException {
        return this.f49208e.loadClass(str);
    }

    public Enumeration<URL> getResources(String str) throws IOException {
        return this.f49208e.getResources(str);
    }

    public long getLastModified() {
        return this.f49211h;
    }

    public BundleContext getBundleContext() {
        return this.f49205b;
    }

    public <A> A adapt(Class<A> cls) {
        if (cls.isInstance(this)) {
            return this;
        }
        if (BundleContext.class == cls) {
            return this.f49205b;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle-Id: ");
        sb.append(getBundleId());
        sb.append("\n");
        sb.append("Bundle-Location: ");
        sb.append(getLocation());
        sb.append("\n");
        sb.append("Bundle-SymbolicName: ");
        sb.append(getSymbolicName());
        sb.append("\n");
        sb.append("Bundle-Version: ");
        sb.append(getVersion());
        sb.append("\n");
        Enumeration<String> keys = this.f49206c.keys();
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"Bundle-Id", "Bundle-Location", Constants.BUNDLE_SYMBOLICNAME, Constants.BUNDLE_VERSION}));
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            if (!hashSet.contains(nextElement)) {
                sb.append(nextElement);
                sb.append(": ");
                sb.append(this.f49206c.get(nextElement));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private final class BundleContextImpl implements BundleContext {
        public void addBundleListener(BundleListener bundleListener) {
        }

        public void addFrameworkListener(FrameworkListener frameworkListener) {
        }

        public void addServiceListener(ServiceListener serviceListener) {
        }

        public void addServiceListener(ServiceListener serviceListener, String str) throws InvalidSyntaxException {
        }

        public File getDataFile(String str) {
            return null;
        }

        public <S> ServiceObjects<S> getServiceObjects(ServiceReference<S> serviceReference) {
            return null;
        }

        public <S> ServiceRegistration<S> registerService(Class<S> cls, ServiceFactory<S> serviceFactory, Dictionary<String, ?> dictionary) {
            return null;
        }

        public void removeBundleListener(BundleListener bundleListener) {
        }

        public void removeFrameworkListener(FrameworkListener frameworkListener) {
        }

        public void removeServiceListener(ServiceListener serviceListener) {
        }

        public boolean ungetService(ServiceReference<?> serviceReference) {
            return false;
        }

        private BundleContextImpl() {
        }

        public String getProperty(String str) {
            return AbstractBundle.this.f49204a.f49232n.getProperty(str);
        }

        public Bundle getBundle() {
            return AbstractBundle.this;
        }

        public Bundle installBundle(String str, InputStream inputStream) throws BundleException {
            return AbstractBundle.this.f49204a.mo121279a((BundleContext) this, str, inputStream);
        }

        public Bundle installBundle(String str) throws BundleException {
            return AbstractBundle.this.f49204a.mo121278a(this, str);
        }

        public Bundle getBundle(long j) {
            return AbstractBundle.this.f49204a.mo121276a(j);
        }

        public Bundle[] getBundles() {
            return AbstractBundle.this.f49204a.mo121283b();
        }

        public ServiceRegistration<?> registerService(String[] strArr, Object obj, Dictionary<String, ?> dictionary) {
            ServiceReferenceImpl serviceReferenceImpl = new ServiceReferenceImpl(AbstractBundle.this.f49204a, AbstractBundle.this, obj, dictionary, strArr);
            AbstractBundle.this.f49207d.add(serviceReferenceImpl);
            for (String a : strArr) {
                AbstractBundle.this.f49204a.f49231m.mo121236a(a, serviceReferenceImpl);
            }
            return serviceReferenceImpl.getServiceRegistration();
        }

        public ServiceRegistration<?> registerService(String str, Object obj, Dictionary<String, ?> dictionary) {
            return registerService(new String[]{str}, obj, dictionary);
        }

        public <S> ServiceRegistration<S> registerService(Class<S> cls, S s, Dictionary<String, ?> dictionary) {
            return registerService(cls.getName(), (Object) s, dictionary);
        }

        public ServiceReference<?>[] getServiceReferences(String str, String str2) throws InvalidSyntaxException {
            return getAllServiceReferences(str, str2);
        }

        public ServiceReference<?>[] getAllServiceReferences(String str, String str2) throws InvalidSyntaxException {
            List<ServiceReference<?>> list;
            if (str == null) {
                list = AbstractBundle.this.f49204a.f49231m.mo121243c();
            } else {
                list = AbstractBundle.this.f49204a.f49231m.get((Object) str);
            }
            if (list != null) {
                return (ServiceReference[]) list.toArray(new ServiceReferenceImpl[list.size()]);
            }
            return null;
        }

        public ServiceReference<?> getServiceReference(String str) {
            ServiceReference<?>[] serviceReferenceArr;
            int i;
            ServiceReference<?> serviceReference = null;
            try {
                serviceReferenceArr = getServiceReferences(str, (String) null);
            } catch (InvalidSyntaxException unused) {
                serviceReferenceArr = null;
            }
            if (serviceReferenceArr == null) {
                return null;
            }
            int i2 = -1;
            long j = Long.MAX_VALUE;
            for (ServiceReference<?> serviceReference2 : serviceReferenceArr) {
                Integer num = (Integer) serviceReference2.getProperty(Constants.SERVICE_RANKING);
                if (num == null) {
                    i = 0;
                } else {
                    i = num.intValue();
                }
                long longValue = ((Long) serviceReference2.getProperty(Constants.SERVICE_ID)).longValue();
                if (i > i2 || (i == i2 && longValue < j)) {
                    serviceReference = serviceReference2;
                    i2 = i;
                    j = longValue;
                }
            }
            return serviceReference;
        }

        public <S> ServiceReference<S> getServiceReference(Class<S> cls) {
            return getServiceReference(cls.getName());
        }

        public <S> Collection<ServiceReference<S>> getServiceReferences(Class<S> cls, String str) throws InvalidSyntaxException {
            return Arrays.asList(getServiceReferences(cls.getName(), str));
        }

        public <S> S getService(ServiceReference<S> serviceReference) {
            return ((ServiceReferenceImpl) serviceReference).getService();
        }

        public Filter createFilter(String str) throws InvalidSyntaxException {
            return FrameworkUtil.createFilter(str);
        }

        public Bundle getBundle(String str) {
            return AbstractBundle.this.f49204a.mo121277a(str);
        }
    }
}
