package org.osgi.framework.hooks.bundle;

import java.util.Collection;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public interface FindHook {
    void find(BundleContext bundleContext, Collection<Bundle> collection);
}
