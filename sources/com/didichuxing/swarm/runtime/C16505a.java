package com.didichuxing.swarm.runtime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.Version;

/* renamed from: com.didichuxing.swarm.runtime.a */
/* compiled from: BundleImpl */
class C16505a extends AbstractBundle {

    /* renamed from: j */
    private final Gson f49223j;

    /* renamed from: k */
    private BundleManifest f49224k = null;

    /* renamed from: l */
    private final String f49225l;

    /* renamed from: m */
    private final Version f49226m;

    public void stop(int i) throws BundleException {
    }

    public void uninstall() throws BundleException {
    }

    public void update() throws BundleException {
    }

    public void update(InputStream inputStream) throws BundleException {
    }

    public C16505a(C16506b bVar, BundleContext bundleContext, long j, String str, InputStream inputStream) {
        super(bVar, j, str);
        Gson create = new GsonBuilder().create();
        this.f49223j = create;
        try {
            this.f49224k = (BundleManifest) create.fromJson((Reader) new InputStreamReader(inputStream), BundleManifest.class);
        } catch (IncompatibleClassChangeError e) {
            e.printStackTrace();
        }
        if (this.f49224k == null) {
            this.f49224k = new BundleManifest();
        }
        this.f49225l = this.f49224k.getSymbolicName();
        this.f49226m = new Version(this.f49224k.getVersion());
        if (this.f49224k.getName() != null) {
            this.f49206c.put(Constants.BUNDLE_NAME, this.f49224k.getName());
        }
        if (this.f49224k.getSymbolicName() != null) {
            this.f49206c.put(Constants.BUNDLE_SYMBOLICNAME, this.f49224k.getSymbolicName());
        }
        if (this.f49224k.getDescription() != null) {
            this.f49206c.put(Constants.BUNDLE_DESCRIPTION, this.f49224k.getDescription());
        }
        if (this.f49224k.getActivator() != null) {
            this.f49206c.put(Constants.BUNDLE_ACTIVATOR, this.f49224k.getActivator());
        }
        if (this.f49224k.getVersion() != null) {
            this.f49206c.put(Constants.BUNDLE_VERSION, this.f49224k.getVersion());
        }
        if (this.f49224k.getVendor() != null) {
            this.f49206c.put(Constants.BUNDLE_VENDOR, this.f49224k.getVendor());
        }
        Map<String, String> dependencies = this.f49224k.getDependencies();
        if (dependencies != null) {
            this.f49206c.put("Bundle-Dependency", this.f49223j.toJson((Object) dependencies));
        }
    }

    public String getSymbolicName() {
        return this.f49225l;
    }

    public Version getVersion() {
        return this.f49226m;
    }

    public void start(int i) throws BundleException {
        mo121275a(i);
    }

    public void start() throws BundleException {
        start(0);
    }

    public void stop() throws BundleException {
        stop(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121275a(int i) throws BundleException {
        this.f49212i = 8;
        try {
            BundleActivator bundleActivator = (BundleActivator) loadClass(this.f49224k.getActivator()).newInstance();
            if (bundleActivator instanceof SwarmPlugin) {
                ((SwarmPlugin) bundleActivator).setBundle(this);
            }
            bundleActivator.start(this.f49205b);
            this.f49212i = 32;
        } catch (Exception e) {
            throw new BundleException("Error starting bundle " + toString(), 5, e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121274a() throws BundleException {
        this.f49204a.f49228j.put(Long.valueOf(getBundleId()), this);
        this.f49204a.f49229k.put(getLocation(), this);
        this.f49204a.f49230l.mo121236a(getSymbolicName(), this);
    }
}
