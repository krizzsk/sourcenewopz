package org.osgi.framework.hooks.bundle;

import java.util.Collection;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;

public interface EventHook {
    void event(BundleEvent bundleEvent, Collection<BundleContext> collection);
}
