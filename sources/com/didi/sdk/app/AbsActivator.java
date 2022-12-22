package com.didi.sdk.app;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public abstract class AbsActivator implements BundleActivator {
    /* access modifiers changed from: protected */
    public String[] getAssetBundles() {
        return new String[0];
    }

    public void start(BundleContext bundleContext) throws Exception {
    }

    public void stop(BundleContext bundleContext) throws Exception {
    }
}
