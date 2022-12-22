package com.didichuxing.swarm.runtime;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;

public abstract class SwarmPlugin implements BundleActivator {
    private static SwarmPlugin sInstance;
    private Bundle mBundle;

    public static SwarmPlugin getInstance() {
        return sInstance;
    }

    protected SwarmPlugin() {
        sInstance = this;
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    /* access modifiers changed from: package-private */
    public void setBundle(Bundle bundle) {
        this.mBundle = bundle;
    }
}
