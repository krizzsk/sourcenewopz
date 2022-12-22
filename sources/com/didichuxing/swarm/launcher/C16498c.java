package com.didichuxing.swarm.launcher;

import android.app.Application;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.didichuxing.swarm.toolkit.ConfigurationService;
import com.didiglobal.enginecore.cache.XECacheConfig;
import java.io.IOException;
import java.io.InputStream;
import org.osgi.framework.BundleContext;
import org.osgi.framework.launch.Framework;

/* renamed from: com.didichuxing.swarm.launcher.c */
/* compiled from: ConfigurationServiceImpl */
class C16498c implements ConfigurationService {

    /* renamed from: a */
    private final Framework f49196a;

    C16498c(Framework framework) {
        this.f49196a = framework;
    }

    public InputStream getConfiguration(String str) throws IOException {
        if (!TextUtils.isEmpty(str)) {
            BundleContext bundleContext = this.f49196a.getBundleContext();
            AssetManager assets = ((Application) bundleContext.getService(bundleContext.getServiceReference(Application.class))).getAssets();
            return assets.open("swarm/config/" + str + XECacheConfig.XE_CACHE_DEFAULT_FILE);
        }
        throw new IllegalArgumentException("Bundle symbolic name must not be null");
    }
}
