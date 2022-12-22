package com.didichuxing.swarm.runtime;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.Version;
import org.osgi.framework.launch.Framework;

/* renamed from: com.didichuxing.swarm.runtime.b */
/* compiled from: Swarm */
class C16506b extends AbstractBundle implements Framework {

    /* renamed from: r */
    private static final String f49227r = "Swarm";

    /* renamed from: j */
    protected final Map<Long, AbstractBundle> f49228j = new HashMap(1);

    /* renamed from: k */
    protected final Map<String, AbstractBundle> f49229k = new HashMap(1);

    /* renamed from: l */
    protected final MultiMap<String, AbstractBundle> f49230l = new MultiMap<>(1);

    /* renamed from: m */
    protected final MultiMap<String, ServiceReference<?>> f49231m = new MultiMap<>();

    /* renamed from: n */
    protected final Properties f49232n = new Properties(System.getProperties());

    /* renamed from: o */
    protected final List<FrameworkListener> f49233o = new ArrayList(1);

    /* renamed from: p */
    final ClassLoader f49234p;

    /* renamed from: q */
    final ClassLoader f49235q = getClass().getClassLoader();

    /* renamed from: s */
    private final AtomicLong f49236s = new AtomicLong(0);

    /* renamed from: t */
    private final Version f49237t = new Version(BuildConfig.VERSION.replaceAll("\\-SNAPSHOT", ""));

    public final long getBundleId() {
        return 0;
    }

    public final String getLocation() {
        return Constants.SYSTEM_BUNDLE_LOCATION;
    }

    public final String getSymbolicName() {
        return Constants.SYSTEM_BUNDLE_SYMBOLICNAME;
    }

    public void uninstall() throws BundleException {
    }

    public void update() throws BundleException {
    }

    public void update(InputStream inputStream) throws BundleException {
    }

    public FrameworkEvent waitForStop(long j) throws InterruptedException {
        return null;
    }

    public C16506b(Map<String, String> map) {
        String property = this.f49232n.getProperty(Constants.FRAMEWORK_BUNDLE_PARENT);
        if ("app".equals(property)) {
            this.f49234p = ClassLoader.getSystemClassLoader();
        } else if ("framework".equals(property)) {
            this.f49234p = this.f49235q;
        } else if ("ext".equals(property)) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            while (systemClassLoader.getParent() != null) {
                systemClassLoader = systemClassLoader.getParent();
            }
            this.f49234p = systemClassLoader;
        } else {
            this.f49234p = new Swarm$1(this, Object.class.getClassLoader());
        }
    }

    public final Version getVersion() {
        return this.f49237t;
    }

    public void init() throws BundleException {
        init(new FrameworkListener[0]);
    }

    public void init(FrameworkListener... frameworkListenerArr) throws BundleException {
        if (32 != this.f49212i && 8 != this.f49212i && 16 != this.f49212i) {
            if (frameworkListenerArr != null && frameworkListenerArr.length > 0) {
                for (FrameworkListener frameworkListener : frameworkListenerArr) {
                    if (frameworkListener != null) {
                        this.f49233o.add(frameworkListener);
                    }
                }
            }
            this.f49228j.put(Long.valueOf(getBundleId()), this);
            this.f49229k.put(getLocation(), this);
            this.f49230l.mo121236a(getSymbolicName(), this);
            this.f49232n.setProperty(Constants.FRAMEWORK_UUID, UUID.randomUUID().toString());
            this.f49212i = 8;
        }
    }

    public void start() throws BundleException {
        start(0);
    }

    public void start(int i) throws BundleException {
        if (32 != this.f49212i) {
            if (8 != this.f49212i) {
                init();
            }
            this.f49212i = 32;
            mo121281a(1, (Bundle) this, (Throwable) null);
        }
    }

    public void stop() throws BundleException {
        stop(0);
    }

    public void stop(int i) throws BundleException {
        new Thread(new Swarm$2(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo121280a() {
        this.f49212i = 16;
        this.f49228j.clear();
        this.f49207d.clear();
        this.f49212i = 4;
    }

    /* renamed from: a */
    public Bundle mo121276a(long j) {
        return this.f49228j.get(Long.valueOf(j));
    }

    /* renamed from: a */
    public Bundle mo121277a(String str) {
        return this.f49229k.get(str);
    }

    /* renamed from: b */
    public Bundle[] mo121283b() {
        return (Bundle[]) this.f49228j.values().toArray(new Bundle[this.f49228j.size()]);
    }

    /* renamed from: a */
    public Bundle mo121278a(BundleContext bundleContext, String str) throws BundleException {
        String str2;
        if (str.indexOf(":") > -1) {
            str2 = str;
        } else {
            str2 = "file:." + File.separator + str;
        }
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = new URL(str2).openConnection().getInputStream();
            Bundle a = mo121279a(bundleContext, str, inputStream2);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused) {
                }
            }
            return a;
        } catch (IOException e) {
            throw new BundleException("Cannot retrieve bundle from " + str, 11, e);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public Bundle mo121279a(BundleContext bundleContext, String str, InputStream inputStream) throws BundleException {
        C16505a aVar = new C16505a(this, bundleContext, this.f49236s.incrementAndGet(), str, inputStream);
        aVar.mo121274a();
        return aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo121281a(int i, Bundle bundle, Throwable th) {
        List<FrameworkListener> list = this.f49233o;
        mo121282a((FrameworkListener[]) list.toArray(new FrameworkListener[list.size()]), i, bundle, th);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo121282a(FrameworkListener[] frameworkListenerArr, int i, Bundle bundle, Throwable th) {
        if (frameworkListenerArr != null && frameworkListenerArr.length > 0) {
            FrameworkEvent frameworkEvent = new FrameworkEvent(i, bundle, th);
            for (FrameworkListener frameworkListener : frameworkListenerArr) {
                if (frameworkListener != null) {
                    frameworkListener.frameworkEvent(frameworkEvent);
                }
            }
        }
    }
}
